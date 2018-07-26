<%-- 
    Document   : PaginaPrincipalExperto
    Created on : 19-jul-2018, 11:54:43
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

        <h1>Página principal de expertos</h1>
        <form action = "LUsuarios" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="CapturarDatos">

            <input type="submit" value="Actualizar usuario">

        </form>
        <br>
        <br>
        <form action = "LExpertos" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="EliminarExperto">
            <input type="submit" value="Eliminar cuenta">
        </form>
        <br>
        <br>
        <form action = "LResegnas" method="post">
            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="Mostrar">
            <input type="submit" value="Reseñas">
        </form>

    </body>
</html>
