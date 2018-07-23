<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Logica.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>Albumes</title>
    </head>
    <body>

        <h1> Ingresar un nuevo album </h1> 

        <div class="col-md-3">
            <form action="LAlbum" method="get">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="IngresarAlbum">

                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="nombre" required="">
                </div> 
                <div class="form-group">
                    <label for="desc">Descripción</label>
                    <input type="text" class="form-control" name="desc" required="">
                </div> 
                <div class="form-group">
                    <label for="fecha">Fecha de lanzamiento</label>
                    <input type="date" class="form-control" name="fecha" required="">
                </div> 
                <div class="form-group">
                    <input type="submit" name="btnIngresar" value="Nuevo album" class="btn btn-primary">
                </div> 
            </form>


        </div>


        <div class="col-md-3">

            <form action="LAlbum" method="POST">

                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Mostrar">

                <div class="form-group">
                    <input type="submit" name="btnIngresar" value="Ver álbumes" class="btn btn-primary">
                </div> 
            </form>
        </div>


    </body>
</html>

