<%-- 
    Document   : PaginaPrincipalArtistas
    Created on : 17-jul-2018, 20:26:30
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body b>
        <h1>Página principal de artistas</h1>
        <div class="form-group">
            <form action = "LUsuarios" method="post">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="CapturarDatos">

                <input type="submit" class=" btn btn-primary" value="Actualizar perfil">

            </form>
        </div>

        <div class="form-group">
            <form action = "LArtistas" method="post">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="EliminarArtista">
                <input type="submit" class=" btn btn-primary" value="Eliminar cuenta">

            </form>
        </div>

        <div class="form-group">
            <form action = "LAlbum" method="get">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Mostrar">
                <input type="submit" class=" btn btn-primary" value="Editar Albumes">
            </form>
        </div>

        <div class="form-group">
            <form action = "LNoticias" method="post">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="ir">
                <input type="submit" class=" btn btn-primary" value="Ingresar nueva noticia">
            </form>
        </div>

        <div class="form-group">
            <form action = "LNoticias" method="get">
                <input type="hidden" name="idUsuario" value="${id}">
                <input type="hidden" name="Accion" value="Visualizar">
                <input type="submit" class=" btn btn-primary" value="Ver noticias">
            </form>
        </div>
    </body>
</html>
