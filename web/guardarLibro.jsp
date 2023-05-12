<%@ page language="java" import="java.sql.*, java.io.*, java.util.*"  errorPage="error.jsp" %>

<jsp:useBean id="book" class="edu.ug.cisc.amazoom.entity.Book" />
<jsp:useBean id="bookDAO" class="edu.ug.cisc.amazoom.dao.BookDAO" />

<html>
    <head>
        <title>Agregar nuevo Libro</title>
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
        <%
       
          book.setTitulo(request.getParameter("titulo"));
          book.setAutor(request.getParameter("autor"));
          book.setPrecio((float)Float.parseFloat(request.getParameter("precio")));
            book.setSintesis(request.getParameter("sintesis"));
          book.setIdCategoria((int)Integer.parseInt(request.getParameter("idcategoria")));
      
          bookDAO.connect();
          bookDAO.addBook(book);
          bookDAO.disconnect();
      
        %>



        <div class="secundario__titulo">
            <h1>Un nuevo libro ha sido agregado!.</h1>
            <a class="contenido__boton" href="agregarLibro.jsp">Regresar</a> 
        </div>
    </body>
</html>



