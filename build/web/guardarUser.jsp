<%@ page language="java" import="java.sql.*, java.io.*, java.util.*"  errorPage="error.jsp" %>

<jsp:useBean id="usuario" class="edu.ug.cisc.amazoom.entity.Usuario" />
<jsp:useBean id="usuarioDAO" class="edu.ug.cisc.amazoom.dao.UsuarioDAO" />

<html>
    <head>
        <title>Registrado</title>
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
            <h1 class="header__titulo">AmaZoom <span>Dise�o de Aplicaciones Web</span></h1>
        </header>
        <%
       
          usuario.setCedula((int)Integer.parseInt(request.getParameter("cedula")));
          usuario.setNombres(request.getParameter("nombre"));
          usuario.setApellidos(request.getParameter("apellido"));
          usuario.setDireccion(request.getParameter("direccion"));
          usuario.setEmail(request.getParameter("email"));
          usuario.setTelefono((int)Integer.parseInt(request.getParameter("telefono")));
          usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
          usuario.setPassword(request.getParameter("clave"));
      
          usuarioDAO.connect();
          usuarioDAO.addUser(usuario);
          usuarioDAO.disconnect();
      
        %>



        <div class="secundario__titulo">
            <h1>Usuario Registrado!.</h1>
            <a class="contenido__boton" href="login.jsp">Regresar</a> 
        </div>
    </body>
</html>



