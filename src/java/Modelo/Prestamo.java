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
public class Prestamo {
    int numMes;
    double valorCuota;
    double valorInteres;
    double saldoRestante;

    public Prestamo(int numMes, double valorCuota, double valorInteres, double saldoRestante) {
        this.numMes = numMes;
        this.valorCuota = valorCuota;
        this.valorInteres = valorInteres;
        this.saldoRestante = saldoRestante;
    }

    public Prestamo() {
    }
    
    public int getNumMes() {
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getValorInteres() {
        return valorInteres;
    }

    public void setValorInteres(double valorInteres) {
        this.valorInteres = valorInteres;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(double saldoRestante) {
        this.saldoRestante = saldoRestante;
    }
    
}
