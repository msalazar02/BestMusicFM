/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DArtista;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import java.nio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Rodrigo Moreno S
 */
@WebServlet(name = "LArtistas", urlPatterns = {"/LArtistas"})
public class LArtistas extends HttpServlet {

    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";
   

    //---------------------Ingresar nuevo artista-------------------------------
    public String IngresarNuevoArtista(DArtista ar) {
        String result = "";
        consulta = "INSERT INTO `artista`(`fk_usuario`, `Tipo_artista`, `Fecha_Inicio`, `fk_generMusical`, `Fotografia`, `Biografia`, `Nombre_BandaArtistico`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, ar.getFkUsuario());
            st.setString(2, ar.getTipoArtista());
            st.setString(3, ar.getFechaIncio());
            st.setInt(4, ar.getGenero());
            st.setInt(5, ar.getImagen());
            st.setString(6, ar.getBiografia());
            st.setString(7, ar.getNombreBanda());

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

    //---------------------Actualizar Artista-------------------------------
    public String ActualizarArtista(DArtista ar) {
        String result = "";
        consulta = "UPDATE `artista` SET `Tipo_artista`= ?,`Fecha_Inicio`= ?,`fk_generMusical`= ?,"
                + "`Fotografia`= ?,`Biografia`= ?,`Nombre_BandaArtistico`= ? WHERE `fk_usuario`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setString(1, ar.getTipoArtista());
            st.setString(2, ar.getFechaIncio());
            st.setInt(3, ar.getGenero());
            st.setInt(4, ar.getImagen());
            st.setString(5, ar.getBiografia());
            st.setString(6, ar.getNombreBanda());
            st.setInt(7, ar.getFkUsuario());

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

    //---------------------Actualizar Artista-------------------------------
    public String EliminarArtista(DArtista ar) {
        String result = "";
        consulta = "DELETE FROM `artista` WHERE `fk_usuario`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, ar.getFkUsuario());

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
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("Accion");
        int id = Integer.parseInt(request.getParameter("idUsuario"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String accion = request.getParameter("Accion");

        if (accion.equals("IngresarArtista")) {

            DArtista d = new DArtista();
            d.setFkUsuario(id);
            d.setBiografia(request.getParameter("biografia"));
            d.setFechaIncio(request.getParameter("fecha"));
            d.setImagen(1);
            d.setGenero(Integer.parseInt(request.getParameter("generoM")));
            d.setTipoArtista(request.getParameter("TipoArtista"));
            d.setBiografia(request.getParameter("biografia"));

            IngresarNuevoArtista(d);
            request.setAttribute("saludo", "RegistroCompletado");
            request.getRequestDispatcher("/PaginaInicio.jsp").forward(request, response);

            /*try (PrintWriter out = response.getWriter()) {
                out.println("value  " + IngresarNuevoArtista(d));
            } catch (Exception e) {
            }*/
        }//Fin ingresar

        if (accion.equals("ActualizarArtista")) {

            DArtista d = new DArtista();
            d.setFkUsuario(id);
            d.setBiografia(request.getParameter("biografia"));
            d.setFechaIncio(request.getParameter("fecha"));
            d.setImagen(1);
            d.setGenero(Integer.parseInt(request.getParameter("generoM")));
            d.setTipoArtista(request.getParameter("TipoArtista"));
            d.setBiografia(request.getParameter("biografia"));

            ActualizarArtista(d);
            request.setAttribute("id", id);
            request.getRequestDispatcher("/???.jsp").forward(request, response);

            /*try (PrintWriter out = response.getWriter()) {
                out.println("value  " + IngresarNuevoArtista(d));
            } catch (Exception e) {
            }*/
        }//Fin Actualizar EliminarArtista

        if (accion.equals("EliminarArtista")) {

            DArtista d = new DArtista();
            d.setFkUsuario(id);

            EliminarArtista(d);
            request.setAttribute("id", id);
            request.setAttribute("saludo", "Eliminado");
            request.getRequestDispatcher("/PaginaInicio.jsp").forward(request, response);

            /*try (PrintWriter out = response.getWriter()) {
                out.println("value  " + IngresarNuevoArtista(d));
            } catch (Exception e) {
            }*/
        }//Fin EliminarArtista
    }//Fin doPost

}//Fin LArtistas
