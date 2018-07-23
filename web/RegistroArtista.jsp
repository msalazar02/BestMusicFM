<%-- 
    Document   : RegistroArtista
    Created on : 26-jun-2018, 0:39:20
    Author     : BestMusicFM Inc
--%>

<%@page import="java.util.List"%>
<%@page import="Datos.DUsuario"%>
<%@page import="Logica.LUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de artistas</title>
    </head>
    <body>
        <h1> Usted a escogido tipo de usuario artista </h1>

        <h2>Ya casi termina con el registro, solo llene unos cuantos datos más</h2>

        <form action = "LArtistas" method="post">  
            <input type="hidden" name="Accion" value="IngresarArtista">
            <input type="hidden" name="idUsuario" value="${id}">
            Tipo de artista
            <br/> 
            <select name="TipoArtista" id="tipoArtista" required >
                <option value="Solista">Solista</option>
                <option value="Banda">Integran de de una Banda</option>
            </select>
            <br/>
            <br/>

            Fecha de inicio
            <br/> 
            <input type="date" name="fecha" required>
            <br/>
            <br/>

            Género musical
            <br/> 
            <select name="generoM" id="generoM" required>
                <%int a = 0;%>
                <c:forEach var="tempGeneros" items="${Generos }">
                    <c:url var="linkCargar" value="LGenero">

                        <c:param name="Accion" value="Mostrar"></c:param>
                        
                    </c:url>
                    <option value="<%a++;%>">
                        ${tempGeneros.getNombre()}
                    </option>
                </c:forEach>
            </select>
            <br/>
            <br/>

            Biografía
            <br/> 
            <textarea name="biografia" rows="4" cols="20" required>
            </textarea>
            <br/>
            <br/>

            Nombre de la banda o nombre artístico:
            <br/> 
            <input type="text" name="nombre" id="nombre" required>
            <br/>
            <br/>
            <input type="submit" name = "button" id="button" value="Enviar" required>

        </form>


    </body>


</html>
