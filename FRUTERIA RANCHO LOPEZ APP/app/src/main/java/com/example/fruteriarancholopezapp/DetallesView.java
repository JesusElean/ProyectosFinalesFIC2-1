package com.example.fruteriarancholopezapp;

public class DetallesView {
    private int idDetalleVentas;
    private int idVenta;
    private int ID_Producto;
    private int cantidad;
    private double subtotal;

    public DetallesView(int idDetalleVentas, int idVenta, int ID_Producto, int cantidad, double subtotal) {
        this.idDetalleVentas = idDetalleVentas;
        this.idVenta = idVenta;
        this.ID_Producto = ID_Producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalleVentas() {
        return idDetalleVentas;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }
}

