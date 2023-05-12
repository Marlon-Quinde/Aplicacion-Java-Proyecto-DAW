/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amazoom.modeloDAO;

import com.amazoom.config.Conexion;
import com.amazoom.modelo.Book;
import edu.ug.cisc.amazoom.entity.Categoria;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
@MultipartConfig
public class BookDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Book> book = new ArrayList();
        List<Categoria> listCategoria = new ArrayList();
        String sql = "SELECT * FROM libro l join categoria c on l.idcategoria = c.idcategoria";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                Categoria c = new Categoria();
                b.setIdLibro(rs.getInt(1));
                b.setTitulo(rs.getString(2));
                b.setAutor(rs.getString(3));
                b.setPrecio(rs.getFloat(4));
                b.setIdCategoria(rs.getInt(5));
                b.setSintesis(rs.getString(6));
                b.setFoto(rs.getBinaryStream(7));
                c.setCategoria(rs.getString(1));
                book.add(b);
                listCategoria.add(c);

            }
        } catch (Exception e) {
        }
        return book;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM libro where idLibro=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }

    public Book listarId(int id) {
        String sql = "SELECT * FROM libro where idLibro=" + id;

        Book b = new Book();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                b.setIdLibro(rs.getInt(1));
                b.setTitulo(rs.getString(2));
                b.setAutor(rs.getString(3));
                b.setPrecio(rs.getFloat(4));
                b.setIdCategoria(rs.getInt(5));
                b.setSintesis(rs.getString(6));
                b.setFoto(rs.getBinaryStream(7));
                //book.add(b);
            }
        } catch (Exception e) {
        }
        return b;
    }

    public void actualizar(Book b) {
        if (con != null) {
            try {
                PreparedStatement updatebooks;
                updatebooks = con.prepareStatement("update libro set Titulo=?,Autor=?,Precio=?,sintesis=?,IdCategoria=?, foto=? where idlibro=?;");
                updatebooks.setString(1, b.getTitulo());
                updatebooks.setString(2, b.getAutor());
                updatebooks.setFloat(3, b.getPrecio());
                updatebooks.setString(4, b.getSintesis());
                updatebooks.setInt(5, b.getIdCategoria());
                updatebooks.setInt(6, b.getIdLibro());
                updatebooks.execute();
            } catch (Exception e) {

            }
        }
    }

    public void modificar(Book b) {
        String sql = "update libro set Titulo=?,Autor=?,Precio=?,sintesis=?,IdCategoria=? where idlibro=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getTitulo());
            ps.setString(2, b.getAutor());
            ps.setFloat(3, b.getPrecio());
            ps.setString(4, b.getSintesis());
            ps.setInt(5, b.getIdCategoria());
            ps.setInt(6, b.getIdLibro());
            ps.setBlob(7, b.getFoto());
            ps.executeQuery(sql);
        } catch (Exception e) {
        }
    }
}
