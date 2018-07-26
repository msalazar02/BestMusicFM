<%-- 
    Document   : PaginaPrincipalAdministradores
    Created on : 18-jul-2018, 13:10:18
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Pagina Administrador</title>
    </head>
    <body>
        
        <ul class="nav nav-tabs" id="formtabs">
            <!-- Tab nav -->
            <li class="active"><a href=""  data-toggle="tab">Inicio</a>Registro</li>
            <li class=""><a href="#radioscheckboxes" data-toggle="tab">Usuario</a></li>
            <li class=""><a href="#select" data-toggle="tab">Géneros</a></li>        
        </ul>
        <form action = "LUsuarios" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="CapturarDatos">

            <input type="submit" value="Actualizar perfil">

        </form>
        <br>
        <br>
        <form action = "LUsuarios" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="EliminarArtista">
            <input type="submit" value="Eliminar cuenta">



        </form>

        <form action = "LGenero" method="post">  
            <input type="hidden" name="Accion" value="Mostrar">
            <input type="hidden" name="idUsuario" value="${id}">
            <h2> Bienvenido  </h2>

            Ingresar al mantenimiento de géneros
            <br> <br>
            <input type="submit" name = "btnMantenimiento" value="Mantenimiento"/>

        </form>
    </body>
</html>
