<%-- 
    Document   : ActualizarUsuario
    Created on : 27-jun-2018, 13:18:08
    Author     : Rodrigo Moreno S
--%>


<%@page import="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar usuario</title>
    </head>
    <body>

        <h1>Actualizar datos</h1>

        <h3>Cambia los datos que deseas actualizar</h3>
        <form action = "LUsuarios" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="Actualizar">

            Nombre:
            <br> 
            <input type="text" name="nombre" value="${Nombre}" required="">
            <br>
            <br>



            <br> 
            <input type="text" name="apellido1" value="${Ape1}" required="">&nbsp;&nbsp;
            <input type="text" name="apellido2" value="${Ape2}" required="">
            <br>
            <br>

            Fecha de nacimiento:
            <br> 
            <input type = "text" name = "fechanaci" value="${Fecha_naci}" required="">
            <br>
            <br>

            Email 
            <br>
            <input type="text" name="email" required="" value="${Email}">
            <br>
            <br>

            Usuario
            <br> 
            <input type="text" name="usuario" required="" value="${Nombre_usuario}">
            <br>
            <br>

            Contraseña
            <br> 
            <input type="password" name="contrasena" value="${Contrasena}" required="">
            <br>
            <br>

            Género
            <br>
            <input type="radio" name="sexo" id="sexo_01" value="Femenino" required="">  Famenino
            <input type="radio" name="sexo" id="sexo_02" value="Masculino" required=""> Masculino
            <br>
            <br>


            País de nacimiento 
            <br> 

            <select name="pais" id="pais"  >
                <option>Costa Rica</option>
                <option>México</option>
                <option>Colombia</option>
                <option>Chile</option>
                <option>Perú</option>
                <option>Argentina</option>
                <option>España</option>
            </select>

            <br>
            <br>

            <br>



            <input type="submit" name = "btnEnviar" id="button" value="Enviar">


        </form>

        <form action="TipoUsuario.jsp">
            <input type="submit" value="Actualizar tipo de usuario">
        </form>

    </body>

</html>
