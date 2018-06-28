<%-- 
    Document   : TipoUsario
    Created on : 27-jun-2018, 1:16:36
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo de usuario</title>
    </head>
    <body>
        <h1>Tipo de usuario</h1>
        <br>
        <h3>Elija el tipo de usuario </h3>
        
        <form name="RegistroArtista" action="RegistroArtista.jsp" >
            <input type="submit" value="Registrar como artista">     
        </form>
        
        <br>
        
        <form name="RegistroExperto" action="RegistroExperto.html">
            <input type="submit" value="Registrar como experto" name="btnExp">     
        </form>
        
         <br>
         
        <form name="RegistroAdmin" action="RegistroAdmin.html" >
            <input type="submit" value="Registrar como administrador">     
        </form>
          
        
       
    </body>
</html>
