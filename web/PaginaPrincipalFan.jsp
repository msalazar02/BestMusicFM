<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/Auxiliar.css">
        <link rel="stylesheet" href="css/NoticiasFans.css">


        <title>JSP Page</title>
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
            <li class="active"><a href="${irFan}"  data-toggle="tab">Inicio</a></li>
            <li class=""><a href="${linkAmigos}" data-toggle="tab">Buscar artistas</a></li>
            <li class=""><a href="${linkEventos}" data-toggle="tab">Eventos</a></li>   
            <li class=""><a href="${salir}" data-toggle="tab">Logout</a></li> 
        </ul>


        <%-- ----------------------------------COLUMNA IZQUIERDA---------------------------------- --%>
        <div class="col-md-2">

        </div>
        <div id="espacio" class="col-md-2" > 
            <br>
            <div class="form-group">
                <form action = "LUsuarios" method="post">
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="Accion" value="CapturarDatos">

                    <input type="submit" class=" btn btn-primary" value="Actualizar perfil">

                </form>
            </div>

            <div class="form-group">
                <form action = "LFans" method="post">
                    <input type="hidden" name="IdUsuario" value="${id}">
                    <input type="hidden" name="Accion" value="EliminarFan">
                    <input type="submit" class=" btn btn-primary" value="Eliminar cuenta">

                </form>
            </div>
        </div>

        <%-- ----------------------------------COLUMNA CENTRAL---------------------------------- --%>

        <div  class="col-md-10" >  
            <div id="" class="col-md-10" > 
                <h1> Bienvenido ${nombre}</h1>
                <h3>Estas son las últimas noticias</h3>
            </div>


            <div class="col-md-10">
                <c:forEach var="tempNoticias" items="${Noticias}">

                    <div class="c1 col-md-4">

                        <form action="LFans" method="post">
                            <input type="hidden" name="idUsuario" value="${id}">
                            <input type="hidden" name="idNoticia" value="${tempNoticias.getIdNoticias()}">
                            <input type="hidden" name="Accion" value="VerNoticias">
                            <p>
                                <span>Noticia de: ${tempNoticias.getFk_usuario()}</span>
                            </p>
                            <p>
                                <span>${tempNoticias.getTitulo()}</span>
                            </p>
                            <p>
                                <span>${tempNoticias.getContenido()}</span>
                            </p>
                            <p>
                                <span>${tempNoticias.getFecha()}</span>
                            </p>

                        </form>
                    </div>
                </c:forEach>   
            </div>


    </body>
</html>
