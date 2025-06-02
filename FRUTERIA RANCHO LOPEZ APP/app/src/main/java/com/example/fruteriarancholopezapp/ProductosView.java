package com.example.fruteriarancholopezapp;

public class ProductosView {
    private int ID_Producto;
    private String nombre;
    private double precio;
    private int stock;
    private String unidad;

    public ProductosView(int ID_Producto, String nombre, double precio, int stock, String unidad) {
        this.ID_Producto = ID_Producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.unidad = unidad;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
