<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Logica.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/SeguirNoSeguir.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <h2 id="botones"  >${botones}</h2>
        <h1>Estos son los detalles de los artistas!</h1>
        <span>${artista.getNombreBanda()}</span> 
        <br>
        <div id="no" class="col-md-10">
            <form action="LFans" method="POST">
                <input type="hidden" name="idArtista" value="${tempArtistas.getFkUsuario()}">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input class="btn btn-primary" type="submit" value="Dejar de seguir" name="Accion">
            </form>

        </div>

        <div id="si" class="si col-md-10">
            <form action="LFans" method="POST">
                <input type="hidden" name="idArtista" value="${tempArtistas.getFkUsuario()}">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input class="btn btn-primary" type="submit" value="Seguir" name="Accion">

            </form>

        </div>
    </body>
</html>
