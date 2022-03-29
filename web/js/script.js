//Metodo javascript que revisa si el mes es mayor a 18, entero y si es negativo.
function checkMayorDe18OCero(input) {
    if (input.value > 18 || input.value <= 0 || input.value%1 !==0) {
        input.setCustomValidity("Ingresa un numero entero entre 1 y 18");
    } else {
        input.setCustomValidity("");
    }
}
//Metodo que revisa que el valor del prestamo sea mayor a cero
function mayorDeCero(input) {
    if (input.value <= 0) {
        input.setCustomValidity("No puede ser cero o negativo");
    } else {
        input.setCustomValidity("");
    }
}
