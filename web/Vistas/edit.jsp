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
        <style>
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }
            input[type=number] {
                -moz-appearance: textfield;
            }
        </style>
    </head>
    <body>
        <script src="./js/script.js" type="text/javascript"></script>
        <div class="container card">
            <%  //Se usa un objeto DAO para listar la persona especifica con el id enviado desde index.jsp
                //Los datos de la persona los rellena en los input.
                
                PersonaDAO dao = new PersonaDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Persona p = (Persona) dao.list(id);
            %>
            <div class="card-header text-center bg-primary text-white mb-3">
                <h1 class="fw-bold">Modificar persona</h1>
            </div>
            <!-- El action Controlador es el encargado de enviar la solicitud al Controlador.java que recibe los datos de los input -->
            <form action="Controlador" class="mb-3">
                <div class="mb-3">
                    <label class="form-label">Nombre: </label>
                    <input type="text" name="txtNombre" value="<%=p.getNombre()%>" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Cedula: </label>
                    <input type="text" name="txtCedula" value="<%=p.getCedula()%>" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Valor prestamo: </label>
                    <input type="text" name="txtValorPrestamo" value="<%=p.getValorPrestamo()%>" class="form-control" oninput="mayorDeCero(this)"> 

                </div>
                <div class="mb-3">
                    <label class="form-label">Meses del prestamo: </label>
                    <input type="text" name="txtMesesPrestamo" value="<%=p.getMesesPrestamo()%>" class="form-control" oninput="checkMayorDe18OCero(this)">
                    <div class="form-text">Los meses no pueden pasar de 18</div>
                </div>
                <input type="hidden" name="txtId" value="<%=id%>">
                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
            </form>
        </div>
        <a href="index.jsp" class="btn btn-secondary ms-1">Regresar</a>
    </body>
</html>
