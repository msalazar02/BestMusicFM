package Logica;

import java.sql.*;


public class LRegistro {

    //-----------------------Declaración de variables---------------------------
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String sSQL = "";
    private int total_Registros_Optenidos;

    public String InsertarRegistro(String nombre, String ape1, String ape2, String fechanaci, String usuario,
            String email, String contrasena, String fecha_creacion, String genero, String pais, String tipo) {
        String result = "";
        total_Registros_Optenidos = 0;

        sSQL= "INSERT INTO USUARIO(Nombre,Ape1,Ape2,Fecha_naci,Nombre_usuario,Email,Contrasena,Fecha_creacion,Sexo,PaisOrigen,TipoUsuario)"
                    + "VALUES('" + nombre + "','" + ape1 + "', '" + ape2 + "', '" + fechanaci + "', '" + usuario + "', '" 
                    + email + "', '" + contrasena + "', '" + fecha_creacion + "', '" + genero + "', '" + pais + "', '" 
                    + tipo + "')";
        
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sSQL);
            if (st.execute(sSQL)) {
                result= "El registro se ha ingresado correctamente";
            } 
            
        } catch (Exception e) {
            result= "He ocurrido un problema: \n " + e.getMessage();
        }
        
        return result;
    }

}
