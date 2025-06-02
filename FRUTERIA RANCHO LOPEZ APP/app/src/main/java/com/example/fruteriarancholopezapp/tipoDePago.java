package com.example.fruteriarancholopezapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class tipoDePago extends AppCompatActivity {
    private EditText eTIdPago, eTFecha, eTMonto;
    private Spinner spinnerClientes;
    BasesDeDatosSQLite bdTipoPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tipo_de_pago);

        eTIdPago = findViewById(R.id.eTIdPago);
        eTFecha  = findViewById(R.id.eTFecha);
        eTMonto  = findViewById(R.id.eTMonto);
        spinnerClientes = findViewById(R.id.spinnerClientes);

        bdTipoPago = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);

        cargarClientesSpinner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void cargarClientesSpinner() {
        List<ClientesView> listaClientes = new ArrayList<>();
        SQLiteDatabase bd = bdTipoPago.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT ID_Cliente, Nombre FROM Cliente", null);
        if (cursor.moveToFirst()) {
            do {
                int idCliente = cursor.getInt(0);
                String nombreCliente = cursor.getString(1);
                listaClientes.add(new ClientesView(idCliente, nombreCliente));
            } while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();

        ArrayAdapter<ClientesView> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaClientes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(adapter);
    }
    public void onGuardar(View view) {
        if (eTFecha.getText().toString().trim().isEmpty() ||
                eTMonto.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Complete los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }
        ClientesView clienteSeleccionado = (ClientesView) spinnerClientes.getSelectedItem();
        if (clienteSeleccionado == null) {
            Toast.makeText(this, "No se ha seleccionado un cliente", Toast.LENGTH_SHORT).show();
            return;
        }
        int idCliente = clienteSeleccionado.getidCliente();

        String fecha = eTFecha.getText().toString().trim();
        double monto;
        try {
            monto = Double.parseDouble(eTMonto.getText().toString().trim());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Monto inválido", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase bdTV = bdTipoPago.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID_Cliente", idCliente);
        cv.put("Fecha_Pago", fecha);
        cv.put("Monto", monto);

        long newRowId = bdTV.insert("Pago_Credito", null, cv);
        if (newRowId == -1) {
            Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
        }
        bdTV.close();
        limpiarCampos();
    }
    public void onModRe(View view) {
        if (eTIdPago.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese el ID de Pago a modificar", Toast.LENGTH_SHORT).show();
            return;
        }

        int idPago = Integer.parseInt(eTIdPago.getText().toString().trim());
        if (eTFecha.getText().toString().trim().isEmpty() ||
                eTMonto.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Complete los campos a modificar", Toast.LENGTH_SHORT).show();
            return;
        }
        String fecha = eTFecha.getText().toString().trim();
        double monto;
        try {
            monto = Double.parseDouble(eTMonto.getText().toString().trim());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Monto inválido", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase bdTV = bdTipoPago.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Fecha_Pago", fecha);
        cv.put("Monto", monto);

        int rowsUpdated = bdTV.update("Pago_Credito", cv, "ID_Pago=?", new String[]{String.valueOf(idPago)});
        if (rowsUpdated > 0) {
            Toast.makeText(this, "Registro modificado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontró el registro a modificar", Toast.LENGTH_SHORT).show();
        }
        bdTV.close();
    }
    public void onBoRe(View view) {
        if (eTIdPago.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese el ID de Pago a borrar", Toast.LENGTH_SHORT).show();
            return;
        }
        int idPago = Integer.parseInt(eTIdPago.getText().toString().trim());

        SQLiteDatabase bdTV = bdTipoPago.getWritableDatabase();
        int rowsDeleted = bdTV.delete("Pago_Credito", "ID_Pago=?", new String[]{String.valueOf(idPago)});
        if (rowsDeleted > 0) {
            Toast.makeText(this, "Registro borrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontró el registro a borrar", Toast.LENGTH_SHORT).show();
        }
        bdTV.close();
    }
    public void onConsulRe(View view) {
        if (eTIdPago.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese el ID de Pago para consultar", Toast.LENGTH_SHORT).show();
            return;
        }
        int idPago = Integer.parseInt(eTIdPago.getText().toString().trim());

        SQLiteDatabase bdTV = bdTipoPago.getReadableDatabase();
        Cursor cursor = bdTV.rawQuery("SELECT Fecha_Pago, Monto FROM Pago_Credito WHERE ID_Pago=?", new String[]{String.valueOf(idPago)});
        if (cursor != null && cursor.moveToFirst()) {
            String fechaPago = cursor.getString(cursor.getColumnIndexOrThrow("Fecha_Pago"));
            double monto = cursor.getDouble(cursor.getColumnIndexOrThrow("Monto"));
            eTFecha.setText(fechaPago);
            eTMonto.setText(String.valueOf(monto));
            cursor.close();
        } else {
            Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
        }
        bdTV.close();
    }
    public void onVisualizarRe(View view) {
        Intent intent = new Intent(this, VistaTipoPago.class);
        startActivity(intent);
    }
    private void limpiarCampos() {
        eTIdPago.setText("");
        eTFecha.setText("");
        eTMonto.setText("");
    }
    public void onSalirTipoPago(View view) {
        finish();
    }
}
