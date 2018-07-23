<%-- 
    Document   : PaginaPrincipalAdministradores
    Created on : 18-jul-2018, 13:10:18
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Administrador</title>
    </head>
    <body>
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
