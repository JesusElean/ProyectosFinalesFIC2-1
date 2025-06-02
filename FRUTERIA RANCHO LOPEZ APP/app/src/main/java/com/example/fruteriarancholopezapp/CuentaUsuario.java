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

        SesionUsuario sesionUsuario = new SesionUsuario(this);
        String nombre = sesionUsuario.obtenerNombre();
        String email = sesionUsuario.obtenerEmail();
        String fotoUrl = sesionUsuario.obtenerId();

        // Mostrar datos en la UI
        tvNombre.setText(nombre);
        tvEmail.setText(email);

        Glide.with(this).load(fotoUrl).circleCrop().into(ivFoto);
    }
}
