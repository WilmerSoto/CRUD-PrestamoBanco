<%-- 
    Document   : edit.jsp
    Created on : 28/03/2022, 12:53:22 PM
    Author     : Wilmer Soto
--%>

<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
                PersonaDAO dao = new PersonaDAO();
                int id = Integer.parseInt((String)request.getAttribute("idper"));
                Persona p = (Persona)dao.list(id);       
            %>
            <h1>Modificar persona</h1>
            <form action="Controlador"> 
                Nombre:<br>
                <input type="text" name="txtNombre" value="<%=p.getNombre()%>"><br>
                Cedula: <br>
                <input type="text" name="txtCedula" value="<%=p.getCedula()%>"><br>
                Valor prestamo: <br>
                <input type="text" name="txtValorPrestamo" value="<%=p.getValorPrestamo()%>"><br>
                Meses del prestamo: <br>
                <input type="text" name="txtMesesPrestamo" value="<%=p.getMesesPrestamo()%>"><br>
                <input type="hidden" name="txtId" value="<%=id%>">
                <input type="submit" name="accion" value="Actualizar"><br>
            </form>
        </div>
    </body>
</html>
