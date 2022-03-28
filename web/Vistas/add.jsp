<%-- 
    Document   : add.jsp
    Created on : 28/03/2022, 12:53:16 PM
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
            <h1>Agregar persona</h1>
            <form action="Controlador"> 
                Nombre:<br>
                <input type="text" name="txtNombre"><br>
                Valor prestamo: <br>
                <input type="text" name="txtValorPrestamo"><br>
                Meses del prestamo: <br>
                <input type="text" name="txtMesesPrestamo"><br>
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
