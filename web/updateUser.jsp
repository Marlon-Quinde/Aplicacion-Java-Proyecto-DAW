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
            <h1 class="header__titulo">AmaZoom <span>Usuario actualizado</span></h1>
        </header>
        <%
       
          
          usuario.setNombres(request.getParameter("nombre"));
          usuario.setApellidos(request.getParameter("apellido"));
          usuario.setDireccion(request.getParameter("direccion"));
          usuario.setEmail(request.getParameter("email"));
          usuario.setTelefono((int)Integer.parseInt(request.getParameter("telefono")));
          usuario.setPassword(request.getParameter("clave"));
          usuario.setIdUsuario((int)Integer.parseInt(request.getParameter("idUser")));
          
          usuarioDAO.connect();
          usuarioDAO.actualizar(usuario);
          usuarioDAO.disconnect();
      
        %>



        <div class="secundario__titulo">
            <h1>Usuario Actualizado!.</h1>
            <a class="contenido__boton" href="login.jsp">Pagina Principal. Inicia sesion de Nuevo</a> 
        </div>
    </body>
</html>



