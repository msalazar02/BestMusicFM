
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

        <title>EditorGeneros</title>

        <link rel="stylesheet"  href="css/EditarGenero.css">

    </head>

    <body>

        <h1> Bienvenido al editor de generos </h1> 

        <h3>Lista de generos actuales</h3> 

        <div class="col-md-9">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th class="cabecera"> Código</th>
                        <th class="cabecera">Nombre</th>
                        <th class="cabecera">Descripción</th>
                        <th class="cabecera">Acciones</th>

                    </tr>
                </thead>

                <c:forEach var="tempGeneros" items="${Generos }">

                    <%-- Link actualizador para cada genero utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LGenero">

                        <c:param name="Accion" value="Cargar"></c:param>
                        <c:param name="idUsuario" value="${id}"></c:param>

                        <c:param name="Codigo" value="${tempGeneros.getIdGenero_musical()}"></c:param>

                    </c:url>

                    <%-- Link para eliminar cada genero utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LGenero">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Eliminar"></c:param>

                        <c:param name="Codigo" value="${tempGeneros.getIdGenero_musical()}"></c:param>

                    </c:url>

                    <tr>
                        <td class="filas"> ${tempGeneros.getIdGenero_musical() } </td>
                        <td class="filas"> ${tempGeneros.getNombre() } </td>
                        <td class="filas"> ${tempGeneros.getDescripcion() } </td>
                        <td class="filas">  
                            <a href="${linkCargar}"><img src="Imagenes/icons8-actualizar-15.png" width="15" height="15" alt="icons8-actualizar-15"/></a>
                            &nbsp;
                            <a href="${linkEliminar}"><img src="Imagenes/icons8-basura-32.png" width="20" height="20" alt="icons8-basura-32"/></a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>



        <div id ="col-md-9">

            <form action = "LGenero" method="post">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Insertar">

                Nombre:
                <br> 
                <input type="text" name="nombre" id = "nombre" required="">
                <br>
                <br>

                Descripción:

                <br> 
                <textarea name="descripcion" rows="4" cols="20" id="descripcion" required="">
                </textarea>
                <br>
                <br>


                <input type="submit" class=" btn btn-success" value="Insertar" >


            </form>

        </div>

    </body>
</html>
