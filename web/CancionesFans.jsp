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
        <title>EditorGeneros</title>



    </head>

    <body>

        <h1> Bienvenido al editor de generos </h1> 
        <h3 id="botones" hidden>${botones}</h3>
        <h3 id="aviso" hidden>${aviso}</h3>
        <h3>Lista de generos actuales</h3> 

        <div id="Error" class="col-md-11 alert alert-danger alert-dismissible" role="alert">
            En este momento no hay canciones registradas para este álbum
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>

        <div class="col-md-8">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th class="cabecera" hidden> Código</th>
                        <th class="cabecera">Nombre</th>
                        <th class="cabecera">Duración</th>


                    </tr>
                </thead>

                <c:forEach var="tempCanciones" items="${Canciones }">



                    <tr>
                        <td class="filas" hidden=""> ${tempCanciones.getIdCancion() } </td>
                        <td class="filas"> ${tempCanciones.getNombre() } </td>
                        <td class="filas"> ${tempCanciones.getDuracion() } </td>


                    </tr>

                </c:forEach>

                <%-- Promedio album --%>
                <div class="form-group">
                    <label for="promedio">Promedio del album</label>&nbsp;<label for="mensaje">${Promedio}</label>

                </div> 
            </table>
        </div>
        <div class="col-md-10">
            <form action="LFans" method="POST">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input type="hidden" name="idArtista" value="${idArtista}">
                <input type="hidden" name="Accion" value="VerDiscografia">
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

        <div class="col-md-10">
            <form action="LFans" method="POST">
                <input type="hidden" name="IdUsuario" value="${id}">
                <input type="hidden" name="idArtista" value="${idArtista}">
                <input type="hidden" name="idA" value="${idA}">
                <input type="hidden" name="Accion" value="VerResegnasE">
                <input type="submit" class="btn btn-primary" value="Ver reseñas de expertos">
            </form>
        </div>
</html>