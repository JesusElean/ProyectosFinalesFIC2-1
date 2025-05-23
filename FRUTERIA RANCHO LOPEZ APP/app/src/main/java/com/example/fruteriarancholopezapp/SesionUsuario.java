package com.example.fruteriarancholopezapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SesionUsuario {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SesionUsuario(Context context) {
        sharedPreferences = context.getSharedPreferences("SesionUsuario", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void guardarUsuario(String nombre, String email, String id) {
        editor.putString("usuarioNombre", nombre);
        editor.putString("usuarioEmail", email);
        editor.putString("usuarioId", id);
        editor.apply();
    }

    public String obtenerNombre() {
        return sharedPreferences.getString("usuarioNombre", null);
    }

    public String obtenerEmail() {
        return sharedPreferences.getString("usuarioEmail", null);
    }

    public String obtenerId() {
        return sharedPreferences.getString("usuarioId", null);
    }

    public void cerrarSesion() {
        editor.clear();
        editor.apply();
    }
}
