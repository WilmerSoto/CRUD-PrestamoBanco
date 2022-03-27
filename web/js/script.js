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

    mesesHTML.innerHTML = "MESES: " + totalMeses + " meses";
    prestamoHTML.innerHTML = "VALOR: " + valorPrestamo + " pesos";
}
window.addEventListener("load", event => {
    prestamoEnCero();
});
function checkMayorDe18(input) {
    if (input.value > 18 || input.value <= 0) {
        input.setCustomValidity("Ingresa un numero entre 1 y 18");
    } else {
        input.setCustomValidity("");
    }
}
function prestamoEnCero() {
    var mesTabla = document.getElementById("numMes").value;
    
    if (mesTabla === null) {
        localStorage.removeItem("meses");
        localStorage.removeItem("prestamo");
        actualizarTexto();
    } else {
        actualizarTexto();
    }
}
function mayorDeCero(input) {
    if (input.value <= 0) {
        input.setCustomValidity("No puede ser cero o negativo");
    } else {
        input.setCustomValidity("");
    }
}
