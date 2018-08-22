
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/ActivarDesactivarBotones.js" type="text/javascript"></script>
        <script src="js/Aviso.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>Eventos</title>

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
            <c:param name="IdUsuario" value="${id}"></c:param>
        </c:url>

        <c:url var="salir" value="PaginaInicio.jsp"></c:url>

        <%-- ----------------------------------NAVBAR---------------------------------- --%>

        <ul class="nav nav-tabs navbar-inverse" id="formtabs">
            <!-- Tab nav -->
            <li class=""><a href="${irFan}"  data-toggle="tab">Inicio</a></li>
            <li class=""><a href="${linkAmigos}" data-toggle="tab">Buscar artistas</a></li>
            <li class="active"><a href="${linkEventos}" data-toggle="tab">Eventos</a></li>   
            <li class=""><a href="${salir}" data-toggle="tab">Logout</a></li> 
        </ul>

        <%-- ----------------------------------COLUMNA IZQUIERDA---------------------------------- --%>

        <div class="col-md-2">

        </div>
        <div id="espacio" class="col-md-2" > 
            <br>
        </div>



        <%-- ----------------------------------COLUMNA CENTRAL---------------------------------- --%>

        <h1>Eventos</h1>

        <h3>¡Hoy es un buen día para crear un nuevo evento y quedar con tus amigos!</h3>

        <%-- -----------------------------------TEXTO------------------------------------- --%>

        <h1> Bienvenido a los eventos </h1> 
        <h3 id="botones" hidden>${botones}</h3>
        <h3 id="aviso" hidden>${aviso}</h3>
        <h3>Lista de eventos actuales</h3> 
        <%-- -----------------------------------AVISO------------------------------------- --%>

        <div id="Error" class="col-md-11 alert alert-danger alert-dismissible" role="alert">
            En este momento no hay eventos registrados para éste usuario
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%-- -----------------------------------TABLA------------------------------------- --%>

        <div class="col-md-8">
            <table class="table table-hover ">


                <thead class="thead-dark">

                    <tr class="thead-dark success">
                        <th class="cabecera">Código</th>
                        <th class="cabecera">Tipo de evento</th>
                        <th class="cabecera">Título</th>
                        <th class="cabecera">Fecha del evento</th>
                        <th class="cabecera">Ubicacion</th>
                        <th class="cabecera">Contenido</th>
                        <th class="cabecera">Acciones</th>

                    </tr>
                </thead>

                <c:forEach var="tempEvento" items="${Eventos}">

                    <%-- Link para eliminar cada dato utilizando el campo clave --%>

                    <c:url var="linkEliminar" value="LEventos">
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Accion" value="Eliminar"></c:param>
                        <c:param name="Codigo" value="${tempEvento.getPk_idEventos()}"></c:param>
                    </c:url>

                    <%-- Link actualizador para cada evento utilizando el campo clave --%>
                    <c:url var="linkCargar" value="LEventos">
                        <c:param name="Accion" value="Cargar"></c:param>
                        <c:param name="idUsuario" value="${id}"></c:param>
                        <c:param name="Codigo" value="${tempEvento.getPk_idEventos()}"></c:param>

                    </c:url>


                    <tr>
                        <td class="filas"> ${tempEvento.getPk_idEventos()} </td>
                        <td class="filas"> ${tempEvento.getFk_idTipoEvento()} </td>
                        <td class="filas"> ${tempEvento.getTitulo()} </td>
                        <td class="filas"> ${tempEvento.getFecha_de_evento()} </td>
                        <td class="filas"> ${tempEvento.getUbicacion()} </td> 
                        <td class="filas"> ${tempEvento.getContenido()} </td> 
                        <td class="filas">  
                            <a href="${linkCargar}"><img src="Imagenes/icons8-actualizar-15.png" width="15" height="15" alt="icons8-actualizar-15"/></a>
                            &nbsp;
                            <a href="${linkEliminar}"><img src="Imagenes/icons8-basura-32.png" width="20" height="20" alt="icons8-basura-32"/></a>

                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>

    </body>
</html>
