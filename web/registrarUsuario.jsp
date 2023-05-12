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
            <h1 class="header__titulo">AmaZoom <span>Mantenimiento Libros</span></h1>
        </header>
        <div class="contenidoM">
            <form name="form1" method="post" action="guardarUser.jsp">
                <div class="contenido__libro--modificar">
                    <h3 class="contenido__libro--modificar-titulo">Registrarse</h3>
                    <label class="contenido__libro--label">Cedula: </label><input class="contenido__libro--input" type="text" name="cedula" value="">
                    <label class="contenido__libro--label">Nombres: </label><input class="contenido__libro--input" type="text" name="nombre" value="">
                    <label class="contenido__libro--label">Apellidos: </label><input class="contenido__libro--input" type="text" name="apellido" value="">
                    <label class="contenido__libro--label">Direccion: </label><input class="contenido__libro--input" type="text" name="direccion" value="">
                    <label class="contenido__libro--label">Email: </label><input class="contenido__libro--input" type="text" name="email" value="">
                    <label class="contenido__libro--label">Telefono: </label><input class="contenido__libro--input" type="number" name="telefono" value="">
                    <label class="contenido__libro--label">Usuario: </label><input class="contenido__libro--input" type="text" name="nombreUsuario" value="">
                    <label class="contenido__libro--label">Password: </label> <input class="contenido__libro--input" type="text" name="clave" value="">
                    
                    
                    <input class="contenido__boton boton--grid" type="submit" name="Modificar" id="Modificar" value="Agregar">
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
