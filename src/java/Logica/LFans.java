package Logica;

import Datos.DArtista;
import Datos.DGenero;
import Datos.DFans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean seguidorExiste(int a, int b) {
        boolean result = false;
        try {

            consulta = "select * from seguidores where Pk_idSeguidor = ? and Fk_idSeguido = ?";
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, a);
            st.setInt(2, b);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LFans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

//-------------------------------Eliminar un fan--------------------------------    
    public String Seguir(int idSeguidor, int idSeguido) {
        String result = null;
        consulta = "INSERT INTO `seguidores`(`Pk_idSeguidor`, `Fk_idSeguido`) VALUES (?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, idSeguidor);
            st.setInt(2, idSeguido);
            result = "" + st.executeUpdate();

        } catch (Exception e) {
        }
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");
        switch (accion) {
            case "Buscar":
                Buscar(request, response);
                break;
        }

    }

    private void Buscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("IdUsuario");
            LArtistas d = new LArtistas();
            List<DArtista> TablaArtistas;
            TablaArtistas = d.MostrarDatos();
            request.setAttribute("Artistas", TablaArtistas);
            request.setAttribute("id", Integer.parseInt(id));
            /* try (PrintWriter out = response.getWriter()) {
                out.println("nombre-->" + TablaArtistas.get(0).getNombreBanda() + "  nombre-->" + TablaArtistas.get(1).getNombreBanda() + "  nombre-->" + TablaArtistas.get(2).getNombreBanda());
            } catch (Exception e) {
            }*/
            request.getRequestDispatcher("/BuscarArtistas.jsp").forward(request, response);
        } catch (Exception ex) {

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
            case "Ver":
                Ver(request, response);
                break;
        }
    }

    private void IngresarGeneroFan(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("IdUsuario");
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
            String id = request.getParameter("IdUsuario");
            InsertarFan(Integer.parseInt(id));
            request.setAttribute("id", id);
            request.setAttribute("saludo", "RegistroCompletado");
            request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
        } catch (Exception ex) {
        }
    }

    private void EliminarFan(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("IdUsuario");
            EliminarFan(Integer.parseInt(id));
            LUsuarios u = new LUsuarios();
            u.EliminarUsuario(Integer.parseInt(id));
            request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
        } catch (Exception ex) {

        }
    }

    private void Seguir(HttpServletRequest request, HttpServletResponse response) {
        try {
            int seguidor = Integer.parseInt(request.getParameter("IdUsuario"));
            int seguido = Integer.parseInt(request.getParameter("idArtista"));

            /* try (PrintWriter out = response.getWriter()) {
                
                    out.println("no seguir");

            } catch (Exception e) {

            }*/
            if (!seguidorExiste(seguidor, seguido)) {
                Seguir(seguidor, seguido);
                request.setAttribute("aviso", "completo");
                request.setAttribute("id", seguidor);
                Buscar(request, response);
            } else {
                request.setAttribute("aviso", "error");
                request.setAttribute("id", seguidor);
                Buscar(request, response);
            }

        } catch (Exception ex) {

        }

    }

    private void Ver(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("IdUsuario");
            String idArtista = request.getParameter("idArtista");

            if (!seguidorExiste(Integer.parseInt(id), Integer.parseInt(idArtista))) {
                LArtistas a = new LArtistas();
                DArtista da = a.MostrarDato(Integer.parseInt(idArtista));
                request.setAttribute("artista", da);
                request.setAttribute("id", id);
                request.setAttribute("botones", "Seguir");
                request.getRequestDispatcher("/VerDatallesArtista.jsp").forward(request, response);
            } else {

                LArtistas a = new LArtistas();
                DArtista da = a.MostrarDato(Integer.parseInt(idArtista));
                request.setAttribute("artista", da);
                request.setAttribute("id", id);
                request.setAttribute("botones", "NoSeguir");
                request.getRequestDispatcher("/VerDatallesArtista.jsp").forward(request, response);
            }
        } catch (Exception ex) {

        }
    }

}
