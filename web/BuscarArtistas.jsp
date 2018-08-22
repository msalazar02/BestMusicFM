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

        <script src="js/BuscarArtista.js" type="text/javascript"></script>
        <script src="js/Aviso.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/Auxiliar.css">
        <link rel="stylesheet" href="css/BuscarArtista.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%-- ----------------------------------LINKS---------------------------------- --%>
        <c:url var="linkAmigos" value="LFans">
            <c:param name="Accion" value="Buscar"></c:param>
            <c:param name="IdUsuario" value="${id}"></c:param>
        </c:url>

        <c:url var="irFan" value="LUsuarios">
            <c:param name="Accion" value="SaberNombreF"></c:param>
            <c:param name="IdUsuario" value="${id}"></c:param>
        </c:url>

        <c:url var="linkEventos" value="LEventos">
            <c:param name="Accion" value="Visualizar"></c:param>
            <c:param name="idUsuario" value="${id}"></c:param>
        </c:url>

        <c:url var="salir" value="PaginaInicio.jsp"></c:url>

        <%-- ----------------------------------NAVBAR---------------------------------- --%>

        <ul class="nav nav-tabs navbar-inverse" id="formtabs">
            <!-- Tab nav -->
            <li class=""><a href="${irFan}"  data-toggle="tab">Inicio</a></li>
            <li class="active"><a href="${linkAmigos}" data-toggle="tab">Buscar artistas</a></li>
            <li class=""><a href="${linkEventos}" data-toggle="tab">Eventos</a></li>   
            <li class=""><a href="${salir}" data-toggle="tab">Logout</a></li> 
        </ul>

        <%-- ----------------------------------COLUMNA IZQUIERDA---------------------------------- --%>

        <div class="col-md-2">

        </div>
        <div id="espacio" class="col-md-2" > 
            <br>
        </div>



        <%-- ----------------------------------COLUMNA CENTRAL---------------------------------- --%>


        <div  class="col-md-10" >  
            <div id="" class="col-md-10" > 
                <h1> Encuentra a tus artitas favoritos</h1>


            </div>
            <h3 id="aviso" hidden>${aviso}</h3>


            <div id="Completo" class="col-md-10 alert alert-success alert-dismissible" role="alert">
                Falicidades, ahora sigues a este usuario!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="Error" class="col-md-10 alert alert-danger alert-dismissible" role="alert">
                Ya sigues a este usuario!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <c:forEach var="tempArtistas" items="${Artistas}">
                <a href="#"></a>
                <div id="c1" class="c1 col-md-4">
                    <form action="LFans" method="post">
                        <input type="hidden" name="idArtista" value="${tempArtistas.getFkUsuario()}">
                        <input type="hidden" name="IdUsuario" value="${id}">

                        <img src="Imagenes/icons8-músico.png" alt="avatar"/>
                        <span>${tempArtistas.getNombreBanda()}</span> 
                        <br>
                        <input type="submit" name="Accion" value="Ver" class="btn btn-primary">
                        <input type="submit" name="Accion" value="Seguir" class="btn btn-primary">

                    </form>
                </div>

            </c:forEach>
        </div>
    </body>
</html>
