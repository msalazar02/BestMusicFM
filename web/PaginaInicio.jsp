<%-- 
    Document   : PaginaInicio
    Created on : 25-jun-2018, 15:19:44
    Author     : Rodrigo Moreno S
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Login</title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/PaginaInicio.css">
        <title>Login</title>
    </head>
    <body>
        <div>
            <h1>Login</h1>
        </div>

        <div id="formulario">
            <form action="LUsuarios" method="post">
            
                <input type="hidden" name="Accion" value="Verificar">
                <input type="hidden" name="idUsuario" value="0">
            
                <label>Usuario:  </label><br>
                <input type="text" class="campo" name="txtUsuario" placeholder="Ingrese su usuario" required>
                <br>
                <br>
                <label>Contraseña: </label><br>
                <input type="text" class="campo" name="txtPass" placeholder="Ingrese su contraseña" required>
                <br>
                <div id="sub">
                
                <input type="submit" class="boton" name="btnTipo" value="Ingresar">  
                </div>
                <br>
                <br>
                <input type="text" class="error" value="${Er}" readonly="" disabled="">

            </form>
        </div><!-- fomulario -->
        
       
        <div id="Registro">
            No posees una cuenta? <a href= "FormularioRegistro.jsp" onclick="">Registrate aquí</a>
        </div>
        
    </body>
</html>
