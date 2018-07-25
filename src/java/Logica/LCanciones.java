/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DCanciones;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LCanciones", urlPatterns = {"/LCanciones"})
public class LCanciones extends HttpServlet {

//------------------------Conecciópn a la base de datos-------------------------
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

//--------------------------Ingresa un nuevo registro---------------------------
    public void IngresarNuevaCancion(DCanciones a) {
        consulta = "INSERT INTO `cancion`('`Nombre`,`duracion`, FK_album) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setString(1, a.getNombre());
            st.setString(2, a.getDuracion());
            st.setInt(3, a.getAlbum());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

//-------------------------Eliminar canción por el id---------------------------
    public void EliminarCancion(DCanciones obj) {
        consulta = "DELETE FROM `cancion` WHERE `idCancion`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, obj.getIdCancion());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

//-------------------Elimina las todas canciones de un álbum--------------------
    public void EliminarCanciones(int obj) {

        consulta = "DELETE FROM `cancion` WHERE `FK_album`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, obj);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

//------------------------Muestra todas las canciones-------------------------
    public List<DCanciones> MostrarCanciones() throws Exception {
        List<DCanciones> canciones = new ArrayList<>();

        consulta = "SELECT cancion.Nombre, album.Nombre as NombreAlbum, cancion.duracion, cancion.idCancion FROM cancion, album where album.idAlbum = cancion.FK_album and cancion.idCancion = ?";

        PreparedStatement st = con.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int codigo = rs.getInt("idGenero_musical");
            String nombre = rs.getString("Nombre");
            String duracion = rs.getString("duracion");
            String album = rs.getString("NombreAlbum");
            DCanciones cancionTemp = new DCanciones(codigo, nombre, duracion, album);
            canciones.add(cancionTemp);
        }

        return canciones;
    }

//------------------------Muestra una canción por el id-------------------------
    public DCanciones ObtenerCanciones(int idCancion) throws Exception {
        DCanciones obj = null;

        consulta = "SELECT * FROM GENERO_MUSICAL WHERE IDGENERO_MUSICAL=?";

        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, idCancion);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idGenero_musical");
                String nombre = rs.getString("Nombre");
                String duracion = rs.getString("Descripcion");
                // String album = rs.getString("Nopmbre")

                //obj = new DCanciones(id, nombre, duracion, album);
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
            accion = "Mostrar";
        }
        switch (accion) {

            case "Cargar":
                CargarCancion(request, response);
                break;

            case "Eliminar":
                EliminarCancion(request, response);
                break;

            case "Mostrar":
                MostrarCanciones(request, response);
                break;
        }
    }

    private void CargarCancion(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void EliminarCancion(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");

        if (accion.equals(null)) {
            accion = "Mostrar";
        }
        switch (accion) {

            case "Insertar":
                InsertarCancion(request, response);
                break;

            case "Mostrar":
                MostrarCanciones(request, response);
                break;

            case "Actualizar":
                ActualizarCancion(request, response);
                break;
        }
    }

    private void InsertarCancion(HttpServletRequest request, HttpServletResponse response) {

    }

    private void MostrarCanciones(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        try {

            List<DCanciones> TablaGeneros;

            TablaGeneros = MostrarCanciones();

            request.setAttribute("Canciones", TablaGeneros);
            request.setAttribute("id", id);

            request.getRequestDispatcher("/EditarCanciones.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void ActualizarCancion(HttpServletRequest request, HttpServletResponse response) {

    }

}
