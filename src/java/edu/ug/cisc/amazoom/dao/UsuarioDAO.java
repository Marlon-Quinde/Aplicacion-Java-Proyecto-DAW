/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ug.cisc.amazoom.dao;

import edu.ug.cisc.amazoom.entity.Usuario;
import jakarta.servlet.annotation.MultipartConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
@MultipartConfig
public class UsuarioDAO {
    String error;
    Connection con;
    public void connect() throws ClassNotFoundException,
	                               SQLException, 
	                               Exception {
	    
            String url="jdbc:postgresql://localhost/Prueba";

          //Credenciales de la base de datos
          String usuario="postgres";
          String contrasena="1234";
		  
            try {
	    	
              Class.forName("org.postgresql.Driver");
	      con = DriverManager.getConnection(url, usuario, contrasena);
	    } catch (ClassNotFoundException cnfe) {
	      throw new ClassNotFoundException(cnfe.toString());
	    } catch (SQLException sqle) {
	      throw new SQLException(sqle.toString());
	    } catch (Exception e) {
	      throw new Exception(e.toString());
	    }
	  } 

  public void disconnect() throws SQLException {
    try {
      if ( con != null ) {
        con.close();
      }
    } catch (SQLException sqle) {
      throw new SQLException(sqle.toString());
    }
  }
  
  public ResultSet buscarUsuarios(String usuario, String pass) throws SQLException, Exception {
    //metodo que va a retornar todos los usuarios que tenga en la base de datos
    ResultSet rs = null;
    try  {
      String queryString = ("SELECT * FROM usuario where nombreUsuario = ? and clave = ? ;");
      
      PreparedStatement consulta;
      consulta=con.prepareStatement(queryString);
      consulta.setString(1,usuario);
      consulta.setString(2, pass);
      
      rs = consulta.executeQuery(); 
      
    } catch (SQLException sqle) {
      throw new SQLException(sqle.toString());
    } catch (Exception e) {
      throw new Exception(e.toString());			 
    }
    return rs;
  }
  
  public void addUser(Usuario u) throws SQLException, Exception {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("insert into usuario(cedula,nombre,apellido,direccion,email, telefono, nombreusuario, clave) values(?, ?, ?, ?, ?, ?, ?, ?);");
                updatebooks.setInt(1, u.getCedula());
                updatebooks.setString(2, u.getNombres());
                updatebooks.setString(3, u.getApellidos());
                updatebooks.setString(4, u.getDireccion());
                updatebooks.setString(5, u.getEmail());
                updatebooks.setInt(6, u.getTelefono());
                updatebooks.setString(7, u.getNombreUsuario());
                updatebooks.setString(8, u.getPassword());
                updatebooks.execute();
            } catch (SQLException sqle) {
                throw new SQLException(sqle.toString());
            }
        } else {
            error = "Exception: Connection to database was lost.";
            throw new Exception(error);
        }
    }

public void actualizar(Usuario u) throws SQLException, Exception {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("update usuario set nombre=?,apellido=?,direccion=?,email=?,telefono=?,clave=? where idusuario=?;");
                updatebooks.setString(1, u.getNombres());
                updatebooks.setString(2, u.getApellidos());
                updatebooks.setString(3, u.getDireccion());
                updatebooks.setString(4, u.getEmail());
                updatebooks.setInt(5, u.getTelefono());
                updatebooks.setString(6, u.getPassword());
                updatebooks.setInt(7, u.getIdUsuario());
                updatebooks.execute();
            } catch (SQLException sqle) {
                throw new SQLException(sqle.toString());
            }
        } else {
            error = "Exception: Connection to database was lost.";
            throw new Exception(error);
        }
    }
          
}
