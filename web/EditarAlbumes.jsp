<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/ActivarDesactivarBotones.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>EditorGeneros</title>



    </head>

    <body>

        <h1> Bienvenido al editor de Albumes </h1> 
        <h3 id="botones" hidden>${botones}</h3>
        <h3>Lista de albumes actuales</h3> 

        <div id="Error" class="alert alert-danger alert-dismissible" role="alert">
            La petición no fue completada con exito:
            El género selecionado se encuentra relacionado con almenos una cuenta existente
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                
            </button>
        </div>
        <div class="col-md-8">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th class="cabecera">Código</th>
                        <th class="cabecera">Nombre</th>
                        <th class="cabecera">Descripción</th>
                        <th class="cabecera">Fecha de lanzamiento</th>
                        <th class="cabecera">Artista</th>

                    </tr>
                </thead>

                <c:forEach var="tempAlbumes" items="${Album}">

                    <%-- Link actualizador para cada genero utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LAlbum">
                        <c:param name="Accion" value="Cargar"></c:param>
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>

                    <%-- Link para eliminar cada genero utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LAlbum">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Eliminar"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>
                    <c:url var="linkVerCanciones" value="LAlbum">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="verCanciones"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>

                    <tr>
                        <td class="filas"> ${tempAlbumes.getIdAlbum() } </td>
                        <td class="filas"> ${tempAlbumes.getNombre() } </td>
                        <td class="filas"> ${tempAlbumes.getDescripcion() } </td>
                        <td class="filas"> ${tempAlbumes.getFechaLancimiento() } </td>
                        <td class="filas">  
                            <a href="${linkCargar}"><img src="Imagenes/icons8-actualizar-15.png" width="15" height="15" alt="icons8-actualizar-15"/></a>
                            &nbsp;
                            <a href="${linkEliminar}"><img src="Imagenes/icons8-basura-32.png" width="20" height="20" alt="icons8-basura-32"/></a>
                            &nbsp;
                            <a href="${linkVerCanciones}"><img src="Imagenes/icons8-detalles-15.png" width="20" height="20" alt="icons8-basura-32"/></a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>

        <div class="container" class ="col-md-3">
            <div id="Registrar" class ="col-md-3">

                <form action = "LAlbum" method="post" >
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="Accion" value="Insertar">


                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required="">
                    </div> 


                    <div class="form-group">
                        <label for="nombre">Descripción</label>
                        <input type="text" class="form-control" name="desc" required="">
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Fecha de lanzamiento</label>
                        <input type="date" class="form-control" name="fecha" required="">
                    </div> 


                    <input type="submit" class=" btn btn-success" value="Insertar" >



                </form>
            </div><!--Fin registrar -->

            <div id="Actualizar" class ="col-md-3">

                <form action = "LAlbum" method="post" >
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="text" name="CodigoAlbum" value="${AlbumActualizar.getIdAlbum()}">
                    <input type="hidden" name="Accion" value="Actualizar">


                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" value="${AlbumActualizar.getNombre()}" name="nombre" required="">
                    </div> 


                    <div class="form-group">
                        <label for="nombre">Descripción</label>
                        <input type="text" class="form-control" value="${AlbumActualizar.getDescripcion()}" name="descripcion" required="">
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Fecha de lanzamiento</label>
                        <input type="date" class="form-control" value="${AlbumActualizar.getFechaLancimiento}" name="fecha" required="">
                    </div> 

                    <input type="submit" class=" btn btn-success" value="Actualizar" >


                </form>

            </div><!--Fin actualizar -->
        </div>

    </body>
</html>
