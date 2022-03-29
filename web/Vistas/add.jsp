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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Añadir usuario</title>
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
            <div class="card-header text-center bg-primary text-white mb-3">
                <h1 class="fw-bold">Agregar persona</h1>
            </div>
            <!-- El action controlador envia la solicitud al controlador.java y de ahi se sacan los valores
                 que estan dentro del name de cada input  --->
            <form action="Controlador" class="mb-3">
                <div class="mb-3">
                    <label class="form-label">Nombre: </label>
                    <input type="text" name="txtNombre" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Cedula: </label>
                    <input type="text" name="txtCedula" class="form-control"> 
                </div>
                <div class="mb-3">
                    <label class="form-label">Valor del prestamo: </label>
                    <input type="number" name="txtValorPrestamo" class="form-control" oninput="mayorDeCero(this)">
                </div>
                <div class="mb-3">
                    <label class="form-label" >Meses del prestamo</label>
                    <input type="number" name="txtMesesPrestamo" class="form-control" oninput="checkMayorDe18OCero(this)">
                    <div class="form-text">Los meses no pueden pasar de 18</div>
                </div>
                <input type="submit" name="accion" value="Agregar" class="btn btn-success">
            </form>
        </div>
        <a href="index.jsp" class="btn btn-secondary ms-1">Regresar</a> 
    </body>
</html>
