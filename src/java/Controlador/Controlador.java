/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Prestamo;
import ModeloDAO.PrestamoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.round;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wilmer Soto
 */
public class Controlador extends HttpServlet {
    String listar="Vistas/listar.jsp";
    String add="Vistas/add.jsp";
    String edit="Vistas/edit.jsp";
    String indice="index.jsp";
   
    Prestamo p = new Prestamo();
    PrestamoDAO dao = new PrestamoDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
       
        if (action.equalsIgnoreCase("listar")){
            acceso = listar;
        } else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }else if (action.equalsIgnoreCase("Eliminar tabla")){
            dao.eliminar();
            acceso=indice;
        }else if (action.equalsIgnoreCase("Generar prestamo")){
            String mesesStr = request.getParameter("txtMeses");
            String valorPrestamoStr = request.getParameter("txtValorPrestamo");
            
            dao.eliminar();
            
            int meses = Integer.parseInt(mesesStr);
            double valorPrestamo = Double.parseDouble(valorPrestamoStr);
            double interesMeses = Math.pow((1+0.011), meses);
            
            if (meses>18){
                meses = 18;
            }
            
            double cuotaMensual = (valorPrestamo*(0.011*(interesMeses))) / (interesMeses-1);
            cuotaMensual = cuotaMensual*100;
            cuotaMensual = round(cuotaMensual);
            cuotaMensual = cuotaMensual/100;
            
            p.setValorCuota(cuotaMensual);
            
            double creditoRestante = valorPrestamo;
            double abonoMes;
            double interesMes;
            for (int i = 1; i <= meses; i++){
                interesMes = creditoRestante*0.011;
                interesMes = interesMes*100;
                interesMes = round(interesMes);
                interesMes = interesMes/100;
                
                p.setNumMes(i);
                p.setValorInteres(interesMes);
                abonoMes = cuotaMensual - interesMes;
                
                creditoRestante = creditoRestante - abonoMes;
                creditoRestante = creditoRestante*100;
                creditoRestante = round(creditoRestante);
                creditoRestante = creditoRestante/100;
                
                p.setSaldoRestante(creditoRestante);
                
                if (i == meses){
                    p.setSaldoRestante(0);
                }
                
                dao.add(p);
            }
            acceso = indice;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
