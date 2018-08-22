package Logica;

import Datos.DAlbumes;
import Datos.DEventos;
//import Datos.DTipoEventos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LEventos", urlPatterns = {"/LEventos"})
public class LEventos extends HttpServlet {

    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

//---------------------Mostrar eventos escritos por el fan loggeado---------------------//
    private void Visualizar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {

            List<DEventos> TablaEventos;
            TablaEventos = MostrarDatos(id);
            request.setAttribute("Eventos", TablaEventos);

            List<DEventos> Eventos;
            Eventos = TipoDeEventos();
            request.setAttribute("TipoEventos", Eventos);
            request.setAttribute("id", id);

            request.getRequestDispatcher("/EventosFan.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<DEventos> MostrarDatos(int id) throws Exception {

        List<DEventos> eventos = new ArrayList<>();

        consulta = "select eve.Pk_idEventos, eve.Titulo, eve.Fecha_de_evento, eve.Ubicacion, eve.Contenido, tip.Nombre as TipoEvento from eventos eve inner join tipoevento tip on eve.Fk_idTipoEvento = tip.Pk_idTipoEvento WHERE fk_usuario = ?";
        PreparedStatement st = con.prepareStatement(consulta);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int codigo = rs.getInt("Pk_idEventos");
            String titulo = rs.getString("Titulo");
            String fecha = rs.getString("Fecha_de_evento");
            String ubicacion = rs.getString("Ubicacion");
            String contenido = rs.getString("Contenido");
            String evento = rs.getString("TipoEvento");

            DEventos eventoTemporal = new DEventos(codigo, titulo, fecha, ubicacion, contenido, evento);
            eventos.add(eventoTemporal);
        }

        return eventos;
    }

    public List<DEventos> TipoDeEventos() throws Exception {

        List<DEventos> eventos = new ArrayList<>();

        consulta = "select * from tipoevento";
        PreparedStatement st = con.prepareStatement(consulta);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            int idEvento = rs.getInt("Pk_idTipoEvento");
            String evento = rs.getString("Nombre");

            DEventos eventoTemporal = new DEventos(idEvento, evento);
            eventos.add(eventoTemporal);
        }

        return eventos;
    }

    //---------------------Eliminar eventos---------------------//
    private void EliminarEventos(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        int idEvento = Integer.parseInt(request.getParameter("Codigo"));

        try {
            EliminarEvento(idEvento);
            request.setAttribute("id", id);
            Visualizar(request, response);
        } catch (Exception ex) {

        }
    }

    public int EliminarEvento(int id) throws Exception {
        int result = 0;
        consulta = "DELETE FROM EVENTOS WHERE Pk_idEventos = ?";
        PreparedStatement pst = con.prepareStatement(consulta);
        try {

            pst.setInt(1, id);

            result = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //-----------------Mostrar evento---------------------//
    private void CargarEvento(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            int idEvento = Integer.parseInt(request.getParameter("Codigo"));
            DEventos evento = ObtenerEvento(idEvento);

            request.setAttribute("EventoActualizar", evento);
            request.setAttribute("id", id);
            request.setAttribute("botones", "Actualizar");

            Visualizar(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public DEventos ObtenerEvento(int idEvento) throws Exception {
        DEventos obj = null;

        consulta = "SELECT * FROM eventos WHERE Pk_idEventos=?";

        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, idEvento);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                int codigo = rs.getInt("Pk_idEventos");
                String titulo = rs.getString("Titulo");
                String fecha = rs.getString("Fecha_de_evento");
                String ubicacion = rs.getString("Ubicacion");
                String contenido = rs.getString("Contenido");
                int evento = rs.getInt("Fk_idTipoEvento");

                obj = new DEventos(codigo, evento, titulo, fecha, ubicacion, contenido);

            } else {
                throw new Exception("No hay datos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");

        if (accion.equals(null)) {
            accion = "Visualizar";
        }
        switch (accion) {
            case "Visualizar":
                Visualizar(request, response);
                break;

            case "Cargar":
                CargarEvento(request, response);
                break;

            case "Eliminar":
                EliminarEventos(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");
        if (accion.equals(null)) {
            accion = "Visualizar";
        }
        switch (accion) {
            case "Escribir":
                EscribirEvento(request, response);
                break;

            case "Visualizar":
                Visualizar(request, response);
                break;

            case "Actualizar":
                ActualizarEventos(request, response);
                break;

        }

    }
    //---------------------Actualizar eventos---------------------//

    private void ActualizarEventos(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {

            int idEvento = Integer.parseInt(request.getParameter("CodigoEvento"));
            int evento = Integer.parseInt(request.getParameter("tipo"));
            String titulo = request.getParameter("titulo");
            String fecha = request.getParameter("fecha");
            String ubicacion = request.getParameter("ubicacion");
            String contenido = request.getParameter("contenido");

            DEventos EventoActualizado = new DEventos(idEvento, evento, titulo, fecha, ubicacion, contenido);

            ActualizarEvento(EventoActualizado);
            request.setAttribute("id", id);
            Visualizar(request, response);

        } catch (Exception ex) {

        }
    }

    public void ActualizarEvento(DEventos EventoActualizado) throws Exception {

        consulta = "UPDATE eventos SET Fk_idTipoEvento=?,"
                + "Titulo=?, Fecha_de_evento=?, Ubicacion = ?,Contenido = ? WHERE Pk_idEventos = ?";

        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, EventoActualizado.getFk_idTipoEvento());
            st.setString(2, EventoActualizado.getTitulo());
            st.setString(3, EventoActualizado.getFecha_de_evento());
            st.setString(4, EventoActualizado.getUbicacion());
            st.setString(5, EventoActualizado.getContenido());
            st.setInt(6, EventoActualizado.getPk_idEventos());

            st.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //---------------------Insertar eventos---------------------//

    private void EscribirEvento(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {
            DEventos a = new DEventos();
            a.setIdEvento(Integer.parseInt(request.getParameter("tipo")));
            a.setTitulo(request.getParameter("titulo"));
            a.setFecha_de_evento(request.getParameter("fecha"));
            a.setUbicacion(request.getParameter("ubicacion"));
            a.setContenido(request.getParameter("contenido"));
            a.setFk_usuario(id);

            InsertarEvento(a);
            request.setAttribute("id", id);
            Visualizar(request, response);
        } catch (Exception e) {

        }

    }

    public void InsertarEvento(DEventos a) {

        consulta = "INSERT INTO eventos(`Fk_idTipoEvento`, `Titulo`, `Fecha_de_evento`, `Ubicacion`, `Contenido`, `fk_usuario`) VALUES (?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, a.getIdEvento());
            st.setString(2, a.getTitulo());
            st.setString(3, a.getFecha_de_evento());
            st.setString(4, a.getUbicacion());
            st.setString(5, a.getContenido());
            st.setInt(6, a.getFk_usuario());
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
}
