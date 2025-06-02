package com.example.fruteriarancholopezapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarCuenta extends AppCompatActivity {

    private EditText etNombre, etPassword, etPhone, etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);


        etNombre = findViewById(R.id.editTextText);
        etPassword = findViewById(R.id.editTextTextPassword);
        etPhone = findViewById(R.id.editTextPhone);
        etDate = findViewById(R.id.editTextDate);
    }

    public void onGuardarRegistro(View view) {
        String nombre = etNombre.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String date = etDate.getText().toString().trim();

        if (nombre.isEmpty() || password.isEmpty() || phone.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }


        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nombre", nombre);
        editor.putString("password", password);

        editor.putString("phone", phone);
        editor.putString("date", date);
        editor.apply();

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSalir2(View view) {
        finish();
    }
}
