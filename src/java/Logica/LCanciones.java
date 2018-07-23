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

    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

    public String IngresarNuevaCancion(DCanciones a) {
        String result = "";
        consulta = "INSERT INTO `cancion`('`Nombre`, `FK_album`, `Fecha_publicacion`, `fk_genero`, `descripcion`, `sello_discografico`, `duracion`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setString(1, a.getNombre());
            st.setInt(2, a.getFK_album());
            st.setString(3, a.getFecha_publicacion());
            st.setInt(4, a.getFk_genero());
            st.setInt(4, a.getFk_genero());

            int num = st.executeUpdate();
            if (num != 0) {
                result = "Registro ingresado correctamente";
            }
            st.close();
            con.close();
        } catch (Exception e) {
            result = "Hemos encontrado un error:\n" + e.getMessage();
        }

        return result;
    }

    public String EliminarCancion(DCanciones obj) {
        String result = "";
        consulta = "DELETE FROM `cancion` WHERE `idCancion`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, obj.getIdCancion());
            //EliminarCanciones(ar.getIdAlbum());
            int num = st.executeUpdate();
            if (num != 0) {
                result = "Registro ingresado correctamente";
            }
            st.close();
            con.close();
        } catch (Exception e) {
            result = "Hemos encontrado un error:\n" + e.getMessage();
        }

        return result;
    }

    public String EliminarCanciones(DCanciones obj) {
        String result = "";
        consulta = "DELETE FROM `cancion` WHERE `FK_album`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, obj.getFK_album());
            //EliminarCanciones(ar.getIdAlbum());
            int num = st.executeUpdate();
            if (num != 0) {
                result = "Registro ingresado correctamente";
            }
            st.close();
            con.close();
        } catch (Exception e) {
            result = "Hemos encontrado un error:\n" + e.getMessage();
        }

        return result;
    }

    public List<DCanciones> MostrarCanciones(int idA) throws Exception {
        List<DCanciones> generos = new ArrayList<>();

        consulta = "SELECT `idAlbum`, `Nombre` FROM `album` WHERE fk_artista =?";

        PreparedStatement st = con.prepareStatement(consulta);
        st.setInt(1, idA);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("idAlbum");
            String nombre = rs.getString("Nombre");

            DCanciones generoTemporal = new DCanciones(id, nombre);
            generos.add(generoTemporal);
        }

        return generos;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
