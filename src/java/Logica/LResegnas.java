package Logica;

import Datos.*;
import Logica.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LResegnas", urlPatterns = {"/LResegnas"})
public class LResegnas extends HttpServlet {

    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

    //-----------------Mostrar datos desde la base de datos---------------------//
    public List<DResegnas> ObtenerResegnas() throws Exception {
        List<DResegnas> resegnas = new ArrayList<>();

        consulta = "select res.idReseña, art.Nombre_BandaArtistico, alb.Nombre, res.Descripcion, res.Calificacion, res.Fecha\n"
                + " FROM reseña res inner join artista art\n"
                + " on res.fk_artista = art.fk_usuario\n"
                + " inner join album alb\n"
                + " on res.fk_album = alb.idAlbum";

//        consulta = "SELECT * FROM RESEÑA";
        PreparedStatement st = con.prepareStatement(consulta);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {

            int codigo = rs.getInt("idReseña");
            String artista = rs.getString("Nombre_BandaArtistico");
            String album = rs.getString("Nombre");
            String descripcion = rs.getString("Descripcion");
            Double calificacion = rs.getDouble("Calificacion");
            String fecha = rs.getString("Fecha");

            DResegnas reseñaTemporal = new DResegnas(codigo, artista, album, descripcion, calificacion, fecha);
            resegnas.add(reseñaTemporal);
        }

        return resegnas;
    }

    public List<DArtista> CargarComboArtista() throws Exception {
        List<DArtista> artistas = new ArrayList<>();

        consulta = "SELECT fk_usuario, Nombre_BandaArtistico FROM artista ";

        PreparedStatement st = con.prepareStatement(consulta);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {

            int codigo = rs.getInt("fk_usuario");
            String artista = rs.getString("Nombre_BandaArtistico");

            DArtista resegnaTemporal = new DArtista(codigo, artista);
            artistas.add(resegnaTemporal);
        }

        return artistas;
    }

    private void MostrarArtistasCombo(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("idUsuario");

        try {
            List<DArtista> ComboArtistas;

            ComboArtistas = CargarComboArtista();

            request.setAttribute("CbxArtista", ComboArtistas);

            request.setAttribute("id", id);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<DAlbumes> CargarComboAlbumes() throws Exception {
        List<DAlbumes> album = new ArrayList<>();

        consulta = "SELECT * FROM album ";

        PreparedStatement st = con.prepareStatement(consulta);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {

            int codigo = rs.getInt("idAlbum");
            String nombreAlbum = rs.getString("Nombre");

            DAlbumes albumTemporal = new DAlbumes(codigo, nombreAlbum);
            album.add(albumTemporal);
        }

        return album;
    }

    private void MostrarAlbumCombo(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("idUsuario");

        try {
            List<DAlbumes> ComboAlbum;

            ComboAlbum = CargarComboAlbumes();

            request.setAttribute("CbxAlbum", ComboAlbum);

            request.setAttribute("id", id);

        } catch (Exception e) {
            e.printStackTrace();

        }
//        LAlbum a = new LAlbum();
//        List<DAlbumes> TablaAlbumes;
//        TablaAlbumes = a.MostrarDatos(0);
//        request.setAttribute("Albumes", TablaAlbumes);
    }

    private void MostrarResegnas(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("idUsuario");
        try {

            List<DResegnas> TablaResegnas;

            TablaResegnas = ObtenerResegnas();

            request.setAttribute("Reseña", TablaResegnas);

            request.setAttribute("id", id);

            MostrarArtistasCombo(request, response);
            MostrarAlbumCombo(request, response);

            request.getRequestDispatcher("/Resegnas.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
//-----------------Eliminar reseña ---------------------//

    private void EliminarResegna(HttpServletRequest request, HttpServletResponse response) {

        int idResegna = Integer.parseInt(request.getParameter("Codigo"));

        try {
            if (EliminarResegnas(idResegna) == 0) {

                request.setAttribute("botones", "error");
                MostrarResegnas(request, response);

            } else {

                MostrarResegnas(request, response);
            }
        } catch (Exception ex) {

        }
    }

    public int EliminarResegnas(int id) throws Exception {
        int result = 0;
        consulta = "DELETE FROM RESEÑA WHERE idReseña=?";
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
            accion = "Mostrar";
        }
        switch (accion) {

            case "Mostrar":
                MostrarResegnas(request, response);
                break;

            case "Eliminar":
                EliminarResegna(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");

        if (accion.equals(null)) {
            accion = "Mostrar";
        }
        switch (accion) {

            case "Mostrar":
                MostrarResegnas(request, response);
                break;

            case "Insertar":
                InsertarResegna(request, response);
                break;

        }

    }

    private void InsertarResegna(HttpServletRequest request, HttpServletResponse response) {
//        String Art = request.getParameter("idArtista");
//        String Alb =request.getParameter("idAlbum");
        try {

            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_publicacion = date.format(now);

            DResegnas r = new DResegnas();
            r.setFk_artista(Integer.parseInt(request.getParameter("Artista_Banda")));
            r.setFk_album(Integer.parseInt(request.getParameter("Album")));
            r.setDescripcion(request.getParameter("desc"));
            r.setCalificacion(Double.parseDouble(request.getParameter("calificacion")));
            r.setFecha(fecha_publicacion);

            InsertarResegna(r);

            MostrarResegnas(request, response);


        } catch (Exception e) {

        }
//                    try (PrintWriter out = response.getWriter()) {
//                out.println("Codigo 1 "+Art+"Codigo 2 "+Alb);
//            } catch (Exception e) {
//            }
    }

    private String InsertarResegna(DResegnas r) {
        String result = "";

        //Se agregan los valores a la consulta
        consulta = "INSERT INTO reseña(fk_artista,fk_album,Descripcion,Calificacion,Fecha)"
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, r.getFk_artista());
            st.setInt(2, r.getFk_album());
            st.setString(3, r.getDescripcion());
            st.setDouble(4, r.getCalificacion());
            st.setString(5, r.getFecha());
            st.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
