<%-- 
    Document   : RegistroAdmin
    Created on : 30-jun-2018, 12:56:01
    Author     : Rodrigo Moreno S
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Aministrador</title>
    </head>
    <body>
        <div id="formulario">
            <form action="LAdministradores" method="POST">
                <input type="hidden" name="Accion" value="Ingresar Admin">
                <input type="hidden" name="idUsuario" value="${id}">
                <label>Fecha de contratación</label>
                <br>
                <input type="date" class="txt" name="fecha">
                
                <input type= "submit" class="boton" value="Registrarse como administrador">
            </form>
        </div><!--Formulario -->

    </body>
</html>
