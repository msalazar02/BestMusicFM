/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DGeneros;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "LGeneros", urlPatterns = {"/LGeneros"})
public class LGeneros extends HttpServlet {

    Conexion myslq = new Conexion();
    String consulta;
    Connection con = myslq.Conectar();

    //-------------------Ingresar un nuevo género-------------------------------
    public String InsertarGenero(DGeneros dg) {
        String result = "";
        try {

            consulta = "INSERT INTO `genero_musical`(`Nombre`, `Descripcion`)"
                    + " VALUES (?,?)";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, dg.getNombre());
            pst.setString(2, dg.getDescripcion());

        } catch (SQLException ex) {
            result = "Error: \n" + ex.getMessage();
        }
        return result;
    }

    //-------------------Eliminar un género-------------------------------
    public String EliminarGenero(DGeneros dg) {
        String result = "";
        try {

            consulta = "delete from genero_musical where idGenero_musical = ?";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setInt(1, dg.getIdGenero());

        } catch (SQLException ex) {
            result = "Error: \n" + ex.getMessage();
        }
        return result;
    }

    //-------------------Ver todos los géneros-------------------------------
   public List<String> VerNombreGenero() throws Exception {
        List<String> generos = new ArrayList<>();

        consulta = "SELECT Nombre FROM GENERO_MUSICAL";

        PreparedStatement st = con.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            String nombre = rs.getString("Nombre");
           generos.add(nombre);
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
