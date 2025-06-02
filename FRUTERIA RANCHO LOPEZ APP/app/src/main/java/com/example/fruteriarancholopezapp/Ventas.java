package com.example.fruteriarancholopezapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Ventas extends AppCompatActivity {
    EditText etIdVenta, etFechaVenta, etTotalVenta, etTipoPago;
    BasesDeDatosSQLite ventasBD;
    RecyclerView rcV;
    VentasAdapter adaptadorVentas;
    List<VentasView> listaVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ventas);

        etIdVenta = findViewById(R.id.eTId_Venta);
        etFechaVenta = findViewById(R.id.eTFechaVenta);
        etTotalVenta = findViewById(R.id.eTTotalVentas);
        etTipoPago = findViewById(R.id.eTTipo_Pago);
        rcV = findViewById(R.id.rVVentas);

        listaVentas = new ArrayList<>();
        adaptadorVentas = new VentasAdapter(listaVentas);
        rcV.setLayoutManager(new LinearLayoutManager(this));
        rcV.setAdapter(adaptadorVentas);

        ventasBD = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarVentas();
        camposVacios();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDetallesVentas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarVentas() {
        listaVentas.clear();
        SQLiteDatabase tablaDeVentas = ventasBD.getReadableDatabase();
        Cursor movimiento = tablaDeVentas.rawQuery("SELECT ID_Venta, Fecha, Total, ID_Cliente, Tipo_Pago FROM Venta", null);
        if (movimiento.moveToFirst()) {
            do {
                listaVentas.add(new VentasView(
                        movimiento.getInt(0),
                        movimiento.getString(1),
                        movimiento.getDouble(2),
                        movimiento.getInt(3),
                        movimiento.getString(4)
                ));
            } while (movimiento.moveToNext());
        }
        movimiento.close();
        tablaDeVentas.close();
        adaptadorVentas.notifyDataSetChanged();
    }

    private void limpiarCamposDeTablaVenta() {
        etIdVenta.setText("");
        etFechaVenta.setText("");
        etTotalVenta.setText("");
        etTipoPago.setText("");
    }

    public void onAgregarVenta(View view) {
        if (etFechaVenta.getText().toString().isEmpty() ||
                etTotalVenta.getText().toString().isEmpty() ||
                etTipoPago.getText().toString().isEmpty()) {

            Toast.makeText(this, "Por favor, llena todos los campos (excepto ID_Cliente)", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase tablaDeVentas = ventasBD.getWritableDatabase();
        ContentValues agregarVentas = new ContentValues();
        agregarVentas.put("Fecha", etFechaVenta.getText().toString());
        agregarVentas.put("Total", etTotalVenta.getText().toString());
        int foreignIdCliente = getIntent().getIntExtra("ID_Cliente", -1);
        if (foreignIdCliente == -1) {
            Toast.makeText(this, "Error al obtener el ID de Cliente", Toast.LENGTH_SHORT).show();
            tablaDeVentas.close();
            return;
        }
        agregarVentas.put("ID_Cliente", foreignIdCliente);
        agregarVentas.put("Tipo_Pago", etTipoPago.getText().toString());

        long newVentaId = tablaDeVentas.insert("Venta", null, agregarVentas);
        if(newVentaId == -1) {
            Toast.makeText(this, "Error al guardar la venta", Toast.LENGTH_SHORT).show();
            tablaDeVentas.close();
            return;
        }
        limpiarCamposDeTablaVenta();
        tablaDeVentas.close();
        cargarVentas();
        Toast.makeText(this, "VENTA AGREGADA CORRECTAMENTE", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Ventas.this, DetallesVentas.class);
        intent.putExtra("ID_Venta", (int)newVentaId);
        intent.putExtra("ID_Producto", 1);
        startActivity(intent);
    }

    public void onModificarVenta(View view) {
        if (etIdVenta.getText().toString().isEmpty() ||
                etFechaVenta.getText().toString().isEmpty() ||
                etTotalVenta.getText().toString().isEmpty() ||
                etTipoPago.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos (excepto ID_Cliente)", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeVentas = ventasBD.getWritableDatabase();
        String iD_Venta = etIdVenta.getText().toString();
        ContentValues registroVentas = new ContentValues();
        registroVentas.put("Fecha", etFechaVenta.getText().toString());
        registroVentas.put("Total", etTotalVenta.getText().toString());
        registroVentas.put("Tipo_Pago", etTipoPago.getText().toString());

        int cant = tablaDeVentas.update("Venta", registroVentas, "ID_Venta=?", new String[]{iD_Venta});
        if (cant == 1)
            Toast.makeText(this, "SE MODIFICO LA VENTA", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "NO EXISTE LA VENTA", Toast.LENGTH_SHORT).show();

        tablaDeVentas.close();
        cargarVentas();
        limpiarCamposDeTablaVenta();
    }

    public void onBorrarVenta(View view) {
        String iD_Venta = etIdVenta.getText().toString();

        if (iD_Venta.isEmpty()) {
            Toast.makeText(this, "Ingresa un ID de venta válido", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase tablaDeVentas = ventasBD.getWritableDatabase();
        int cant = tablaDeVentas.delete("Venta", "ID_Venta=?", new String[]{iD_Venta});
        tablaDeVentas.close();

        if (cant > 0) {
            Toast.makeText(this, "Venta eliminada correctamente", Toast.LENGTH_SHORT).show();
            limpiarCamposDeTablaVenta();
            cargarVentas();
        } else {
            Toast.makeText(this, "No existe la venta con ese ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void onConsultarVenta(View view) {
        SQLiteDatabase tablaDeVentas = ventasBD.getReadableDatabase();
        String iD_Venta = etIdVenta.getText().toString();
        Cursor cursorConsultar = tablaDeVentas.rawQuery("SELECT Fecha, Total, Tipo_Pago FROM Venta WHERE ID_Venta=?", new String[]{iD_Venta});
        if (cursorConsultar.moveToFirst()) {
            etFechaVenta.setText(cursorConsultar.getString(0));
            etTotalVenta.setText(cursorConsultar.getString(1));
            etTipoPago.setText(cursorConsultar.getString(2));
        } else {
            Toast.makeText(this, "NO EXISTE LA VENTA", Toast.LENGTH_SHORT).show();
            limpiarCamposDeTablaVenta();
        }
        cursorConsultar.close();
        tablaDeVentas.close();
    }

    private boolean camposVacios() {
        return etIdVenta.getText().toString().isEmpty() ||
                etFechaVenta.getText().toString().isEmpty() ||
                etTotalVenta.getText().toString().isEmpty() ||
                etTipoPago.getText().toString().isEmpty();
    }

    public void onSalirDeVentas(View view) {
        finish();
    }
}
