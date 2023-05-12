/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amazoom.modelo;

import java.util.List;

/**
 *
 * @author User
 */
public class Compra {
    private int id;
    private Usuario usuario;
    private int idpago;
    private double monto;
    private String estado;
    
    private List<Carrito>detalleCompras;

    public Compra() {
    }

    public Compra(Usuario usuario, int idpago, double monto, String estado, List<Carrito> detalleCompras) {
        this.usuario = usuario;
        this.idpago = idpago;
        this.monto = monto;
        this.estado = estado;
        this.detalleCompras = detalleCompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

 

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carrito> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<Carrito> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }
    
    
}
