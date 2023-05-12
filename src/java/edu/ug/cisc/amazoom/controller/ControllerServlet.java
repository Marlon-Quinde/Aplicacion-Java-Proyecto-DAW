/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.ug.cisc.amazoom.controller;

import edu.ug.cisc.amazoom.entity.Book;
import edu.ug.cisc.amazoom.entity.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author victo
 */
@MultipartConfig
public class ControllerServlet extends HttpServlet {

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
         //try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            
            String URL="";
            ShoppingCart cart = new ShoppingCart();
            HttpSession session = request.getSession();
            cart =(ShoppingCart)session.getAttribute("cart");
            
            String action= request.getParameter("Action");
            
            if (action.equals("Agregar")) {
              Book b = new Book();
              b.setIdLibro(Integer.parseInt(request.getParameter("idLibro")));
              b.setTitulo(request.getParameter("titulo"));
              b.setAutor(request.getParameter("autor"));
              b.setPrecio(Float.parseFloat(request.getParameter("precio")));
              b.setCantidad(1);
              cart.addItem(b);
              URL = "/Catalogo.jsp";
            }
            else if(action.equals("update")){
                int idLibro = Integer.parseInt(request.getParameter("idLibro"));
                float precio = Float.parseFloat(request.getParameter("Precio"));
                int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                Book b = new Book();
                b.setPrecio((float)precio);
                b.setCantidad(cantidad);
                b.setIdLibro(idLibro);
                cart.updateItem(b);
                URL = "/checkOut.jsp";;
            }
            else if(action.equals("delete")){
               int idLibro = Integer.parseInt(request.getParameter("idLibro"));
                Book b = new Book();
                b.setIdLibro(idLibro);
                cart.deleteItem(b);
                URL = "/checkOut.jsp";
            }
            else if (action.equals("CheckOut")) {
              URL = "/checkOut.jsp";
            }
            
        //}
        RequestDispatcher rd ;
        rd= request.getRequestDispatcher(URL);        
        //response.sendRedirect(URL);
        rd.forward(request, response);
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
        processRequest(request, response);
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
