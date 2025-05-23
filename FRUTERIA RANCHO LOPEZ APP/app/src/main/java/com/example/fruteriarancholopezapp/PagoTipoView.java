package com.example.fruteriarancholopezapp;

public class PagoTipoView
{
    private int idPago;
    private int idCliente;
    private String fechaPago;
    private double monto;
    public PagoTipoView(int idPago, int idCliente, String fechaPago, double monto) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }
    public int getIdPago() {
        return idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public double getMonto() {
        return monto;
    }
}
