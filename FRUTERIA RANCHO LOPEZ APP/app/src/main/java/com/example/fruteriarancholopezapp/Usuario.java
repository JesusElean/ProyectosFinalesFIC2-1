package com.example.fruteriarancholopezapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends AppCompatActivity {
    EditText eTIdUsuario, eTNombreUse, eTRol, eTContrasena;
    BasesDeDatosSQLite usuariosBD;
    Toolbar cajaDeHerramientasUser;
    RecyclerView mostrarTabla;
    AdaptadorUsuario adaptadorUsuarios;
    List<VistaUsuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuario);

        eTIdUsuario = findViewById(R.id.eTIdUsuario);
        eTNombreUse = findViewById(R.id.eTNombreUsuario);
        eTRol = findViewById(R.id.eTRol);
        eTContrasena = findViewById(R.id.eTContraseña);

        mostrarTabla = findViewById(R.id.rVUsuario);
        cajaDeHerramientasUser= findViewById(R.id.tBUsuario);
        setSupportActionBar(cajaDeHerramientasUser);


        listaUsuarios = new ArrayList<>();
        adaptadorUsuarios = new AdaptadorUsuario(listaUsuarios);
        mostrarTabla.setLayoutManager(new LinearLayoutManager(this));
        mostrarTabla.setAdapter(adaptadorUsuarios);

        usuariosBD = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarUsuarios();
        limpiarCamposDeUsuarios();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainUsuario), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarUsuarios() {
        listaUsuarios.clear();
        SQLiteDatabase tablaDeUsuarios = usuariosBD.getReadableDatabase();
        Cursor movUsuarios = tablaDeUsuarios.rawQuery("SELECT ID_Usuario, Nombre, Rol, Contrasena FROM Usuario", null);
        if (movUsuarios.moveToFirst()) {
            do {
                listaUsuarios.add(new VistaUsuario(
                        movUsuarios.getInt(0),
                        movUsuarios.getString(1),
                        movUsuarios.getString(2),
                        movUsuarios.getString(3)
                ));
            } while (movUsuarios.moveToNext());
        }
        movUsuarios.close();
        tablaDeUsuarios.close();
        adaptadorUsuarios.notifyDataSetChanged();
    }

    private void limpiarCamposDeUsuarios() {
        eTIdUsuario.setText("");
        eTNombreUse.setText("");
        eTRol.setText("");
        eTContrasena.setText("");
    }

    private boolean camposVacios() {
        return eTIdUsuario.getText().toString().isEmpty() ||
                eTNombreUse.getText().toString().isEmpty() ||
                eTRol.getText().toString().isEmpty() ||
                eTContrasena.getText().toString().isEmpty();
    }

    public void onAgregarUsuario(View view) {
        if (camposVacios()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeUsuarios = usuariosBD.getWritableDatabase();
        ContentValues agregarUsuarios = new ContentValues();
        agregarUsuarios.put("ID_Usuario", eTIdUsuario.getText().toString());
        agregarUsuarios.put("Nombre", eTNombreUse.getText().toString());
        agregarUsuarios.put("Rol", eTRol.getText().toString());
        agregarUsuarios.put("Contrasena", eTContrasena.getText().toString());

        tablaDeUsuarios.insert("Usuario", null, agregarUsuarios);
        tablaDeUsuarios.close();
        limpiarCamposDeUsuarios();
        cargarUsuarios();
        Toast.makeText(this, "USUARIO AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
    }

    public void onModificarUsuario(View view) {
        if (camposVacios()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeUsuarios = usuariosBD.getWritableDatabase();
        String iD_Usuario = eTIdUsuario.getText().toString();
        ContentValues registroUsuarios = new ContentValues();
        registroUsuarios.put("Nombre", eTNombreUse.getText().toString());
        registroUsuarios.put("Rol", eTRol.getText().toString());
        registroUsuarios.put("Contrasena", eTContrasena.getText().toString());

        int cant = tablaDeUsuarios.update("Usuario", registroUsuarios, "ID_Usuario=?", new String[]{iD_Usuario});
        tablaDeUsuarios.close();

        if (cant == 1)
            Toast.makeText(this, "SE MODIFICÓ EL USUARIO", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "NO EXISTE EL USUARIO", Toast.LENGTH_SHORT).show();

        limpiarCamposDeUsuarios();
        cargarUsuarios();
    }

    public void onBorrarUsuario(View view) {
        String iD_Usuario = eTIdUsuario.getText().toString();
        if (iD_Usuario.isEmpty()) {
            Toast.makeText(this, "Ingresa un ID de usuario válido", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeUsuarios = usuariosBD.getWritableDatabase();
        int cant = tablaDeUsuarios.delete("Usuario", "ID_Usuario=?", new String[]{iD_Usuario});
        tablaDeUsuarios.close();

        if (cant > 0) {
            Toast.makeText(this, "Usuario eliminado correctamente", Toast.LENGTH_SHORT).show();
            limpiarCamposDeUsuarios();
            cargarUsuarios();
        } else {
            Toast.makeText(this, "No existe el usuario con ese ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void onConsultarUsuario(View view) {
        SQLiteDatabase tablaDeUsuarios = usuariosBD.getReadableDatabase();
        String iD_Usuario = eTIdUsuario.getText().toString();
        Cursor cursorConsultar = tablaDeUsuarios.rawQuery(
                "SELECT ID_Usuario, Nombre, Rol, Contrasena FROM Usuario WHERE ID_Usuario=?",
                new String[]{iD_Usuario}
        );
        if (cursorConsultar.moveToFirst()) {
            eTIdUsuario.setText(cursorConsultar.getString(0));
            eTNombreUse.setText(cursorConsultar.getString(1));
            eTRol.setText(cursorConsultar.getString(2));
            eTContrasena.setText(cursorConsultar.getString(3));
        } else {
            Toast.makeText(this, "NO EXISTE EL USUARIO", Toast.LENGTH_SHORT).show();
            limpiarCamposDeUsuarios();
        }
        cursorConsultar.close();
        tablaDeUsuarios.close();
    }

    public void onSalirUsuario(View view) {
        finish();
    }
}
