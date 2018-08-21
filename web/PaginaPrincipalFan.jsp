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
        <c:url var="irFan" value="LFans">
            <c:param name="Accion" value="Buscar"></c:param>
            <c:param name="IdUsuario" value="${id}"></c:param>
        </c:url>

        <%-- ----------------------------------NAVBAR---------------------------------- --%>

        <ul class="nav nav-tabs navbar-inverse" id="formtabs">
            <!-- Tab nav -->
            <li class="active"><a href="${irFan}"  data-toggle="tab">Inicio</a></li>
            <li class=""><a href="${linkAmigos}" data-toggle="tab">Buscar artistas</a></li>
            <li class=""><a href="${linkVisualizar}" data-toggle="tab">Noticias</a></li>   
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
                    <input type="hidden" name="idUsuario" value="${id}">
                    <input type="hidden" name="Accion" value="EliminarFan">
                    <input type="submit" class=" btn btn-primary" value="Eliminar cuenta">

                </form>
            </div>
        </div>
                    
        <%-- ----------------------------------COLUMNA CENTRAL---------------------------------- --%>

        <div  class="col-md-10" >  
            <div id="" class="col-md-11" > 
                <h1> Bienvenido ${nombre}</h1>
                <h3>Estas son las últimas noticias</h3>
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
        </div>

        <%--<%int n = 1;%>

         <c:forEach var="tempNoticias" items="${Noticias}">
            <%

                String color = "c";
                color = color + n;
                n++;
                if (n == 6) {
                    n = 1;
                }
            %>
            <div class="<%=color%> col-md-1">
                <form>

                </form>
            </div>
        </c:forEach>    --%>



    </body>
</html>
