/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DExpertos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Moreno S
 */
@WebServlet(name = "LExpertos", urlPatterns = {"/LExpertos"})
public class LExpertos extends HttpServlet {

    
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";
    
    //----------------Ingresar un nuevo artista------------------------
    public String IngresarNuevoArtista(DExpertos ar) {
        String result = "";
        consulta = "INSERT INTO `expertos`(`fk_usuario`, `Fecha_inicio`, `fk_genero`, `Descripcion`) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, ar.getFk_usuario());
            st.setString(2, ar.getFechaInicio());
            st.setInt(3, ar.getFk_genero());
            st.setString(4, ar.getDescripcion());

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

    //---------------------Actualizar experto-------------------------------
    public String ActualizarArtista(DExpertos ar) {
        String result = "";
        consulta = "UPDATE `expertos` SET `Fecha_inicio`= ?,`fk_genero`= ?,"
                + "`Descripcion`= ? WHERE = ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(4, ar.getFk_usuario());
            st.setString(1, ar.getFechaInicio());
            st.setInt(2, ar.getFk_genero());
            st.setString(3, ar.getDescripcion());
            

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

    //---------------------Eliminar experto-------------------------------
    public String EliminarExperto(DExpertos ar) {
        String result = "";
        consulta = "DELETE FROM `artista` WHERE `fk_usuario`= ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);

            st.setInt(1, ar.getFk_usuario());

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
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");
        int id =Integer.parseInt(request.getParameter("idUsuario"));
        
        if (accion.equals("Ingresar")) {
          DExpertos d = new DExpertos();
            d.setFk_usuario(id);
            d.setDescripcion(request.getParameter("descripcion"));
            d.setFechaInicio(request.getParameter("fecha"));
            d.setFk_genero(Integer.parseInt(request.getParameter("generoM")));

            IngresarNuevoArtista(d);
            request.setAttribute("saludo", "RegistroCompletado");
            request.getRequestDispatcher("/PaginaInicio.jsp").forward(request, response);

            /*try (PrintWriter out = response.getWriter()) {
                out.println("value  " + IngresarNuevoArtista(d));
            } catch (Exception e) {
            }*/
        }//Fin ingresar
        
    }

    

}
