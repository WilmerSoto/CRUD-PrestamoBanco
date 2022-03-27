<%-- 
    Document   : add
    Created on : 25/03/2022, 09:31:09 PM
    Author     : Wilmer Soto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Generar o editar prestamo</h1>
            <form action="Controlador">
                Valor del prestamo en pesos<br>
                <input type="text" name="txtValorPrestamo"><br>
                Meses del prestamo (maximo 18)<br>
                <input type="text" name="txtMeses"><br>
                <input type="submit" name="accion" value="Generar prestamo">
            </form>
        </div>
    </body>
</html>
