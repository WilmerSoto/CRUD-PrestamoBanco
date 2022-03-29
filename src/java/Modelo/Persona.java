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

// Clase persona que construye los datos de una persona de la base de datos
// En la logica se busca la persona por la id autoasignada en la base de datos y se crea mediante los setters
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
