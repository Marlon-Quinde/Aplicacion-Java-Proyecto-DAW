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

<!DOCTYPE html>
<%
                bookDAO.connect();
                ResultSet rs = bookDAO.listarCategorias();
                ArrayList listCat = new ArrayList();
                int i=0;
                while (rs.next()){
                    Categoria c = new Categoria();
                    c.setIdCategoria(rs.getInt("idCategoria"));
                    c.setCategoria(rs.getString("Categoria"));
                    listCat.add(c);
                    }
        
%>
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
            <h1 class="header__titulo">AmaZoom <span>Diseño de Aplicaciones Web</span></h1>
        </header>
        <nav class="narbar">
            <a class="narbar__enlace" href="verLibro.jsp">Ver Libros</a>
            <a class="narbar__enlace" href="agregarLibro.jsp">Agregar Libros</a>
            <a class="narbar__enlace" href="eliminarLibro.jsp">Borrar Libros</a>
            <a class="narbar__enlace" href="actualizarLibro.jsp">Actualizar Libros</a>
        </nav>
        <div class="contenidoM">
            <form name="form1" method="post" action="updateLibro.jsp">
                <div class="contenido__libro--modificar">
                    <h3 class="contenido__libro--modificar-titulo">Actualizar Libro</h3>
                    <label class="contenido__libro--label">Titulo: </label><input class="contenido__libro--input" type="text" name="titulo" value="<%=request.getParameter("titulo")%>">
                    <label class="contenido__libro--label">Autor: </label><input class="contenido__libro--input" type="text" name="autor" value="<%=request.getParameter("autor")%>">
                    <label class="contenido__libro--label">Precio: </label><input class="contenido__libro--input" type="text" name="precio" value="<%=request.getParameter("precio")%>">
                    <label class="contenido__libro--label">Sintesis: </label> <input class="contenido__libro--input" type="text" name="sintesis" value="<%=request.getParameter("sintesis")%>">
                    <label class="contenido__libro--label">Categoria:</label>
                    <select class="contenido__libro--centro" name="idcategoria" id="idcategoria">

                        <%=request.getParameter("idLibro")%>
                        <%for(int j=0;j<listCat.size();j++){
                    Categoria c = (Categoria)listCat.get(j);
                        %>
                        <option value="<%= c.getIdCategoria() %>"> <%=c.getCategoria()%> </option>
                        <%}%> 
                    </select>
                    
                        
                        <label class="contenido__libro--label">Foto </label> <input class="contenido__libro--input" type="file" name="filefoto">
                    <input class="contenido__boton boton--grid" type="submit" name="accion" value="Modificar">
                    <input type="hidden" name="Action" value="Modificar">
                    <input type="hidden" name="idLibro" value="<%=request.getParameter("idLibro")%>">

                </div>
            </form>

        </div>
        <footer class="footer">
            <p>© Todos los derechos reservados Amazoom ©</p>
        </footer>
    </body>
</html>
