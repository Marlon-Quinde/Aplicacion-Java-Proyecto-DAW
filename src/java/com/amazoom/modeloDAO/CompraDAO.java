/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amazoom.modeloDAO;

import com.amazoom.config.Conexion;
import com.amazoom.modelo.Carrito;
import com.amazoom.modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class CompraDAO {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r=0;
    public int GenerarCompra(Compra compra) {
        int idcompras;
        String sql="insert into compras(idUsuario, idPago, Monto, Estado)values(?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, compra.getUsuario().getId());
            ps.setInt(2, compra.getIdpago());
            ps.setDouble(3, compra.getMonto());
            ps.setString(4, compra.getEstado());
            
            r=ps.executeUpdate();
            sql="Select @@IDENTITY AS idCompras";
            rs=ps.executeQuery(sql);
            rs.next();
            
            idcompras=rs.getInt("idCompras");
            rs.close();
            
            for (Carrito detalle : compra.getDetalleCompras()) {
                sql="insert into detalle_compras(idLibro,idCompras,Cantidad,PrecioCompra)values(?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdLibro());
                ps.setInt(2, idcompras);
                
                ps.setInt(3, detalle.getCantidad());
                ps.setFloat(4, detalle.getPrecioCompra());
                r=ps.executeUpdate();
            }
        } catch (Exception e) {
        }
        return r;
    }
}
