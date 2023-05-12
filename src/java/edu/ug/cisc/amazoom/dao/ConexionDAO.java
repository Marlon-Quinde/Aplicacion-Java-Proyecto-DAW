/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ug.cisc.amazoom.dao;

import edu.ug.cisc.amazoom.entity.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victo
 */
public class ConexionDAO {
    
  String error;
  Connection con;
    
    public ConexionDAO()   { }

	  public void connect() throws ClassNotFoundException,
	                               SQLException, 
	                               Exception {
	    
            String url="jdbc:postgresql://localhost/prueba";

          //Credenciales de la base de datos
          String usuario="postgres";
          String contrasena="Ebenezer001$";
		  
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
    
}
