<%-- 
    Document   : index
    Created on : 25/03/2022, 09:19:59 PM
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
        <div class="container card">
            <div class="card-body">
                <h1 class="text-center card-header bg-primary text-white fw-bold">Generar o editar prestamo</h1>
                <form action="Controlador" onsubmit="actualizarStorage()" class="form-control">
                    Valor del prestamo en pesos<br>
                    <input type="number" name="txtValorPrestamo" id="valorPrestamo" oninput="mayorDeCero(this)"><br>
                    Meses del prestamo (maximo 18)<br>
                    <input type="number" name="txtMeses" id="totalMeses" oninput="checkMayorDe18(this); mayorDeCero(this)">
                    <br>
                    <br>
                    <input type="submit" name="accion" value="Generar prestamo" class="btn btn-success">
                </form>
            </div>
        </div>
        <div class="container card mt-3 p-4">
            <div class="card-header text-center bg-primary text-white">
                <h1 class="fw-bold">Plan de pagos del prestamo</h1>
            </div>
            <div class="card-body">
                <table class="table table-bordered border-dark">
                    <div>
                        <nav class="navbar navbar-light bg-light px-4 text-center mx-5">
                            <p class="col-sm" id="prestamoHTML"></p>
                            <p class="col-sm" id="mesesHTML"></p>
                        </nav>
                    </div>
                    <thead class="table-dark">
                        <tr>
                            <th>Numero mes</th>
                            <th>Valor a pagar</th>
                            <th>Interes del mes</th>
                            <th>Saldo restante</th>
                        </tr>
                    </thead>
                    <%
                        PrestamoDAO dao = new PrestamoDAO();
                        List<Prestamo> list = dao.listar();
                        Iterator<Prestamo> iter = list.iterator();
                        Prestamo pre = null;
                        while (iter.hasNext()) {
                            pre = iter.next();
                    %>
                    <tbody>
                        <tr>
                            <td class="fw-bold"><%= pre.getNumMes()%></td>
                            <td><%= pre.getValorCuota()%></td>
                            <td><%= pre.getValorInteres()%></td>
                            <td><%= pre.getSaldoRestante()%></td>
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
