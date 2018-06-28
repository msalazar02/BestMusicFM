<%-- 
    Document   : Recoge_datos
    Created on : Jun 22, 2018, 6:59:52 PM
    Author     : BestMusicFM Inc 
--%>


<%@page import="Logica.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
    </head>
    <body>
        <h3>Datos ingresados</h3>
        <%
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
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
            String fecha_creacion = date.format(now);
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido1", ape1);
            request.setAttribute("apellido2", ape2);
            request.setAttribute("fechanaci", fechanaci);
            request.setAttribute("email", email);
            request.setAttribute("usuario", usuario);
            request.setAttribute("contrasena", contrasena);
            request.setAttribute("sexo", genero);
            request.setAttribute("pais", pais);
            request.setAttribute("tipoUsuario", tipo);
            request.setAttribute("fecha_creacion", fecha_creacion);
            
            /*Prueba l= new Prueba();
            
            out.print(l.InsertarUsuario(nombre, ape1, ape2, fechanaci, usuario, email, contrasena,
                    fecha_creacion, genero, pais, tipo));*/
            
            
            
            %>
            <br> 
            Nombre: <%=nombre%> <%=ape1%> <%=ape2%>;
            <br> 
            Fecha de nacimiento: <%=fechanaci%>
            <br>
            Email: <%=email%>
            <br>
            Usuario <%=usuario%>
            <br>
            Contraseña <%=contrasena%>
            <br>
            Genéro <%=genero%>
            <br>
            País <%=pais%>
            <br>
            Tipo de usuario <%=tipo%>
            String tipo = request.getParameter("tipoUsuario");
            <br>
            <form action="Preuba" method="post">
                <br>
                <input type="submit" value="Confirmar datos" name="btnArtista2"> 
                
                
                
            </form>
            

    </body>
</html>
