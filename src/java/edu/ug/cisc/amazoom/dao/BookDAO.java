/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ug.cisc.amazoom.dao;

import edu.ug.cisc.amazoom.entity.Book;
import jakarta.servlet.annotation.MultipartConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
@MultipartConfig
public class BookDAO {

    String error;
    Connection con;

    public BookDAO() {
    }

    public void connect() throws ClassNotFoundException,
            SQLException,
            Exception {

        String url = "jdbc:postgresql://localhost/Prueba";

        //Credenciales de la base de datos
        String usuario = "postgres";
        String contrasena = "1234";

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
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        }
    }

    public ResultSet viewBooks() throws SQLException, Exception {
        //metodo que va a retornar todos los libros que tenga en la base de datos
        ResultSet rs = null;
        try {
            String queryString = ("SELECT * FROM libro;");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return rs;
    }

    public Book buscarPorId(int idLibro) throws SQLException, Exception {
        //metodo que va a retornar todos los libros que tenga en la base de datos
        ResultSet rs = null;
        Book b = null;
        try {
            String queryString = ("SELECT * FROM libro where idlibro=?;");
            PreparedStatement consulta = con.prepareStatement(queryString);
            consulta.setInt(1, idLibro);
            rs = consulta.executeQuery(queryString);

            if (rs.next()) {
                b = new Book();
                b.setAutor(rs.getString("autor"));
                b.setTitulo(rs.getString("titulo"));
                b.setPrecio(rs.getFloat("precio"));
                b.setIdCategoria(rs.getInt("categoria"));
                b.setIdLibro(rs.getInt(idLibro));
            }
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return b;
    }

    public ArrayList listaLibros() throws SQLException, Exception {
        //metodo que va a retornar todos los libros que tenga en la base de datos
        ResultSet rs = null;

        ArrayList libros = new ArrayList();
        try {
            String queryString = ("SELECT * FROM libro;");
            Statement consulta = con.createStatement();

            rs = consulta.executeQuery(queryString);

            if (rs.next()) {
                Book b = new Book();
                b.setAutor(rs.getString("autor"));
                b.setTitulo(rs.getString("titulo"));
                b.setPrecio(rs.getFloat("precio"));
                b.setIdCategoria(rs.getInt("categoria"));
                b.setIdLibro(rs.getInt("idlibro"));
                libros.add(b);
            }
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return libros;
    }

    public ResultSet listarCategorias() throws SQLException, Exception {
        //metodo que va a retornar todos los libros que tenga en la base de datos
        ResultSet rs = null;
        try {
            String queryString = ("SELECT * FROM categoria;");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return rs;
    }

    public void addBook(Book b) throws SQLException, Exception {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("insert into libro(Titulo,Autor,Precio,IdCategoria,Sintesis) values(?, ?, ?, ?, ?);");
                updatebooks.setString(1, b.getTitulo());
                updatebooks.setString(2, b.getAutor());
                updatebooks.setFloat(3, b.getPrecio());
                updatebooks.setInt(4, b.getIdCategoria());
                updatebooks.setString(5, b.getSintesis());
                updatebooks.execute();
            } catch (SQLException sqle) {
                throw new SQLException(sqle.toString());
            }
        } else {
            error = "Exception: Connection to database was lost.";
            throw new Exception(error);
        }
    }

    public void actualizar(Book b) throws SQLException, Exception {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("update libro set Titulo=?,Autor=?,Precio=?,sintesis=?,IdCategoria=? where idlibro=?;");
                updatebooks.setString(1, b.getTitulo());
                updatebooks.setString(2, b.getAutor());
                updatebooks.setFloat(3, b.getPrecio());
                updatebooks.setString(4, b.getSintesis());
                updatebooks.setInt(5, b.getIdCategoria());
                updatebooks.setInt(6, b.getIdLibro());
                updatebooks.execute();
            } catch (SQLException sqle) {
                throw new SQLException(sqle.toString());
            }
        } else {
            error = "Exception: Connection to database was lost.";
            throw new Exception(error);
        }
    }

    public ResultSet listaLibrosJoin() throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String queryString = ("select * from libro l join categoria c on l.idcategoria = c.idcategoria;");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(queryString);
        } catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return rs;
    }

    public void eliminar(Book b) throws SQLException, Exception {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("delete from libro where idlibro=?;");
                updatebooks.setInt(1, b.getIdLibro());
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

/*
if (con != null) {
	try {
              PreparedStatement updatebooks;
              updatebooks = con.prepareStatement("delete from libro where idlibro = ? ;");
              updatebooks.setInt(1, idLibro);
	      
	      updatebooks.execute();
	} catch (SQLException sqle) {
            throw new SQLException(sqle.toString());
	}
      } else {
            error = "Exception: Connection to database was lost.";
            throw new Exception(error);
	}
*/
