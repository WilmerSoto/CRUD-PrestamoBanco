<%-- 
    Document   : listar
    Created on : 25/03/2022, 09:30:56 PM
    Author     : Wilmer Soto
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Prestamo"%>
<%@page import="ModeloDAO.PrestamoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Tabla de pagos del prestamo</h1>
            <a href="Controlador?accion=add">Generar nuevo prestamo</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Numero mes</th>
                        <th>Valor a pagar</th>
                        <th>Interes del mes</th>
                        <th>Saldo restante</th>
                    </tr>
                </thead>
                <%
                    PrestamoDAO dao = new PrestamoDAO();
                    List<Prestamo>list = dao.listar();
                    Iterator<Prestamo>iter = list.iterator();
                    Prestamo pre = null;
                    while (iter.hasNext()){
                        pre = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%= pre.getNumMes()%></td>
                        <td><%= pre.getValorCuota()%></td>
                        <td><%= pre.getValorInteres()%></td>
                        <td><%= pre.getSaldoRestante()%></td>
                        <td>
                            <a>Editar</a>
                            <a>Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
