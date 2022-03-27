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
        mesesHTML.innerHTML = "MESES: 0 meses";
        prestamoHTML.innerHTML = "VALOR: 0 pesos";
    } else {
        mesesHTML.innerHTML = "MESES: " + totalMeses + " meses";
        prestamoHTML.innerHTML = "VALOR: " + valorPrestamo + " pesos";
    }
}
window.addEventListener("load", event => {
    actualizarTexto();
});
function checkMayorDe18(input) {
    if (input.value > 18) {
        input.setCustomValidity("Los meses del prestamo no pueden ser mayores a 18");
    } else {
        input.setCustomValidity("");
    }
}

function mayorDeCero(input){
    if (input.value <= 0){
        input.setCustomValidity("No puede ser cero o negativo");
    } else{
        input.setCustomValidity("");
    }
}
