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

public class Clientes extends AppCompatActivity {
    EditText etIdCliente, etNombre, etTelefono, etSaldoPendiente;
    BasesDeDatosSQLite clientesBD;
    Toolbar cajaDeHerramientasClientes;
    RecyclerView mostrarTabla;
    ClientesAdaptador adaptadorClientes;
    List<ClientesView> listaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clientes);

        etIdCliente = findViewById(R.id.eTIUsuario);
        etNombre = findViewById(R.id.eTNombreCliente);
        etTelefono = findViewById(R.id.eTTelefono);
        etSaldoPendiente = findViewById(R.id.eTSaldoPendiente);

        mostrarTabla = findViewById(R.id.rVUsuario);
        cajaDeHerramientasClientes = findViewById(R.id.tBUsuario);
        setSupportActionBar(cajaDeHerramientasClientes);

        listaClientes = new ArrayList<>();
        adaptadorClientes = new ClientesAdaptador(listaClientes);
        mostrarTabla.setLayoutManager(new LinearLayoutManager(this));
        mostrarTabla.setAdapter(adaptadorClientes);

        clientesBD = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarClientes();
        camposVacios();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainClientes), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void cargarClientes() {
        listaClientes.clear();
        SQLiteDatabase tablaDeClientes = clientesBD.getReadableDatabase();
        Cursor movClientes = tablaDeClientes.rawQuery("SELECT ID_Cliente, Nombre, Telefono, Saldo_Pendiente FROM Cliente", null);
        if (movClientes.moveToFirst()) {
            do {
                listaClientes.add(new ClientesView(
                        movClientes.getInt(0),
                        movClientes.getString(1),
                        movClientes.getString(2),
                        movClientes.getDouble(3)
                ));
            } while (movClientes.moveToNext());
        }
        movClientes.close();
        tablaDeClientes.close();
        adaptadorClientes.notifyDataSetChanged();
    }
    private void limpiarCamposDeClientes() {
        etIdCliente.setText("");
        etNombre.setText("");
        etTelefono.setText("");
        etSaldoPendiente.setText("");
    }
    public void onAgregarCliente(View view) {
        if(etIdCliente.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty() ||
                etTelefono.getText().toString().isEmpty() ||
                etSaldoPendiente.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeClientes = clientesBD.getWritableDatabase();
        ContentValues agregarClientes = new ContentValues();
        agregarClientes.put("ID_Cliente", etIdCliente.getText().toString());
        agregarClientes.put("Nombre", etNombre.getText().toString());
        agregarClientes.put("Telefono", etTelefono.getText().toString());
        agregarClientes.put("Saldo_Pendiente", etSaldoPendiente.getText().toString());

        tablaDeClientes.insert("Cliente", null, agregarClientes);
        etIdCliente.setText("");
        etNombre.setText("");
        etTelefono.setText("");
        etSaldoPendiente.setText("");
        tablaDeClientes.close();
        cargarClientes();
        Toast.makeText(this, "CLIENTE AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
    }
    public void onModificarCliente(View view) {
        if(etIdCliente.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty() ||
                etTelefono.getText().toString().isEmpty() ||
                etSaldoPendiente.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeClientes = clientesBD.getWritableDatabase();
        String iD_Cliente = etIdCliente.getText().toString();
        ContentValues registroClientes = new ContentValues();
        registroClientes.put("Nombre", etNombre.getText().toString());
        registroClientes.put("Telefono", etTelefono.getText().toString());
        registroClientes.put("Saldo_Pendiente", etSaldoPendiente.getText().toString());

        int cant = tablaDeClientes.update("Cliente", registroClientes, "ID_Cliente=?", new String[]{iD_Cliente});
        if (cant == 1)
            Toast.makeText(this, "SE MODIFICO EL CLIENTE", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "NO EXISTE EL CLIENTE", Toast.LENGTH_SHORT).show();

        tablaDeClientes.close();
        cargarClientes();
        limpiarCamposDeClientes();
    }
    public void onBorrarCliente(View view) {
        String iD_Cliente = etIdCliente.getText().toString();
        if (iD_Cliente.isEmpty()) {
            Toast.makeText(this, "Ingresa un ID de cliente válido", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeClientes = clientesBD.getWritableDatabase();
        int cant = tablaDeClientes.delete("Cliente", "ID_Cliente=?", new String[]{iD_Cliente});
        tablaDeClientes.close();
        if (cant > 0) {
            Toast.makeText(this, "Cliente eliminado correctamente", Toast.LENGTH_SHORT).show();
            limpiarCamposDeClientes();
            cargarClientes();} else {
            Toast.makeText(this, "No existe el cliente con ese ID", Toast.LENGTH_SHORT).show();
        }
    }
    public void onConsultarCliente(View view) {
        SQLiteDatabase tablaDeClientes = clientesBD.getReadableDatabase();
        String iD_Cliente = etIdCliente.getText().toString();
        Cursor cursorConsultar = tablaDeClientes.rawQuery("SELECT Nombre, Telefono, Saldo_Pendiente FROM Cliente WHERE ID_Cliente=?", new String[]{iD_Cliente});
        if (cursorConsultar.moveToFirst()) {
            etNombre.setText(cursorConsultar.getString(0));
            etTelefono.setText(cursorConsultar.getString(1));
            etSaldoPendiente.setText(cursorConsultar.getString(2));
        } else {
            Toast.makeText(this, "NO EXISTE EL CLIENTE", Toast.LENGTH_SHORT).show();
            etIdCliente.setText("");
            etNombre.setText("");
            etTelefono.setText("");
            etSaldoPendiente.setText("");
        }
        cursorConsultar.close();
        tablaDeClientes.close();
    }

    private boolean camposVacios() {
        return etIdCliente.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty() ||
                etTelefono.getText().toString().isEmpty() ||
                etSaldoPendiente.getText().toString().isEmpty();
    }
    public void onSalirClientes(View view) {
        finish();
    }
}
