<%-- 
    Document   : visualizar
    Created on : 28/03/2022, 12:53:37 PM
    Author     : Wilmer Soto
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PrestamoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container card">
            <div class="card-header text-ceter bg-primary text-white"> 
                <h1 class="fw-bold">Plan de pagos del prestamo</h1>
            </div>
            <div class="card-body">
                <table class="table table-bordered border-dark">
                    <div>
                        <nav class="navbar navbar-ligh bg-light px-4 text-center mx-5">
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
                    <% PrestamoDAO dao = new PrestamoDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idper"));
                        Persona per = (Persona) dao.list(id);

                        double interesMeses = Math.pow((1 + 0.011), per.getMesesPrestamo());
                        double cuotaMensual = (per.getValorPrestamo() * (0.011 * (interesMeses))) / (interesMeses - 1);
                        cuotaMensual = cuotaMensual * 100;
                        cuotaMensual = Math.round(cuotaMensual);
                        cuotaMensual = cuotaMensual / 100;

                        double creditoRestante = per.getValorPrestamo();
                        double abonoMes;
                        double interesMes;

                        for (int i = 1; i <= per.getMesesPrestamo(); i++) {
                            interesMes = creditoRestante * 0.011;
                            interesMes = interesMes * 100;
                            interesMes = Math.round(interesMes);
                            interesMes = interesMes / 100;

                            abonoMes = cuotaMensual - interesMes;
                            if (i == per.getMesesPrestamo()) {
                                creditoRestante = 0;
                            } else {
                                creditoRestante = creditoRestante - abonoMes;
                                creditoRestante = creditoRestante * 100;
                                creditoRestante = Math.round(creditoRestante);
                                creditoRestante = creditoRestante / 100;
                            }


                    %>
                    <tbody>
                        <tr>
                            <td class="fw-bold"><%=i%></td>
                            <td><%=cuotaMensual%></td>
                            <td><%=interesMes%></td>
                            <td><%=creditoRestante%></td>  
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
