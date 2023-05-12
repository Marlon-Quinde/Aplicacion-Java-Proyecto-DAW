/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.amazoom.controlador;

import com.amazoom.config.Fecha;
import com.amazoom.modelo.Book;
import com.amazoom.modeloDAO.BookDAO;
import com.amazoom.modelo.Carrito;
import com.amazoom.modelo.Compra;
import com.amazoom.modelo.Pago;
import com.amazoom.modelo.Usuario;
import com.amazoom.modeloDAO.CompraDAO;
import edu.ug.cisc.amazoom.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
/**
 *
 * @author User
 */
@MultipartConfig
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    BookDAO bdao = new BookDAO();
    Book b = new Book();
    List<Book> libros = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idb;
    Carrito car;
    DecimalFormat df = new DecimalFormat("#.00");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        libros = bdao.listar();
        switch (accion) {
            case "Comprar":
                totalPagar = 0;
                idb = Integer.parseInt(request.getParameter("id"));
                b = bdao.listarId(idb);
                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdLibro(b.getIdLibro());
                car.setTitulo(b.getTitulo());
                car.setSintesis(b.getSintesis());
                car.setPrecioCompra(b.getPrecio());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad * b.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();

                }
                request.setAttribute("totalPagar", df.format(totalPagar));
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idb = Integer.parseInt(request.getParameter("id"));
                b = bdao.listarId(idb);
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idb == listaCarrito.get(i).getIdLibro()) {
                            pos = i;
                        }

                    }
                    if (idb == listaCarrito.get(pos).getIdLibro()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        float subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal(Math.round(subtotal * 100.0) / 100.0);

                    } else {
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdLibro(b.getIdLibro());
                        car.setTitulo(b.getTitulo());
                        car.setSintesis(b.getSintesis());
                        car.setPrecioCompra(b.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubtotal(Math.round(cantidad * b.getPrecio() * 100.0) / 100.0);
                        listaCarrito.add(car);
                    }
                } else {
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdLibro(b.getIdLibro());
                    car.setTitulo(b.getTitulo());
                    car.setSintesis(b.getSintesis());
                    car.setPrecioCompra(b.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubtotal(cantidad * b.getPrecio());
                    listaCarrito.add(car);

                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;

            case "Delete":
                int idlibro = Integer.parseInt(request.getParameter("idb"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdLibro() == idlibro) {
                        listaCarrito.remove(i);
                    }
                }
                break;
            case "ActualizarCantidad":
                int idlib = Integer.parseInt(request.getParameter("idb"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdLibro() == idlib) {
                        listaCarrito.get(i).setCantidad(cant);
                        float st = listaCarrito.get(i).getPrecioCompra() * cant;
                        listaCarrito.get(i).setSubtotal(Math.round(st * 100.0) / 100.0);
                    }
                }
                break;
            case "Carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();

                }
                request.setAttribute("totalPagar", df.format(totalPagar));
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "GenerarCompra":
                Usuario usuario = new Usuario();
                usuario.setId(1);
                //Pago pago=new Pago();
                CompraDAO dao = new CompraDAO();
                Compra compra = new Compra(usuario, 1, totalPagar, "Cancelar", listaCarrito);
                int res = dao.GenerarCompra(compra);
                if (res != 0 && totalPagar > 0) {
                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
                }
                break;
            case "verLibro":
                request.getRequestDispatcher("verLibro.jsp").forward(request, response);
                break;
            case "Modificar Libro":
                String titulo=request.getParameter("titulo");
                String autor=request.getParameter("autor");
                float precio=Float.parseFloat(request.getParameter("precio"));
                int idcategoria=Integer.parseInt(request.getParameter("idcategoria"));
                String sintesis=request.getParameter("sintesis");
                Part part=request.getPart("filefoto");
                InputStream inputStream=part.getInputStream();
                b.setTitulo(titulo);
                b.setAutor(autor);
                b.setPrecio(precio);
                b.setIdCategoria(idcategoria);
                b.setSintesis(sintesis);
                b.setFoto(inputStream);
                bdao.modificar(b);
                request.getRequestDispatcher("verLibro.jsp").forward(request, response);
                break;

            default:
                request.setAttribute("libros", libros);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
