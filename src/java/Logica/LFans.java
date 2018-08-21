package Logica;

import Datos.DArtista;
import Datos.DGenero;
import Datos.DFans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LFans", urlPatterns = {"/LFans"})
public class LFans extends HttpServlet {

//-----------------------Declaración de variables---------------------------
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";

//-------------------------------Ingresar fan-----------------------------------        
    public void InsertarFan(int id) {
        consulta = "INSERT INTO `fans`(`Pk_idFan`) VALUES (?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
        }

    }

//-----------------------Insertar genero para un fan----------------------------    
    public void InsertarGeneroFan(DFans f) {
        consulta = "INSERT INTO `generoxusuario`(`Fk_idGenero`, `Fk_idUsuario`) VALUES (?,?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, f.getIdGenero());
            st.setInt(2, f.getIdFan());
            st.execute();
        } catch (Exception e) {
        }

    }

//-------------------------------Eliminar un fan--------------------------------    
    public void EliminarFan(int id) {
        consulta = "DELETE FROM `generoxusuario` WHERE Fk_idUsuario = ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
        }
    }

//-------------------------------Eliminar un fan--------------------------------    
    public void Seguir(int idSeguidor, int idSeguido) {
        consulta = "INSERT INTO `seguidores`(`Pk_idSeguidor`, `Fk_idSeguido`) VALUES (?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, idSeguidor);
            st.setInt(2, idSeguido);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");
        switch (accion) {
            case "Buscar":
                Buscar(request, response);
                break;
            case "FinalizarFan":
                FinalizarFan(request, response);
                break;
            case "EliminarFan":
                EliminarFan(request, response);
                break;
            case "Seguir":
                Seguir(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");
        switch (accion) {
            case "IngresarGeneroFan":
                IngresarGeneroFan(request, response);
                break;
            case "FinalizarFan":
                FinalizarFan(request, response);
                break;
            case "EliminarFan":
                EliminarFan(request, response);
                break;
            case "Seguir":
                Seguir(request, response);
                break;
        }
    }

    private void Buscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("idUsuario");
            LArtistas d = new LArtistas();
            List<DArtista> TablaArtistas;
            TablaArtistas = d.MostrarDatos();
            request.setAttribute("Artistas", TablaArtistas);
        } catch (Exception ex) {

        }

    }

    private void IngresarGeneroFan(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idUsuario");
        try {
            DFans f = new DFans();
            f.setIdGenero(Integer.parseInt(request.getParameter("generoM")));
            f.setIdFan(Integer.parseInt(id));

            InsertarGeneroFan(f);
            try {
                LGenero d = new LGenero();
                List<DGenero> TablaGeneros;
                TablaGeneros = d.MostrarDatos();
                request.setAttribute("Generos", TablaGeneros);

            } catch (Exception ex) {
            }
            request.setAttribute("id", id);
            request.setAttribute("saludo", "GeneroIngresado");
            request.getRequestDispatcher("/RegistroFan.jsp").forward(request, response);
        } catch (Exception ex) {

        }
    }

    private void FinalizarFan(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("idUsuario");
            InsertarFan(Integer.parseInt(id));
            request.setAttribute("id", id);
            request.setAttribute("saludo", "RegistroCompletado");
            request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
        } catch (Exception ex) {
        }
    }

    private void EliminarFan(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("idUsuario");
            EliminarFan(Integer.parseInt(id));
            LUsuarios u = new LUsuarios();
            u.EliminarUsuario(Integer.parseInt(id));
            request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
        } catch (Exception ex) {

        }
    }

    private void Seguir(HttpServletRequest request, HttpServletResponse response) {
        try {
            int seguidor = Integer.parseInt(request.getParameter("idUsuario"));
            int seguido = Integer.parseInt(request.getParameter("idArtista"));
            Seguir(seguidor, seguido);
            request.getRequestDispatcher("/BucarAmigos").forward(request, response);
        } catch (Exception ex) {

        }

    }

}
