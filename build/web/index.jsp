<%-- 
    Document   : index
    Created on : 17 sep. 2022, 16:38:43
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="edu.ug.cisc.amazoom.entity.Usuario" %>
<!DOCTYPE html>
<%
Usuario u = (Usuario)session.getAttribute("usuario");
int cc=0;
String user="Iniciar Sesion";
            if (u != null) {
            u = (Usuario)session.getAttribute("usuario");
    
                                        user="Bienvenido "+u.getNombres()+" "+u.getApellidos();
    }
  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">AmaZoom</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=home">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=verLibro">Interfaz Administrador</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=Carrito" tabindex="-1" aria-disabled="true"><i class="fa-card-plus">(<label style="color: orange">${contador}</label>)</i>Carrito de Compras</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="dropdown col-2">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%if (u != null) {
                        %>
                        <form method="post" action="actualizarUsuario.jsp">
                            <input class="btn btn-danger"type="submit" value="<%=user%>">
                            <input type="hidden" name="cedula" value="<%=u.getCedula()%>">
                            <input type="hidden" name="nombre" value="<%=u.getNombres()%>">
                            <input type="hidden" name="apellido" value="<%=u.getApellidos()%>">
                            <input type="hidden" name="direccion" value="<%=u.getDireccion()%>">
                            <input type="hidden" name="email" value="<%=u.getEmail()%>">
                            <input type="hidden" name="telefono" value="<%=u.getTelefono()%>">
                            <input type="hidden" name="clave" value="<%=u.getPassword()%>">
                            <input type="hidden" name="nombreUsuario" value="<%=u.getNombreUsuario()%>">
                            <input type="hidden" name="idUser" value="<%=u.getIdUsuario()%>">
                        </form>
                        <%}else{
%>
<a href="login.jsp" class="table-dark" style="width: 100px"><%=user%></a>
                            
                            
                            <%}%>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
                        
        <div class="container mt-4">
            <div class="row">
                <c:forEach var="b" items="${libros}">
                    <%cc=cc+1;%>
                    <div class="col-sm-4 form-group">
                        <div class="card">
                            <div class="card-header text-center">
                                <h4>${b.getTitulo()}</h4>
                            </div>
                            <div class="card-body">
                                <img src="img/${b.getTitulo()}.jpg" width="140" height="180" alt="">
                            </div>
                            <div class="card-body text-center">
                                <i>Autor: ${b.getAutor()}</i></br>
                                <i>Precio: $${b.getPrecio()}</i></br>
                                <i>Sistesis: ${b.getSintesis()}</i></br>
                            </div>
                            <div class="card-footer text-center">
                                <div>
                                    <a href="Controlador?accion=AgregarCarrito&id=${b.getIdLibro()}" class="btn btn-outline-info">Agregar al carrito</a>
                                    <a href="Controlador?accion=Comprar&id=${b.getIdLibro()}" class="btn btn-danger">Comprar</a>
                                </div>
                            </div>
                        </div>

                    </div>

                </c:forEach>   
            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>