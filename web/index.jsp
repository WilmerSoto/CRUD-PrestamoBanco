<%-- 
    Document   : index
    Created on : 25/03/2022, 09:19:59 PM
    Author     : Wilmer Soto
--%>

<%@page import="Modelo.Persona"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Calculadora de prestamo bancario</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
        <script src="./js/script.js"></script>
        <a href="Controlador?accion=add">Agregar persona</a>
        <div class="container card mt-3 p-4">
            <div class="card-header text-center bg-primary text-white">
                <h1 class="fw-bold">Lista de personas con prestamos</h1>
            </div>
            <div class="card-body">
                <table class="table table-bordered border-dark">
                    <thead class="table-dark">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Cedula</th>
                            <th>Valor prestamo</th>
                            <th>Meses del prestamo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%
                        PersonaDAO dao = new PersonaDAO();
                        List<Persona> list = dao.listar();
                        Iterator<Persona> iter = list.iterator();
                        Persona pre = null;
                        while (iter.hasNext()) {
                            pre = iter.next();
                    %>
                    <tbody>
                        <tr>
                            <td class="fw-bold" id="numMes"><%= pre.getId()%></td>
                            <td><%= pre.getNombre()%></td>
                            <td><%= pre.getCedula()%></td>
                            <td><%= pre.getValorPrestamo()%></td>
                            <td><%= pre.getMesesPrestamo()%></td>
                            <td>
                                <a href="Controlador?accion=visualizar&id=<%= pre.getId()%>">Ver prestamo</a>
                                <a href="Controlador?accion=edit&id=<%= pre.getId()%>">Editar</a>
                                <a href="Controlador?accion=eliminar&id=<%= pre.getId()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <br>
            <form action="Controlador">
                <input type="submit" name="accion" value="Eliminar tabla" class="btn btn-danger">
            </form>  
        </div>
    </body>
</html>
