<%-- 
    Document   : PaginaPrincipalArtistas
    Created on : 17-jul-2018, 20:26:30
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Página principal de artistas</h1>
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

        <form action = "LAlbum" method="get">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="Mostrar">
            <input type="submit" value="Ingresar Album Nuevo">
        </form>
    </body>
</html>
