<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="CSS/estiloIndex.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>

    <body class="body">
        <form class="formulario" id="form1" name="form1" method="post" action="usuarioController.jsp">
            <fieldset>
                <legend>Inicia Session en AmaZoom</legend>
                <div class="items">
                    <div class="user-pass">
                        <label>
                            Usuario
                        </label>
                        <input class="user" type="text" name="usuario" id="usuario" placeholder="USER"/>    
                    </div>
                    <div class="user-pass">
                        <label>
                            Contraseña
                        </label>
                        <input class="pass" type="password" name="password" id="password" placeholder="PASSWORD" />   
                    </div>
                    <div>
                        <input class="boton" type="submit" name="button" id="button" value="Ingresar" />
                    </div>
                    <div>
                        <a class="boton" href="registrarUsuario.jsp" id="button">Registrarse </a>
                    </div>
                </div>
                
            </fieldset>
            <!-- comment 
          <table width="50%" border="1" align="center">
            <tr>
              <td colspan="2" align="center">Login</td>
            </tr>
            <tr>
              <td width="36%">Usuario</td>
              <td width="64%"><label for="textfield"></label>
              <input type="text" name="usuario" id="usuario" /></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><input type="password" name="password" id="password" /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="submit" name="button" id="button" value="Ingresar" /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </table>
            -->
        </form>

        <div class="text">
            <%        
       String mensaje = request.getParameter("mensaje");
            %>
            <%= mensaje%>
        </div>

    </body>
</html>
