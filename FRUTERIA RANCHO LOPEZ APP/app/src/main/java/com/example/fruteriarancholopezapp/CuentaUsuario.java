package com.example.fruteriarancholopezapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CuentaUsuario extends AppCompatActivity {

    private TextView tvNombre, tvEmail;
    private ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_usuario);

        tvNombre = findViewById(R.id.tvNomUserInfo);
        tvEmail = findViewById(R.id.tvEmailInfo);
        ivFoto = findViewById(R.id.ivFotoUser);

        // Obtener los datos del usuario desde SharedPreferences
        SesionUsuario sesionUsuario = new SesionUsuario(this);
        String nombre = sesionUsuario.obtenerNombre();
        String email = sesionUsuario.obtenerEmail();
        String fotoUrl = sesionUsuario.obtenerId(); // Aquí podrías almacenar la URL de la foto en `SesionUsuario`

        // Mostrar datos en la UI
        tvNombre.setText(nombre);
        tvEmail.setText(email);

        // Cargar imagen de perfil con Glide (Asegúrate de agregar la dependencia)
        Glide.with(this).load(fotoUrl).circleCrop().into(ivFoto);
    }
}
