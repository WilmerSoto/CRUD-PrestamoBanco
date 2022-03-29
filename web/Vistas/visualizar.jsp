<%-- 
    Document   : visualizar
    Created on : 28/03/2022, 12:53:37 PM
    Author     : Wilmer Soto
--%>

<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container card">
            <div class="card-header text-center bg-primary text-white mx-3"> 
                <h1 class="fw-bold">Plan de pagos del prestamo</h1>
            </div>
            <%  //Se usa un DAO para listar la persona con la id enviada anteriormente
                //Se usa para la logica del plan de pagos y para mostrar los datos de la persona en el HTML
                
                PersonaDAO dao = new PersonaDAO();
                int id = Integer.parseInt((String) request.getAttribute("idper"));
                Persona per = (Persona) dao.list(id);
            %>
            <div>
                <nav class="navbar navbar-ligh bg-light px-4 text-center mx-3">
                    <p><strong>NOMBRE:</strong> <%=per.getNombre()%></p>
                    <p><strong>CEDULA:</strong> <%=per.getCedula()%></p>
                    <p><strong>VALOR PRESTAMO:</strong> <%=per.getValorPrestamo()%></p>
                    <p><strong>MESES DEL PRESTAMO:</strong> <%=per.getMesesPrestamo()%></p>         
                </nav>
            </div>
            <div class="card-body">
                <table class="table table-bordered border-dark">
                    <thead class="table-dark">
                        <tr>
                            <th>Numero mes</th>
                            <th>Valor a pagar</th>
                            <th>Interes del mes</th>
                            <th>Saldo restante</th>
                        </tr>
                    </thead>
                    <%  //Logica encargada de calcular la cuota mensual, el valor de interes del mes y el saldo restante para ese mes
                        //Crea una fila en la tabla por cada mes.
                        
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
        <a href="index.jsp" class="btn btn-secondary ms-1">Regresar</a>
    </body>
</html>
