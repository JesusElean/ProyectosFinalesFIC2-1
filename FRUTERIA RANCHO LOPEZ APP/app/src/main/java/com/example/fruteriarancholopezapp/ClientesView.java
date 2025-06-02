package com.example.fruteriarancholopezapp;

public class ClientesView {
    private int idCliente;
    private String nombreCliente;
    private String telefono;
    private double saldoPendiente;

    public ClientesView(int idCliente, String nombreCliente, String telefono, double saldoPendiente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.saldoPendiente = saldoPendiente;
    }
    public ClientesView(int idCliente, String nombreCliente) {
        this(idCliente, nombreCliente, "", 0.0);
    }
    public int getidCliente(){
        return idCliente;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public String getTelefono(){
        return telefono;
    }

    public double getSaldoPendiente(){
        return saldoPendiente;
    }

    @Override
    public String toString() {
        return nombreCliente;
    }
}

