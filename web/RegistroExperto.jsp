<%-- 
    Document   : RegistroExperto
    Created on : 30-jun-2018, 13:23:13
    Author     : Rodrigo Moreno S
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Experto</title>
    </head>
    <body>
        <h1> Usted a escogido tipo de usuario experto </h1>

        <h2>Ya casi termina con el registro, solo llene unos cuantos datos más</h2>

        <form action = "LExpertos" method="post">  
            <input type="hidden" name="Accion" value="IngresarExperto">
            <input type="hidden" name="idUsuario" value="${id}">

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
                    <option value="${tempGeneros.getIdGenero_musical()}">
                        ${tempGeneros.getNombre()}
                    </option>
                </c:forEach>
            </select>
            <br/>
            <br/>

            Descripción
            <br/> 
            <textarea name="descripcion" rows="4" cols="20" required>
            </textarea>
            <br/>
            <br/>

            <input type="submit" name = "button" id="button" value="Enviar" required>

        </form>


    </body>

</html>
