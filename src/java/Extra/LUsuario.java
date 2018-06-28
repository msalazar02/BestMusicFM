package Extra;

//@author BestMusicFM Inc 
import Datos.DUsuario;
import Logica.Conexion;
import java.sql.*;

public class LUsuario {

    //-----------------------Declaración de variables---------------------------
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";
    private int num = 0;
    
   

    ///-----------------Insertar----------------------------------
    public String InsertarUsuario(String nombre, String ape1, String ape2, String fechanaci, String usuario,
            String email, String contrasena, String fecha_creacion, String genero, String pais, String tipo) {
        String result = "";

        //Se agregan los valores a la consulta, se ingresarán en desde jsp
        consulta = "INSERT INTO USUARIO(Nombre,Ape1,Ape2,Fecha_naci,Nombre_usuario,Email,Contrasena,Fecha_creacion,Sexo,PaisOrigen,TipoUsuario)"
                + "VALUES('" + nombre + "','" + ape1 + "', '" + ape2 + "', '" + fechanaci + "', '" + usuario + "', '"
                + email + "', '" + contrasena + "', '" + fecha_creacion + "', '" + genero + "', '" + pais + "', '"
                + tipo + "')";

        try {
            Statement st = con.createStatement();
            int n = st.executeUpdate(consulta);

            if (n != 0) {
                result = idUltimoRegistrado();
            }

        } catch (Exception e) {
            result = "He ocurrido un problema: \n " + e.getMessage();
        }

        //------------------------------------
        return result;
    }

    ///-----------------Eliminar----------------------------------
    public String EliminarUsuario(DUsuario user) {
        String result = "";

        consulta = "Delete from usuario where idUsuario=?";

        try {
            PreparedStatement pst = con.prepareStatement(consulta);

            pst.setInt(1, user.getIdUsuario());
            int n = pst.executeUpdate();

            if (n != 0) {
                result = "El registro se ha eliminado correctamente";
            }

        } catch (SQLException ex) {
            result = "He ocurrido un error\n: " + ex.getMessage();
        }
        return result;
    }

    ///-----------------Id del último registrado----------------------------------
  
    public String idUltimoRegistrado(){
        String result = "";
        consulta= "SELECT * FROM `usuario`";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next())
                {
                 
           result= rs.getString("idUsuario") ;
            }
            
        } catch (Exception e) {
            result= "He ocurrido un problema: \n " + e.getMessage();
        }
        
        
        
        return result;
    }
}
