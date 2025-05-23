package com.example.fruteriarancholopezapp;

public class VentasView {
    private int idVenta;
    private String fechaVenta;
    private double totalVenta;
    private int idCliente;
    private String tipoPago;

    public VentasView(int idVenta, String fechaVenta, double totalVenta, int idCliente, String tipoPago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.idCliente = idCliente;
        this.tipoPago = tipoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }
}
