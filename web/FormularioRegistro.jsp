<%-- 
    Document   : FormularioRegistro
    Created on : 30-jun-2018, 21:11:03
    Author     : Rodrigo Moreno S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="css/FormularioRegistro.css">
        <title>Formulario de registro</title>
    </head>
    <body>

        <h1>Formulario de registro</h1>

        <h2>Bienvenido a BestMusicFM</h2>

        <h3>Para ser parte de esta rítmica red social, primero inicia registrandote</h3>
        <div id="formulario" >
            <form action = "LUsuarios" method="post">

                <input type="hidden" name="Accion" value="Ingresar">
                <input type="hidden" name="idUsuario" value="0">

                <label>Nombre</label>
                <br> 
                <input type="text" class="txt" name="nombre" id="nombre" required="">


                <label>Primer apellido </label>
                <br> 
                <input type="text" class="txt" name="apellido1" id="apellido1" required="">&nbsp;&nbsp;
                <br> 
                 <label>Segundo apellido </label>
                <br> 
                <input type="text" class="txt" name="apellido2" id="apellido2" required="">


                <label>Fecha de nacimiento</label>
                <br> 
                <input type = "date" class="txt" name = "fechanaci" required="">

                <label>Email</label>

                <br>
                <input type="text" class="txt" name="email" required="">


                <label>Usuario</label>
                <br>   
                <input type="text" class="txt" name="usuario" required="">
                <input type="text" class="error" value="${error}" name="error" disabled="" readonly="">


                <label>Contraseña</label>
                <br> 
                <input type="password" class="txt" name="contrasena" id="contraseña" required="">


                Género
                <br>
                <input type="radio" class="radio" name="sexo" id="sexo_01" value="Femenino" required="">  Mujer
                <input type="radio" class="radio" name="sexo" id="sexo_02" value="Masculino" required=""> Hombre

                <br>

                País de nacimiento 
                <br> 

                <select name="pais" id="pais" class="cbx" >
                    <option>Costa Rica</option>
                    <option>México</option>
                    <option>Colombia</option>
                    <option>Chile</option>
                    <option>Perú</option>
                    <option>Argentina</option>
                    <option>España</option>
                </select>

                <br>
                <br>

                Tipo de cuenta 
                <br>
                <input type="radio" name="tipoUsuario" value="Artista" required=""> Artista
                <input type="radio" name="tipoUsuario" value="Experto" required=""> Experto
                <input type="radio" name="tipoUsuario" value="Administrador" required=""> Administrador
                <br>
                <br>

                <input type="submit" class="enviar" name = "btnEnviar" id="button" value="Enviar">


            </form>
        </div>
    </body>
</html>
