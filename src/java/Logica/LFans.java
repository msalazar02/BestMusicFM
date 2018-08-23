package Logica;

import Datos.DAlbumes;
import Datos.DArtista;
import Datos.DCanciones;
import Datos.DGenero;
import Datos.DFans;
import Datos.DNoticias;
import Datos.DResegnas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.BreakNode;

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
    public String EliminarFan(int ar) {
        String result = null;
        consulta = "DELETE FROM `generoxusuario` WHERE Fk_idUsuario = ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1, ar);

            st.executeUpdate();

        } catch (Exception e) {
            result = e.getMessage();
        }
        String consulta2 = "DELETE FROM `fans` WHERE  Pk_idFan = ?";
        try {
            PreparedStatement st = con.prepareStatement(consulta2);
            st.setInt(1, ar);

            st.executeUpdate();

        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
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

//-------------------------------Seguir un artista un fan--------------------------------    
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

//-------------------------------Dejar de seguir un artista un fan--------------------------------    
    public String DejarSeguir(int idSeguidor, int idSeguido) {
        String result = null;
        consulta = "delete from seguidores where Pk_idSeguidor = ? and Fk_idSeguido = ?";
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
            case "VerCanciones":
                VerCanciones(request, response);
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

    private void VerCanciones(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idArtista = Integer.parseInt(request.getParameter("idArtista"));
            int id = Integer.parseInt(request.getParameter("IdUsuario"));
            int idA = Integer.parseInt(request.getParameter("idAlbum"));

            LCanciones ca = new LCanciones();
            List<DCanciones> TablaCanciones;

            TablaCanciones = ca.MostrarCanciones(idA);

            double promedio = ca.Promedio(idA);
            request.setAttribute("Promedio", promedio);

            request.setAttribute("Canciones", TablaCanciones);
            request.setAttribute("id", id);
            request.setAttribute("idA", idA);
            request.setAttribute("idArtista", idArtista);
            if (TablaCanciones.isEmpty()) {
                request.setAttribute("aviso", "error");
            }

            request.getRequestDispatcher("/CancionesFans.jsp").forward(request, response);
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
            case "Dejar de seguir":
                DejarSeguir(request, response);
                break;

            case "VerDiscografia":
                VerDiscografia(request, response);

            case "Buscar":
                Buscar(request, response);
                break;

            case "VerResegnasE":
                VerResegnasE(request, response);
                break;

            case "IngresarResegna":
                //  IngresarResegna(request, response);
                break;
            case "VerResegnasF":
                VerResegnasF(request, response);
                break;
            case "VerNoticias":
                VerNoticiasFans(request, response);
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

            LArtistas a = new LArtistas();
            DArtista da = a.MostrarDato(Integer.parseInt(idArtista));
            request.setAttribute("artista", da);
            request.setAttribute("id", id);

            if (!seguidorExiste(Integer.parseInt(id), Integer.parseInt(idArtista))) {
                request.setAttribute("botones", "Seguir");
                request.getRequestDispatcher("/VerDatallesArtista.jsp").forward(request, response);

            } else {
                request.setAttribute("botones", "NoSeguir");
                request.getRequestDispatcher("/VerDatallesArtista.jsp").forward(request, response);
            }
        } catch (Exception ex) {

        }
    }

    private void DejarSeguir(HttpServletRequest request, HttpServletResponse response) {
        try {
            int seguidor = Integer.parseInt(request.getParameter("IdUsuario"));
            int seguido = Integer.parseInt(request.getParameter("idArtista"));
            request.setAttribute("id", seguidor);

            DejarSeguir(seguidor, seguido);
            Buscar(request, response);

        } catch (Exception ex) {

        }
    }

    private void VerDiscografia(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        int seguido = Integer.parseInt(request.getParameter("idArtista"));

        try {
            LAlbumes al = new LAlbumes();
            List<DAlbumes> TablaAlbumes;
            TablaAlbumes = al.MostrarDatos(seguido);
            request.setAttribute("Album", TablaAlbumes);

            if (TablaAlbumes.isEmpty()) {
                request.setAttribute("aviso", "error");
            }
            request.setAttribute("id", id);
            request.setAttribute("idArtista", seguido);

            request.getRequestDispatcher("/DiscografiaFans.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void VerResegnasE(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        int idA = Integer.parseInt(request.getParameter("idA"));
        int seguido = Integer.parseInt(request.getParameter("idArtista"));
        try {

            LResegnas re = new LResegnas();

            List<DResegnas> TablaResegnas;
            TablaResegnas = re.ObtenerResegnasPorAlbum(idA);
            request.setAttribute("Resegna", TablaResegnas);
            if (TablaResegnas.isEmpty()) {
                request.setAttribute("aviso", "error");
            }

            request.setAttribute("id", id);
            request.setAttribute("idArtista", seguido);
            request.setAttribute("idA", idA);

            request.getRequestDispatcher("/FansResegnasExpertos.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void VerResegnasF(HttpServletRequest request, HttpServletResponse response) {
        int idArtista = Integer.parseInt(request.getParameter("idArtista"));
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        int idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
        try {

            LResegnas re = new LResegnas();
            List<DArtista> ComboArtistas;
            ComboArtistas = re.CargarComboArtista();
            request.setAttribute("Artitas", ComboArtistas);

            List<DResegnas> TablaResegnas;
            TablaResegnas = re.ObtenerResegnas(id);
            request.setAttribute("Resegna", TablaResegnas);
            if (TablaResegnas.isEmpty()) {
                request.setAttribute("aviso", "error");
            }

            request.setAttribute("id", id);
            request.setAttribute("idA", idAlbum);
            request.setAttribute("idAlbum", idArtista);

            request.getRequestDispatcher("/FansResegnas.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void Cancelar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        request.setAttribute("id", id);
        VerResegnasF(request, response);

    }

    void VerNoticiasFans(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("IdUsuario"));
        try {

            LNoticias n = new LNoticias();
            List<DNoticias> TablaGeneros;
            TablaGeneros = n.MostrarDatosFan(id);
            request.setAttribute("Noticias", TablaGeneros);

            request.setAttribute("id", id);

        } catch (Exception e) {

        }

    }
}
