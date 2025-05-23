package com.example.fruteriarancholopezapp;

public class ClientesView {
    private int idCliente;
    private String nombre;
    private String telefono;
    private double saldoPendiente;

    public ClientesView(int idCliente, String nombre, String telefono, double saldoPendiente) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.saldoPendiente = saldoPendiente;
    }

    public int getidCliente(){
        return idCliente;
    }

    public String getNombreCliente(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public double getSaldoPendiente(){
        return saldoPendiente;
    }
}

