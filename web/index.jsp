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
        <title>JSP Page</title>
    </head>
    <div>
        <h1>Generar o editar prestamo</h1>
        <form action="Controlador" onsubmit="actualizarStorage()">
            Valor del prestamo en pesos<br>
            <input type="text" name="txtValorPrestamo" id="valorPrestamo"><br>
            Meses del prestamo (maximo 18)<br>
            <input type="text" name="txtMeses" id="totalMeses"><br>
            <input type="submit" name="accion" value="Generar prestamo">
            <script>
                function actualizarStorage() {
                    var totalMeses = document.getElementById("totalMeses").value;
                    var valorPrestamo = document.getElementById("valorPrestamo").value;
                    localStorage.setItem("meses", totalMeses);
                    localStorage.setItem("prestamo", valorPrestamo);
                }
                function actualizarTexto() {
                    var totalMeses = localStorage.getItem("meses");
                    var valorPrestamo = localStorage.getItem("prestamo");
                    var mesesHTML = document.getElementById("mesesHTML");
                    var prestamoHTML = document.getElementById("prestamoHTML");

                    if (totalMeses == null || valorPrestamo == null) {
                        mesesHTML.innerHTML = "Total de meses del prestamo: 0 meses";
                        prestamoHTML.innerHTML = "Valor total del prestamo: 0 pesos";
                    } else {
                        mesesHTML.innerHTML = "Total de meses del prestamo: " + totalMeses + " meses";
                        prestamoHTML.innerHTML = "Total de meses del prestamo: " + valorPrestamo + " pesos";
                    }
                }
                window.addEventListener("load", event => {
                    actualizarTexto();
                });
            </script>
        </form>
    </div>
    <div>
        <h1>Tabla de pagos del prestamo</h1>
        <table border="1">
            <p id="prestamoHTML"></p>
            <p id="mesesHTML"></p>
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
                List<Prestamo> list = dao.listar();
                Iterator<Prestamo> iter = list.iterator();
                Prestamo pre = null;
                while (iter.hasNext()) {
                    pre = iter.next();
            %>
            <tbody>
                <tr>
                    <td><%= pre.getNumMes()%></td>
                    <td><%= pre.getValorCuota()%></td>
                    <td><%= pre.getValorInteres()%></td>
                    <td><%= pre.getSaldoRestante()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <form action="Controlador">
        <input type="submit" name="accion" value="Eliminar tabla">
    </form>  
</body>
</html>
