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
        <h2 id="botones" hidden >${botones}</h2>
        <h1>Bienvenido al perfil de ${artista.getNombreBanda()} </h1>
        <div class="form-group col-md-5">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" name="nombre" value="${artista.getNombreBanda()}" readonly >
        </div>

        <div class="form-group col-md-5">
            <label for="bio">Biografía</label>
            <input type="text" class="form-control" name="bio" value="${artista.getBiografia()}" readonly >
        </div>
        <div class="form-group col-md-5">
            <label for="genero">Género musical</label>
            <input type="text" class="form-control" name="genero" value="${artista.getNombreGenero()}" readonly >
        </div>

        <div class="form-group col-md-5">
            <label for="fecha">Fecha de inicio</label>
            <input type="text" class="form-control" name="fecha" value="${artista.getFechaIncio()}" readonly >
        </div>

        <div class="form-group col-md-5">
            <label for="tipo">Género musical</label>
            <input type="text" class="form-control" name="tipo" value="${artista.getTipoArtista()}" readonly >
        </div>

        <br>
        <div id="no" class="col-md-5">
            <form action="LFans" method="POST">
                <input type="hidden" name="idArtista" value="${artista.getFkUsuario()}">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input class="btn btn-primary" type="submit" value="Dejar de seguir" name="Accion">
            </form>

        </div>

        <div id="si" class="si col-md-5">
            <form action="LFans" method="POST">
                <input type="hidden" name="idArtista" value="${artista.getFkUsuario()}">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input type="submit" name="Accion" value="Seguir" class="btn btn-primary">

            </form>

        </div>
        <br>
        <div class="col-md-5">
            <form action="LFans" method="POST">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Buscar">
                <input type="submit" name="" value="Buscar" class="btn btn-primary">

            </form>

        </div>
        <div class="col-md-5">
            <form action="LFans" method="POST">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input type="hidden" name="idArtista" value="${artista.getFkUsuario()}">
                <input type="hidden" name="Accion" value="VerDiscografia">
                <input type="submit" name="" value="Ver discografía" class="btn btn-primary">

            </form>

        </div>
    </body>
</html>
