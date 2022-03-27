/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Prestamo;
import java.util.List;

/**
 *
 * @author Wilmer Soto
 */
//Interface que se conecta al ModeloDAO
public interface CRUD {
    public List listar();
    public boolean add(Prestamo prestamo);
    public boolean eliminar();
    
}
