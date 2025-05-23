package com.example.fruteriarancholopezapp;

public class VistaUsuario {
    private int idUsuario;
    private String nombreUsuario;
    private String rol;
    private String contrasena;

    public VistaUsuario(int idUsuario, String nombreUsuario, String rol, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
    }
}
