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
            <h1 class="header__titulo">AmaZoom <span>Editar usuario</span></h1>
        </header>
        <div class="contenidoM">
            <form name="form1" method="post" action="updateUser.jsp">
                <div class="contenido__libro--modificar">
                    <h3 class="contenido__libro--modificar-titulo">Registrarse</h3>
                    <label class="contenido__libro--label">Cedula: </label><input class="contenido__libro--input" type="text" name="cedula" value="<%=request.getParameter("cedula")%>" readonly="">
                    <label class="contenido__libro--label">Nombres: </label><input class="contenido__libro--input" type="text" name="nombre" value="<%=request.getParameter("nombre")%>">
                    <label class="contenido__libro--label">Apellidos: </label><input class="contenido__libro--input" type="text" name="apellido" value="<%=request.getParameter("apellido")%>">
                    <label class="contenido__libro--label">Direccion: </label><input class="contenido__libro--input" type="text" name="direccion" value="<%=request.getParameter("direccion")%>">
                    <label class="contenido__libro--label">Email: </label><input class="contenido__libro--input" type="text" name="email" value="<%=request.getParameter("email")%>">
                    <label class="contenido__libro--label">Telefono: </label><input class="contenido__libro--input" type="number" name="telefono" value="<%=request.getParameter("telefono")%>">
                    <label class="contenido__libro--label">Usuario: </label><input class="contenido__libro--input" type="text" name="nombreUsuario" value="<%=request.getParameter("nombreUsuario")%>" readonly="">
                    <label class="contenido__libro--label">Password: </label> <input class="contenido__libro--input" type="text" name="clave" value="<%=request.getParameter("clave")%>">
                    
                    
                    <input class="contenido__boton boton--grid" type="submit" name="Modificar" id="Modificar" value="Editar Usuario">
                    <input type="hidden" name="Action" value="Modificar">
                    <input type="hidden" name="idUser" value="<%=request.getParameter("idUser")%>">
                    <a href="Controlador?accion=home" class="contenido__boton boton--grid" style="text-align: center">Volver a la pagina anterior</a>

                </div>
            </form>

        </div>
        <footer class="footer">
            <p>© Todos los derechos reservados Amazoom ©</p>
        </footer>     
    </body>
</html>
