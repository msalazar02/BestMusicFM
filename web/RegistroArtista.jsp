<%-- 
    Document   : RegistroArtista
    Created on : 26-jun-2018, 0:39:20
    Author     : BestMusicFM Inc
--%>

<%@page import="java.util.List"%>
<%@page import="Datos.DUsuario"%>
<%@page import="Logica.LUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de artistas</title>
    </head>

    <h1> Usted a escogido tipo de usuario artista </h1>

    <h2>Ya casi termina con el registro, solo llene unos cuantos datos más</h2>

    <form action = "LArtistas" method="post">  
        <input type="hidden" name="Accion" value="IngresarArtista">
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
            <%
                int a = 1;
                List<String> lista = (List<String>) request.getAttribute("lista");
                for (String g : lista) {
                    
            %>
            <option value="<%=a++%>"><%=g%></option>

            <%
                }
            %>
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





</html>
