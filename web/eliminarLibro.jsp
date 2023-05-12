<%-- 
    Document   : paginaPrincipal
    Created on : 15 sep. 2022, 16:23:12
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bookDAO" class="edu.ug.cisc.amazoom.dao.BookDAO" scope="request"></jsp:useBean>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="edu.ug.cisc.amazoom.entity.Book" %>
<%@ page import="edu.ug.cisc.amazoom.entity.Usuario" %>
<%@ page import="edu.ug.cisc.amazoom.entity.Categoria"%>
<%
Usuario u = (Usuario)session.getAttribute("usuario");
            if (u == null) {
				response.sendRedirect("login.jsp?mensaje=No puede accedera la pagina sin hacer login");
				}
				else {
					u = (Usuario)session.getAttribute("usuario");
    
  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AmaZoom</title>
        <link rel="preload" href="css/normalize.css" as="style">
        <link rel="preload" href="css/styles.css" as="style">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Krub:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/styles.css"/>
        <link rel="stylesheet" href="CSS/normalize.css"/>
    </head>
    <body>
        <header>
            <h1 class="header__titulo">AmaZoom <span>Eliminar libro</span></h1>
        </header>
        </header>
        <nav class="narbar">
            <a class="narbar__enlace" href="verLibro.jsp">Ver Libros</a>
            <a class="narbar__enlace" href="agregarLibro.jsp">Agregar Libros</a>
            <a class="narbar__enlace" href="eliminarLibro.jsp">Borrar Libros</a>
            <a class="narbar__enlace" href="actualizarLibro.jsp">Actualizar Libros</a>
            <a class="narbar__enlace" href="Controlador?accion=home">Interfaz de Usuario</a>
        </nav>
        <div class="usuario">
            <h3>Bienvenido Administrador <%=u.getNombres() %> <%=u.getApellidos() %></h3>
        </div>
        <div class="contenido">
            <% 
                             bookDAO.connect();
                             //int id = Integer.parseInt(request.getParameter("idCategoria"));
                             ResultSet rs = bookDAO.listaLibrosJoin();
                             ArrayList listBook = new ArrayList();
                             ArrayList listCategoria = new ArrayList();
                             int i=0;
                             while (rs.next()) {
                                 Book libro = new Book();
                                 Categoria categ = new Categoria();
                                 libro.setTitulo(rs.getString("titulo"));
                                 libro.setAutor(rs.getString("autor"));
                                 libro.setPrecio(rs.getFloat("precio"));
                                 libro.setIdLibro(rs.getInt("idLibro"));
								 libro.setSintesis(rs.getString("sintesis"));
								 libro.setIdCategoria(rs.getInt("idCategoria"));
                                 categ.setCategoria(rs.getString("categoria"));
                                 listBook.add(libro);
                                 listCategoria.add(categ);
                                 }
                             %>
                           <%for(int j=0;j<listBook.size();j++){
                           
                              Book  b = (Book)listBook.get(j);
                              Categoria c = (Categoria)listCategoria.get(j);
                             %>   
            <div class="contenido__libros">
                
                <h3><%=b.getTitulo()%></h3>
                <p class="overflow"><%=b.getSintesis()%></p>
                <p>Autor: <%=b.getAutor()%></p>
                <p>Categoria: <%=c.getCategoria()%></p>
                <p>Precio: $<%=b.getPrecio()%></p>

                <form method="POST" action="deleteLibro.jsp">
                    <p>

                        <button type="submit" class="contenido__boton">Eliminar</button>
                        <input type="hidden" name="idLibro" value="<%=b.getIdLibro()%>" >
                        <input type="hidden" name="autor" value="<%=b.getAutor()%>" >
                        <input type="hidden" name="titulo" value="<%=b.getTitulo()%>" >
                        <input type="hidden" name="precio" value="<%=b.getPrecio()%>" >
                        <input type="hidden" name="sintesis" value="<%=b.getSintesis()%>" >
                        <input type="hidden" name="idCategoria" value="<%=b.getIdCategoria()%>" >
                        <input type="hidden" name="idCategoria" value="<%=c.getIdCategoria()%>" >
                        <input type="hidden" name="categoria" value="<%=c.getCategoria()%>" >
                    </p>

                </form>
            </div>
            <%}%>


        </div>

        <p><% bookDAO.disconnect(); %></p>
        <footer class="footer">
            <p>© Todos los derechos reservados Amazoom ©</p>
        </footer>
    </body>
</html>
<%
    }
%>