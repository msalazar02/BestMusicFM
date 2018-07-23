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

        <h1> Bienvenido al editor de albumes </h1> 

        <h3>Lista de albumes </h3> 

        <div class="col-md-9">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th scope="col">Código</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Fecha de lanzamiento</th>
                        <th scope="col">Artista</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>

                <c:forEach var="tempAlbum" items="${Album}">

                    <%-- Link actualizador para cada genero utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LAlbum">

                        <c:param name="id" value="${id}"></c:param>

                        <c:param name="Accion" value="Cargar"></c:param>

                        <c:param name="Codigo" value="${tempAlbum.getIdAlbum()}"></c:param>

                    </c:url>

                    <%-- Link para eliminar cada genero utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LAlbum">

                        <c:param name="idUsuario" value="${id}"></c:param>

                        <c:param name="Accion" value="EliminaAlbum"></c:param>

                        <c:param name="Codigo" value="${tempAlbum.getIdAlbum()}"></c:param>

                    </c:url>
                    <c:url var="linkIngresar" value="LAlbum">

                        <c:param name="idUsuario" value="${id}"></c:param>

                        <c:param name="Accion" value="IngresarAlbum"></c:param>

                        <c:param name="Codigo" value="${tempAlbum.getIdAlbum()}"></c:param>

                    </c:url>

                    <tr>
                        <td> ${tempAlbum.getIdAlbum() } </td>
                        <td> ${tempAlbum.getNombre() } </td>
                        <td> ${tempAlbum.getDescripcion() } </td>
                        <td> ${tempAlbum.getFechaLancimiento() } </td>
                        <td> ${tempAlbum.getNombreArtista() } </td>
                        <td>  
                            <a href="${linkCargar}"><img src="Imagenes/icons8-actualizar-15.png" width="15" height="15" alt="icons8-actualizar-15"/></a>
                            &nbsp;
                            <a href="${linkEliminar}"><img src="Imagenes/icons8-basura-32.png" width="20" height="20" alt="icons8-basura-32"/></a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>

        <%-- Contenedor --%>

        <!--<div class="col-md-3">
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


        </div>-->

        <div class="col-md-3">
            <form action="LAlbum" method="post">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="IrIngresar">

                <div class="form-group">
                    <input type="submit" name="btnIngresar" value="Nuevo album" class="btn btn-primary">
                </div> 
            </form>


        </div>-->

        <div class="col-md-3">

            <form action="LAlbum" method="POST">

                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Regresar">

                <div class="form-group">
                    <input type="submit" value="Ir a perfil" class="btn btn-primary">
                </div> 
            </form>
        </div>


    </body>
</html>
