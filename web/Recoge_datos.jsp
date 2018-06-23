<%-- 
    Document   : Recoge_datos
    Created on : Jun 22, 2018, 6:59:52 PM
    Author     : darian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
    </head>
    <body>

        <%

            String nombre = request.getParameter("nombre");
            String ape1 = request.getParameter("apellido1");
            String ape2 = request.getParameter("apellido2");
            String fechanaci = request.getParameter("fechanaci");
            String email = request.getParameter("email");
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            String genero = request.getParameter("sexo");
            String pais = request.getParameter("pais");
            String tipo = request.getParameter("tipoUsuario");
            String fecha_creacion = "2018-06-22";
            
            Class.forName("com.mysql.jdbc.Driver");

            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/redsocialbd", "root", "");

            java.sql.Statement miState = con.createStatement();

            String ins = "INSERT INTO USUARIO(Nombre,Ape1,Ape2,Fecha_naci,Nombre_usuario,Email,Contrasena,Fecha_creacion,Sexo,PaisOrigen,TipoUsuario) "
                    + "VALUES('" + nombre + "','" + ape1 + "', '" + ape2 + "', '" + fechanaci + "', '" + usuario + "', '" + email + "', '" + contrasena + "', '" + fecha_creacion + "', '" + genero + "', '" + pais + "', '" + tipo + "')";

            miState.executeUpdate(ins);

            out.print("Registro exitoso");


        %>


    </body>
</html>
