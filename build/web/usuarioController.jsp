<%-- 
    Document   : usuarioController
    Created on : 31 ago. 2022, 16:58:29
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>

<%@ page import="edu.ug.cisc.amazoom.entity.Usuario" %>
<%@ page import="edu.ug.cisc.amazoom.dao.UsuarioDAO" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>


<%!String URL="";%>
<%
    String usuario=request.getParameter("usuario");
    String pass=request.getParameter("password");
    

UsuarioDAO usuarioDAO = new UsuarioDAO();
usuarioDAO.connect();
ResultSet rs = usuarioDAO.buscarUsuarios(usuario, pass);

if(rs.next()){
Usuario u = new Usuario();

u.setNombres(rs.getString("nombre"));
u.setApellidos(rs.getString("apellido"));
u.setDireccion(rs.getString("direccion"));
u.setCedula(rs.getInt("cedula"));
u.setTelefono(rs.getInt("telefono"));
u.setEmail(rs.getString("email"));
u.setNombreUsuario(rs.getString("nombreUsuario"));
u.setPassword(rs.getString("clave"));
u.setIdUsuario(rs.getInt("idUsuario"));

session.setAttribute("usuario", u);
URL = "index.jsp";

    }else{
    response.sendRedirect("login.jsp?mensaje=Usuario o Password Incorrecto");
    URL = "login.jsp";
    }
%>   

<jsp:forward page="<%=URL%>"/>