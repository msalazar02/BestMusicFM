<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/ActivarDesactivarBotones.js" type="text/javascript"></script>
        <script src="js/Aviso.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>EditorGeneros</title>



    </head>

    <body>

        <h1> Bienvenido al editor de Albumes </h1> 
        <h3 id="botones" hidden>${botones}</h3>
        <h3>Lista de albumes actuales</h3> 

        <div class="col-md-8">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th class="cabecera">Código</th>
                        <th class="cabecera">Nombre</th>
                        <th class="cabecera">Descripción</th>
                        <th class="cabecera">Fecha de lanzamiento</th>
                        <th class="cabecera">Artista</th>
                        <th class="cabecera">Sello Discográfico</th>
                        <th class="cabecera">Género</th>
                        <th class="cabecera">Acciones</th>

                    </tr>
                </thead>

                <c:forEach var="tempAlbumes" items="${Album}">

                    <%-- Link actualizador para cada álbum utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LAlbum">
                        <c:param name="Accion" value="Cargar"></c:param>
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>

                    <%-- Link para eliminar cada álbum utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LAlbum">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Eliminar"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>
                    <c:url var="linkVerCanciones" value="LCanciones">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Mostrar"></c:param>
                        <c:param name="Codigo" value="${tempAlbumes.getIdAlbum()}"></c:param>

                    </c:url>

                    <tr>
                        <td class="filas"> ${tempAlbumes.getIdAlbum() } </td>
                        <td class="filas"> ${tempAlbumes.getNombre() } </td>
                        <td class="filas"> ${tempAlbumes.getDescripcion() } </td>
                        <td class="filas"> ${tempAlbumes.getFechaLancimiento() } </td>
                        <td class="filas"> ${tempAlbumes.getNombreArtista() } </td> 
                        <td class="filas"> ${tempAlbumes.getSello() } </td> 
                        <td class="filas"> ${tempAlbumes.getNombreGenero() } </td> 
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
                        <label for="desc">Descripción</label>
                        <input type="text" class="form-control" name="desc" required="">
                    </div> 

                    <div class="form-group">
                        <label for="fecha">Fecha de lanzamiento</label>
                        <input type="date" class="form-control" name="fecha" required="">
                    </div> 
                    <div class="form-group">
                        <label for="sello">Sello Discográfico</label>
                        <input type="text" class="form-control" name="sello" required="">
                    </div>
                    <label for="genero">Género musical</label>
                    <select name="genero">

                        <c:forEach var="tempGeneros" items="${Generos }">
                            <option value="${tempGeneros.getIdGenero_musical()}">
                                ${tempGeneros.getNombre()}
                            </option>
                        </c:forEach>

                    </select>


                    <input type="submit" class=" btn btn-success" value="Insertar" >

                </form>
            </div><!--Fin registrar -->

            <div id="Actualizar" class ="col-md-3">

                <form action = "LAlbum" method="post" >
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="CodigoAlbum" value="${AlbumActualizar.getIdAlbum()}">
                    <input type="hidden" name="Accion" value="Actualizar">


                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" value="${AlbumActualizar.getNombre()}" name="nombre" required="">
                    </div> 


                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <input type="text" class="form-control" value="${AlbumActualizar.getDescripcion()}" name="descripcion" required="">
                    </div> 

                    <div class="form-group">
                        <label for="fecha">Fecha de lanzamiento</label>
                        <input type="date" class="form-control" value="${AlbumActualizar.getFechaLancimiento}" name="fecha" required="">
                    </div> 

                    <div class="form-group">
                        <label for="sello">Sello Discográfico</label>
                        <input type="text" class="form-control" value="${AlbumActualizar.getSello()}" name="sello" required="">
                    </div>
                    <label for="genero">Género musical</label>
                    <select name="genero">
                        <option >
                            <c:forEach var="tempGeneros" items="${Generos }">
                            <option value="${tempGeneros.getIdGenero_musical()}">
                                ${tempGeneros.getNombre()}
                            </option>
                        </c:forEach>
                        </option>
                    </select>
                    <input type="submit" class=" btn btn-success" value="Actualizar" >


                </form>

            </div><!--Fin actualizar -->
        </div>

    </body>
</html>
