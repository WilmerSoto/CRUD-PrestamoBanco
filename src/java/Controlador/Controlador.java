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
//Controlador que sirve para manejar las solicitudes hechas desde el jsp y se encarga de la logica del codigo
public class Controlador extends HttpServlet {
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

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Metodo que recibe las solicitudes y dependiendo de que "accion" recibe, ejecuta la logica correspondiente
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
       
        // Si es eliminar la tabla llama al DAO para que elimine toda la tabla de la base de datos y recarga la pagina
        if (action.equalsIgnoreCase("Eliminar tabla")){
            dao.eliminar();
            acceso=indice;
        // Si es generar el prestamo entonces lee los parametros del frontend y los manda a este controlador
        // De aqui se hace elimina la anterior tabla y se genera al plan de pago de cada mes que se envia al DAO para que lo
        // inserte uno a uno como fila en la tabla mediante un for loop
        }else if (action.equalsIgnoreCase("Generar prestamo")){
            String mesesStr = request.getParameter("txtMeses");
            String valorPrestamoStr = request.getParameter("txtValorPrestamo");
            
            dao.eliminar();
            
            int meses = Integer.parseInt(mesesStr);
            double valorPrestamo = Double.parseDouble(valorPrestamoStr);
            double interesMeses = Math.pow((1+0.011), meses);
            
            //En caso de que los meses ingresados pasen de 18 se limitan con este if
            //En caso de excepcion ya que el javascript limita desde el frontend
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
            
            // Por cada mes se crea un objeto Prestamo y se calcula el credito restante y el interes de ese mes
            // Cada objeto creado se envia al DAO que se encarga de añadirlo a la base de datos
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
        
        //Al final solo solicita la vista del archivo que se pasa mediante "acceso", en este caso seria el index.jsp
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
