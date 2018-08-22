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

        <title>Discografías</title>



    </head>


    <h1> Bienvenido al editor de Albumes </h1> 
    <h3 id="botones" hidden>${botones}</h3>
    <h3 id="aviso" hidden>${aviso}</h3>
    <h3>Lista de albumes actuales</h3> 
    <%-- -----------------------------------AVISO------------------------------------- --%>

    <div id="Error" class="col-md-11 alert alert-danger alert-dismissible" role="alert">
        En este momento no hay albumes registrados para este usuario
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%-- -----------------------------------TABLA------------------------------------- --%>

    <div class="col-md-8">
        <table class="table table-hover ">


            <thead class="thead-dark">

                <tr class="thead-dark success">
                    <th class="cabecera" hidden>Código</th>
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

                <c:url var="linkVerCanciones" value="LFans">
                    <c:param name="IdUsuario" value="${id}"></c:param>
                    <c:param name="idArtista" value="${idArtista}"></c:param>
                    <c:param name="Accion" value="VerCanciones"></c:param>
                    <c:param name="idAlbum" value="${tempAlbumes.getIdAlbum()}"></c:param>

                </c:url>

                <tr>
                    <td class="filas" hidden=""> ${tempAlbumes.getIdAlbum() } </td>
                    <td class="filas"> ${tempAlbumes.getNombre() } </td>
                    <td class="filas"> ${tempAlbumes.getDescripcion() } </td>
                    <td class="filas"> ${tempAlbumes.getFechaLancimiento() } </td>
                    <td class="filas"> ${tempAlbumes.getNombreArtista() } </td> 
                    <td class="filas"> ${tempAlbumes.getSello() } </td> 
                    <td class="filas"> ${tempAlbumes.getNombreGenero() } </td> 
                    <td class="filas">  

                        <a href="${linkVerCanciones}"><img src="Imagenes/icons8-detalles-15.png" width="20" height="20" alt="icons8-basura-32"/></a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>

    <div class="col-md-10">
        <form action="LFans" method="POST">
            <input type="hidden" name="IdUsuario" value="${id}">
            <input type="hidden" name="idArtista" value="${idArtista}">
            <input type="hidden" name="Accion" value="Ver">
            <input type="submit" class="btn btn-primary" value="Regresar">
        </form>
    </div>

    <div class="col-md-5">
        <form action="LFans" method="POST">
            <input type="hidden" name="IdUsuario" value="${id}">
            <input type="hidden" name="Accion" value="Buscar">
            <input type="submit" name="" value="Buscar artista" class="btn btn-primary">

        </form>

    </div>
</html>
