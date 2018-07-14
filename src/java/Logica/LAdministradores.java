/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DAdministradores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BestMusicFM Inc
 */
@WebServlet(name = "LAdministradores", urlPatterns = {"/LAdministradores"})
public class LAdministradores extends HttpServlet {

    Conexion myslq = new Conexion();
    String consulta;
    Connection con = myslq.Conectar();

///-----------------Ingresar admin-----------------------listo-----------
    public String IngresarNuevoAdmin(DAdministradores ad) {
        String result = "";
        consulta = "insert into Administradores (fk_usuario, fecha_contratacion) values(?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, ad.getPkIdUsuario());
            st.setString(2, ad.getFechaContatracion());
            int num = st.executeUpdate();
            if (num != 0) {
                result = "Registro ingresado correctamente";
            }
        } catch (Exception e) {
            result = "Hemos encontrado un error:\n" + e.getMessage();
        }

        return result;
    }

    ///-----------------Eliminar-----------------------listo-----------
    public String EliminarAdmin(DAdministradores ad) {
        String result = "";

        consulta = "Delete from administradores where fk_usuario=?";

        try {
            PreparedStatement pst = con.prepareStatement(consulta);

            pst.setInt(1, ad.getPkIdUsuario());
            int n = pst.executeUpdate();

            if (n != 0) {
                result = "El registro se ha eliminado correctamente";
            }

        } catch (SQLException ex) {
            result = "He ocurrido un error\n: " + ex.getMessage();
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

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String accion = request.getParameter("Accion");

        if (accion.equals("Ingresar Admin")) {

            DAdministradores ad = new DAdministradores();

            String fecha = request.getParameter("fecha");

            ad.setFechaContatracion(fecha);
            ad.setPkIdUsuario(id);

            IngresarNuevoAdmin(ad);

            request.getRequestDispatcher("/PaginaInicio.jsp").forward(request, response);
        }

        if (accion.equals("Eliminar")) {

            DAdministradores ad = new DAdministradores();

            ad.setPkIdUsuario(id);

            EliminarAdmin(ad);

            request.getRequestDispatcher("/PaginaPrincipal.jsp").forward(request, response);
        }

    }

}
