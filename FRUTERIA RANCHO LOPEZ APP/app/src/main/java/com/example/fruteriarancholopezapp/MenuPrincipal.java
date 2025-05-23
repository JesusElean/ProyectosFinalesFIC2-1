package com.example.fruteriarancholopezapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);

        SesionUsuario sesionUsuario = new SesionUsuario(this);
        String nombreUsuario = sesionUsuario.obtenerNombre();

        if (nombreUsuario != null) {
            Toast.makeText(this, "Bienvenido, " + nombreUsuario + "!", Toast.LENGTH_SHORT).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProductos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onProductos(View view) {
        Intent productos = new Intent(this, Productos.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(productos, options.toBundle());

    }

    public void onVentas(View view) {
        Intent ventas = new Intent(this, Ventas .class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(ventas, options.toBundle());
    }

    public void onDetallesVentas(View view) {
        Intent detallesVentas = new Intent(this, DetallesVentas.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(detallesVentas, options.toBundle());
    }

    public void onCliente(View view) {
        Intent clientes = new Intent(this, Clientes.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(clientes, options.toBundle());
    }

    public void onPagoCredito(View view) {
        Intent tipoDePago = new Intent(this, tipoDePago.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(tipoDePago, options.toBundle());}

    public void onUsuario(View view) {
        Intent usuario = new Intent(this, Usuario.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(usuario, options.toBundle());
    }

    public void onescaner(View view) {
        Intent scanner = new Intent(this, EscanerBarra.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(scanner, options.toBundle());
    }

    public void onInfoCuenta(View view) {
        Intent intent = new Intent(this, CuentaUsuario.class);
        startActivity(intent);
    }
    public void onCerrarSesion(View view) {
        SesionUsuario sesionUsuario = new SesionUsuario(this);
        sesionUsuario.cerrarSesion();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}