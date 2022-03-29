/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
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
    String add="Vistas/add.jsp";
    String edit="Vistas/edit.jsp";
    String visualizar="Vistas/visualizar.jsp";
    
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
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
        int id;
        String action=request.getParameter("accion");
       
        // Si es eliminar la tabla llama al DAO para que elimine toda la tabla de la base de datos y recarga la pagina
        if(action.equalsIgnoreCase("add")){
            acceso=add;
            
        }else if (action.equalsIgnoreCase("Agregar")){
            String nombre = request.getParameter("txtNombre");
            String valorPrestamoStr = request.getParameter("txtValorPrestamo");
            String mesesStr = request.getParameter("txtMesesPrestamo");
                    
            int valorPrestamo = Integer.parseInt(valorPrestamoStr);
            int mesesPrestamo = Integer.parseInt(mesesStr);
            p.setNombre(nombre);
            p.setValorPrestamo(valorPrestamo);
            p.setMesesPrestamo(mesesPrestamo);
            dao.add(p);
            acceso = indice;
            
        }else if (action.equalsIgnoreCase("edit")){
            request.setAttribute("idper", request.getParameter("id"));
            acceso=edit;
            
        } else if (action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombre");
            String valorPrestamoStr = request.getParameter("txtValorPrestamo");
            String mesesStr = request.getParameter("txtMesesPrestamo");
                    
            int valorPrestamo = Integer.parseInt(valorPrestamoStr);
            int mesesPrestamo = Integer.parseInt(mesesStr);
            
            p.setId(id);
            p.setNombre(nombre);
            p.setValorPrestamo(valorPrestamo);
            p.setMesesPrestamo(mesesPrestamo);
            dao.edit(p);
            acceso=indice;
            
        } else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=indice;
        } else if (action.equalsIgnoreCase("visualizar")){
            request.setAttribute("idper", request.getParameter("id"));
            acceso=visualizar;
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
