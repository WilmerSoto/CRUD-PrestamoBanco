/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Wilmer Soto
 */

// Clase prestamo que recibe los datos del mes del prestamo que se va a hacer, 
// en la logica se crea un objeto por cada mes y se manda al DAO
public class Persona {
    int id;
    String nombre;
    String cedula;
    int valorPrestamo;
    int mesesPrestamo;
    
    public Persona(String nombre, String cedula, int valorPrestamo, int mesesPrestamo) {
        this.nombre = nombre;
        this.valorPrestamo = valorPrestamo;
        this.mesesPrestamo = mesesPrestamo;
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(int valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public int getMesesPrestamo() {
        return mesesPrestamo;
    }

    public void setMesesPrestamo(int mesesPrestamo) {
        this.mesesPrestamo = mesesPrestamo;
    }

    public Persona() {
    }
    

}
