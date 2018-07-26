
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
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <title>Reseñas</title>
    </head>
    <body>

        <h3>Reseñas</h3> 


        <div id="Error" class="col-md-11 alert alert-danger alert-dismissible" role="alert">
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
                        <th class="cabecera">Artista</th>
                        <th class="cabecera">Album</th>
                        <th class="cabecera">Descripción</th>
                        <th class="cabecera">Calificación</th>
                        <th class="cabecera">Fecha</th>  
                        <th class="cabecera">Acciones</th>

                    </tr>
                </thead>

                <c:forEach var="tempReseñas" items="${Reseña}">

                    <%-- Link actualizador para cada genero utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LReseñas">
                        <c:param name="Accion" value="Cargar"></c:param>
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Codigo" value="${tempReseñas.getIdReseña() }"></c:param>

                    </c:url>

                    <%-- Link para eliminar cada genero utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LReseñas">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Eliminar"></c:param>
                        <c:param name="Codigo" value="${tempReseñas.getIdReseña() }"></c:param>

                    </c:url>

                    <tr>
                        <td class="filas"> ${tempReseñas.getNombreArtista() } </td>
                        <td class="filas"> ${tempReseñas.getNombreAlbum()} </td>
                        <td class="filas"> ${tempReseñas.getDescripcion() } </td>
                        <td class="filas"> ${tempReseñas.getCalificacion() } </td>
                        <td class="filas"> ${tempReseñas.getFecha() } </td>
                        <td class="filas">  
                            <a href="${linkCargar}"><img src="Imagenes/icons8-actualizar-15.png" width="15" height="15" alt="icons8-actualizar-15"/></a>
                            &nbsp;
                            <a href="${linkEliminar}"><img src="Imagenes/icons8-basura-32.png" width="20" height="20" alt="icons8-basura-32"/></a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>


        <div class="container" class ="col-md-3">
            <div id="Registrar" class ="col-md-3">

                <form action = "LReseñas" method="post" >
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="Accion" value="Insertar">

                    <div class="form-group">
                        <label for="nombre">Artista/Banda</label>

                        <select name="Artista_Banda" class="form-control" >
                            <c:forEach var="tempArtista" items="${CbxArtista}">
                                <option value="${tempArtista.getFkUsuario()}">${tempArtista.getNombreBanda()}</option>  
                            </c:forEach>
                        </select>   

                    </div> 

                    <div class="form-group">
                        <label for="nombre">Album</label>
                        <select name="Album" class="form-control">
                            <c:forEach var="tempAlbum" items="${CbxAlbum}">
                                <option value="${tempAlbum.getIdAlbum()}"> ${tempAlbum.getNombre()}</option>       
                            </c:forEach>
                        </select>                     
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Descripción</label>
                        <input type="text" class="form-control" name="desc" required="">
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Calificación</label>
                        <input type="text" class="form-control" name="calificacion" required="">
                    </div> 


                    <input type="submit" class=" btn btn-success" value="Insertar" >



                </form>
            </div>
            <div id="Actualizar" class ="col-md-3">

                <form action = "LReseñas" method="post" >
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="CodigoGenero" value="${ReseñasActualizar.getIdGenero_musical()}">
                    <input type="hidden" name="Accion" value="Actualizar">


                    <div class="form-group">
                        <label for="nombre">Artista/Banda</label>
                        <select name="Artista_Banda" class="form-control">
                            <option value=""> Artista 1</option>       
                        </select>                     
                    </div> 


                    <div class="form-group">
                        <label for="nombre">Album</label>
                        <select name="Album" class="form-control">
                            <option value=""> Album 1</option>       
                        </select>                     
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Descripción</label>
                        <input type="text" class="form-control" value="${GeneroActualizar.getNombre()}" name="desc" required="">
                    </div> 

                    <div class="form-group">
                        <label for="nombre">Calificación</label>
                        <input type="text" class="form-control" value="${GeneroActualizar.getNombre()}" name="calificacion" required="">
                    </div> 


                    <input type="submit" class=" btn btn-success" value="Actualizar" >


                </form>

            </div>


        </div>

    </body>
</html>
