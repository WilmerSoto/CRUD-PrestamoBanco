/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Prestamo;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Wilmer Soto
 */
public class PrestamoDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Prestamo p = new Prestamo();
    
    @Override
    public List listar() {
        ArrayList<Prestamo>list = new ArrayList<>();
        String sql = "select * from prestamobanco";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Prestamo pre = new Prestamo();
                pre.setNumMes(rs.getInt("numMes"));
                pre.setValorCuota(rs.getDouble("valorCuota"));
                pre.setValorInteres(rs.getDouble("valorInteres"));
                pre.setSaldoRestante(rs.getDouble("saldoRestante"));
                list.add(pre);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Prestamo list(int numMes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Prestamo prestamo) {
        String sql = "insert into prestamobanco(numMes, valorCuota, valorInteres, saldoRestante)values('"+prestamo.getNumMes()+"','"+prestamo.getValorCuota()+"','"+prestamo.getValorInteres()+"','"+prestamo.getSaldoRestante()+"')";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        }
        
    

    @Override
    public boolean edit(Prestamo prestamo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        String sql = "delete from prestamobanco";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
