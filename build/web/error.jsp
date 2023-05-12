<%@ page language="java" isErrorPage="true"%>

<HTML><HEAD><TITLE>my Shopping Cart</TITLE>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="../estilos.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY background="../fondo.gif">
<table cellSpacing=0 cellPadding=0 width=800 align=center border=0>
  <tbody>
  <tr>
      <td><table width="100%" border="0">
          <tr bgcolor="#FFFFFF"> 
            <td>
                <div align="right">
                    <table width="100%" border="0">
                      <tr>
                        <td width="18%">&nbsp;</td>
                        <td width="82%"><img src="dell2.gif" width="638" height="90"></td>
                      </tr>
                    </table>
                </div>
            </td>
          </tr>
        </table></td>
    </tr>
  <tr>
      <td> 
        <table cellSpacing=0 cellPadding=0 width="100%" border=0>
          <tbody>
            <tr> 
              <td bgcolor="#6699cc" style="FILTER: progid:DXImageTransform.Microsoft.Gradient(startColorStr='#6699cc', endColorStr='#FFFFFF', gradientType='0')" vAlign=top width=150> <div align="left"> </td>
              <td valign="top" bgcolor="#FFFFFF"> <h2>Se ha producido un error 
                  en la aplicacion.</h2>
                <h4 class="texto">Error:</h4>
                <span class="texto"><%= exception.toString() %><br/>
                    Por favor contactese con el administrador del sistema</span><br /> 
                <p> 
                <p></td>
            </tr>
          </tbody>
        </table></td></tr>
  
  <tr>
    <td bgColor="E4E8ED"><div align="center">Todos los derechos reservados </div></td></tr></tbody></table>
<p>&nbsp;</p>
</BODY></HTML>

