package Logica;

import Datos.DEventos;
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
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        try {

            List<DEventos> TablaEventos;

            TablaEventos = MostrarDatos(id);

            request.setAttribute("Eventos", TablaEventos);

            request.setAttribute("id", id);

            request.getRequestDispatcher("/EventosFan.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<DEventos> MostrarDatos(int id) throws Exception {

        List<DEventos> eventos = new ArrayList<>();

        consulta = "SELECT * FROM EVENTOS WHERE fk_usuario = ?";

        PreparedStatement st = con.prepareStatement(consulta);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int codigo = rs.getInt("Pk_idEventos");
            int evento = rs.getInt("Fk_idTipoEvento");
            String titulo = rs.getString("Titulo");
            String fecha = rs.getString("Fecha_de_evento");
            String ubicacion = rs.getString("Ubicacion");
            String contenido = rs.getString("Contenido");
            int usuario = rs.getInt("fk_usuario");

            DEventos eventoTemporal = new DEventos(codigo, evento, titulo, fecha, ubicacion, contenido, usuario);
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

//            case "Cargar":
//                CargarEvento(request, response);
//                break;
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
//        switch (accion) {
//            case "Escribir":
//                EscribirEvento(request, response);
//                break;
//
//            case "Actualizar":
//                ActualizarEvento(request, response);
//                break;
//
//        }

    }

}
