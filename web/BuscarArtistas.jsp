<%-- 
    Document   : BuscarAmigos
    Created on : 21/08/2018, 11:38:04 AM
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/Auxiliar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%-- ----------------------------------LINKS---------------------------------- --%>
    <c:url var="linkEditar" value="LAlbum">
        <c:param name="Accion" value="Mostrar"></c:param>
        <c:param name="idUsuario" value="${id}"></c:param>
    </c:url>

    <c:url var="linkNoticias" value="LNoticias">
        <c:param name="Accion" value="ir"></c:param>
        <c:param name="idUsuario" value="${id}"></c:param>
    </c:url>  

    <c:url var="linkVisualizar" value="LNoticias">
        <c:param name="Accion" value="Visualizar"></c:param>
        <c:param name="idUsuario" value="${id}"></c:param>
    </c:url>
    <c:url var="salir" value="PaginaInicio.jsp">

    </c:url>
    <c:url var="irArtista" value="LUsuarios">
        <c:param name="Accion" value="SaberNombre"></c:param>
        <c:param name="idUsuario" value="${id}"></c:param>
    </c:url>

    <%-- ----------------------------------NAVBAR---------------------------------- --%>

    <ul class="nav nav-tabs navbar-inverse" id="formtabs">
        <!-- Tab nav -->
        <li class=""><a href="${irArtista}"  data-toggle="tab">Inicio</a></li>
        <li class="active"><a href="${linkEditar}" data-toggle="tab">Buscar artistas</a></li>
        <li class=""><a href="${linkVisualizar}" data-toggle="tab">Noticias</a></li>   
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
            <div id="" class="col-md-11" > 
                <h1> ¿Buscando </h1>
                <h3>¿Qué deseas hacer hoy?</h3>
            </div>
        <div class="col-md-10">

            <div class="c1 col-md-3">
                <form>
                    <p>
                        Título
                    </p>
                    <p>
                        Cuerpo a aaaaaaa aaaaaaaaaaaaa aaaaaaa aaaaaa aaaaaa aaaaaaaaaaa aaaaaaaaaaaa
                        aaaaaaaaaaaaa aaaaaaaa aaaaaaaaaaaaa aaaaa
                    </p>
                </form>
            </div>

            <div class="c2 col-md-3">
                <form>
                    <p>
                        Título
                    </p>
                    <p>
                        Cuerpo a aaaaaaa aaaaaaaaaaaaa aaaaaaa aaaaaa aaaaaa aaaaaaaaaaa aaaaaaaaaaaa
                        aaaaaaaaaaaaa aaaaaaaa aaaaaaaaaaaaa aaaaa
                    </p>
                </form>
            </div>

            <div class=" c1 col-md-3">
                <form>
                    <p>
                        Título
                    </p>
                    <p>
                        Cuerpo a aaaaaaa aaaaaaaaaaaaa aaaaaaa aaaaaa aaaaaa aaaaaaaaaaa aaaaaaaaaaaa
                        aaaaaaaaaaaaa aaaaaaaa aaaaaaaaaaaaa aaaaa
                    </p>
                </form>
            </div>

            <div class=" c2 col-md-3">
                <form>
                    <p>
                        Título
                    </p>
                    <p>
                        Cuerpo a aaaaaaa aaaaaaaaaaaaa aaaaaaa aaaaaa aaaaaa aaaaaaaaaaa aaaaaaaaaaaa
                        aaaaaaaaaaaaa aaaaaaaa aaaaaaaaaaaaa aaaaa
                    </p>
                </form>
            </div>
    
    
</body>
</html>
