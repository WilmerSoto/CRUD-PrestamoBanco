/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Wilmer Soto
 */

// DAO que guarda todos los metodos que se ejecutan en el servidor
public class PersonaDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    
    // Este metodo envia como solicitud sql la String llamada sql que selecciona todos los datos de la base de datos
    // y los guarda uno a uno en un objeto Prestamo que se añaden a una lista. En el index.jsp se itera sobre esta lista.
    @Override
    public List listar() {
        ArrayList<Persona>list = new ArrayList<>();
        String sql = "select * from personasbanco";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona pre = new Persona();
                pre.setId(rs.getInt("Id"));
                pre.setNombre(rs.getString("nombre"));
                pre.setValorPrestamo(rs.getInt("valorPrestamo"));
                pre.setMesesPrestamo(rs.getInt("mesesPrestamo"));
                list.add(pre);
            }
        } catch (Exception e) {
        }
        return list;
    }

    // Metodo que recibe el objeto a insertar en la tabla de la base de datos
    @Override
    public boolean add(Persona per) {
        String sql = "insert into personasbanco(nombre, valorPrestamo, mesesPrestamo)values('"+per.getNombre()+"','"+per.getValorPrestamo()+"','"+per.getMesesPrestamo()+"')";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        }
        
    // Metodo que envia una solicitud sql de borrar todos los datos de la base de datos

    @Override
    public Persona list(int id) {
        String sql = "select * from personasbanco where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("Id"));
                p.setNombre(rs.getString("nombre"));
                p.setValorPrestamo(rs.getInt("valorPrestamo"));
                p.setMesesPrestamo(rs.getInt("mesesPrestamo"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update personasbanco set nombre='"+per.getNombre()+"',valorPrestamo='"+per.getValorPrestamo()+"',mesesPrestamo='"+per.getMesesPrestamo()+"'where Id="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from personasbanco where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
