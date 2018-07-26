<%-- 
    Document   : DatosNoticia
    Created on : Jun 26, 2018, 2:53:08 PM
    Author     : darian
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noticia</title>
    </head>
    <body>

        <h1> Crea una nueva publicación </h1>
        <h3>¿Qué estás pensando hoy?, escribe unas palabras para tus seguidores</h3>

        <form action = "LNoticias" method="post">  

            <input type="hidden" name="idUsuario" value="${id}">
            <input type="hidden" name="Accion" value="Escribir">

           <div class="form-group">
                <label for="titulo">Título</label>
                <input type="text" class="form-control"name="titulo" required="">
            </div> 

            <div class="form-group">
                <label for="titulo">Título</label>
                <input type="text" class="form-control" value="${PublicacionActualizar.getTitulo()}" name="titulo" required="">
            </div> 
            Escribe algo para tus seguidores:

            <br/>  
            <textarea name="contenido" rows="4" cols="20" id="contenido" required="">
            </textarea>
            <br/>
            <br/>

            <input type="submit" name = "btnPublicar" id="button" value="Publicar"/>

        </form>



    </body>
</html>
