/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DAlbumes;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Moreno S
 */
@WebServlet(name = "LAlbum", urlPatterns = {"/LAlbum"})
public class LAlbum extends HttpServlet {

    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

    public void IngresarNuevoAlbum(DAlbumes a) {

        consulta = "INSERT INTO `album`(`Nombre`, `Descripcion`, `fk_artista`, `fecha_lanzamiento`) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setString(1, a.getNombre());
            st.setString(2, a.getDescripcion());
            st.setInt(3, a.getFk_artista());
            st.setString(4, a.getFechaLancimiento());

            int num = st.executeUpdate();
            if (num != 0) {

            }
            st.close();
            con.close();
        } catch (Exception e) {

        }

    }

    public String EliminarAlbum(DAlbumes ar) {
        String result = "";
        consulta = "DELETE FROM `album` WHERE `idAlbum`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, ar.getIdAlbum());
            //EliminarCanciones(ar.getIdAlbum());
            int num = st.executeUpdate();
            if (num != 0) {
                result = "Registro Eliminado correctamente";
            }
            st.close();
            con.close();
        } catch (Exception e) {
            result = "Hemos encontrado un error:\n" + e.getMessage();
        }

        return result;
    }

    //-----------------Mostrar album---------------------//
    public List<DAlbumes> MostrarDatos(int id) throws Exception {

        List<DAlbumes> album = new ArrayList<>();

        //Consulta para que muestre del album el codigo, nombre y descripcion y del artista la banda o nombre artistico
        consulta = "SELECT album.idAlbum, album.Nombre, album.Descripcion, album.fecha_lanzamiento, artista.Nombre_BandaArtistico "
                + "FROM album, artista "
                + "where album.fk_artista = artista.fk_usuario and album.fk_artista =?";

        PreparedStatement st = con.prepareStatement(consulta);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int codigo = rs.getInt("idAlbum");
            String nombre = rs.getString("Nombre");
            String descripcion = rs.getString("Descripcion");
            String fecha = rs.getString("fecha_lanzamiento");
            String artista = rs.getString("Nombre_BandaArtistico");
            DAlbumes AlbumTemporal = new DAlbumes(codigo, nombre, descripcion, fecha, artista);
            album.add(AlbumTemporal);
        }

        return album;
    }

    private void ObtenerAlbum(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {

            List<DAlbumes> TablaAlbumes;

            TablaAlbumes = MostrarDatos(id);

            request.setAttribute("Album", TablaAlbumes);

            request.setAttribute("id", id);
            //request.setAttribute("rep", rep);

            request.getRequestDispatcher("/EditarAlbumes.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void IngresarAlbum(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {

            DAlbumes a = new DAlbumes();
            a.setFk_artista(id);
            a.setDescripcion(request.getParameter("desc"));
            a.setFechaLancimiento(request.getParameter("fecha"));
            a.setNombre(request.getParameter("nombre"));
            IngresarNuevoAlbum(a);

            request.setAttribute("id", id);
            ObtenerAlbum(request, response);
            //request.setAttribute("saludo", "RegistroCompletado");
            //request.getRequestDispatcher("/IngresarAlbum.jsp").forward(request, response);
            // ObtenerAlbum(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void EliminarAlbum(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        int codigo = Integer.parseInt(request.getParameter("Codigo"));
        try {
            DAlbumes d = new DAlbumes();
            d.setIdAlbum(codigo);
            EliminarAlbum(d);

            request.setAttribute("id", id);
            request.setAttribute("saludo", "RegistroCompletado");
            //ObtenerAlbum(request, response);
            request.getRequestDispatcher("/IngresarAlbum.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");
        //int id = Integer.parseInt(request.getParameter("idUsuario"));
        //int codigo = Integer.parseInt(request.getParameter("Codigo"));

        if (accion.equals(null)) {
            accion = "Mostrar";
        }
        switch (accion) {

            case "IngresarAlbum":
                IngresarAlbum(request, response);
                break;

            case "Mostrar":
                ObtenerAlbum(request, response);
                break;

            case "Eliminar":
                EliminarAlbum(request, response);
                break;
        }

    }

    /* try (PrintWriter out = response.getWriter()) {
                    out.println("Mostrar" + accion);
                } catch (Exception e) {
                }*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");
        int id = Integer.parseInt(request.getParameter("idUsuario"));

        if (accion.equals("Regresar")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/PaginaPrincipalArtista.jsp").forward(request, response);
        }
        if (accion.equals("IrIngresar")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/IngresarAlbum.jsp").forward(request, response);
        }
        /* String rep = null;
        if (accion.equals("IngresarAlbum")) {

            try {
                DAlbumes a = new DAlbumes();
                a.setFk_artista(id);
                a.setDescripcion(request.getParameter("desc"));
                a.setFechaLancimiento(request.getParameter("fecha"));
                a.setNombre(request.getParameter("nombre"));
                IngresarNuevoAlbum(a);

                List<DAlbumes> TablaAlbumes;

                TablaAlbumes = MostrarDatos(id);

                request.setAttribute("Album", TablaAlbumes);
                request.setAttribute("id", id);
                request.setAttribute("saludo", "RegistroCompletado");
                request.getRequestDispatcher("/IngresarAlbum.jsp").forward(request, response);
                //accion = "Mostrar";

            } //Fin ingresar
            catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }

        if (accion.equals("Mostrar")) {
            try {

                List<DAlbumes> TablaAlbumes;

                TablaAlbumes = MostrarDatos(id);

                request.setAttribute("Album", TablaAlbumes);

                request.setAttribute("id", id);
                //request.setAttribute("rep", rep);

                request.getRequestDispatcher("/IngresarAlbum.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }*/
    }

}
