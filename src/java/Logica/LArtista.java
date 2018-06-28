/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Rodrigo Moreno S
 */
public class LArtista {
    private Conexion mysql = new Conexion();
    private Connection con = mysql.Conectar();
    private String consulta = "";
    
    public String InsertarUsuario(String fk_usuario, String Tipo_artista, String Fecha_Inicio, String fk_generMusical,
            String Fotografia, String Biografia) {
        String result = "";
        //
        //Se agregan los valores a la consulta, se ingresarán en desde jsp
        consulta= "INSERT INTO `artista`(`fk_usuario`, `Tipo_artista`, `Fecha_Inicio`, `fk_generMusical`, `Fotografia`, `Biografia`, `Nombre_BandaArtistico`)"
                + "VALUES ('"+fk_usuario+"','"+Tipo_artista+"','"+Fecha_Inicio+"','"+fk_generMusical+"',"
                + "'"+Fotografia+"','"+Biografia+"')";
        
        try {
            Statement st = con.createStatement();
            int n=st.executeUpdate(consulta);
            
            if (n!=0) {
               result= "El registro se ha ingresado correctamente";
            }
            
        } catch (Exception e) {
            result= "He ocurrido un problema: \n " + e.getMessage();
        }
        
        return result;
    }
}
