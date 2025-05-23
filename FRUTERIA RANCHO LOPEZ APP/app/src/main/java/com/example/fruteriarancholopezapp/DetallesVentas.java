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

public class DetallesVentas extends AppCompatActivity {
    EditText etId_Detalle, etId_Venta, etId_Producto, etCantidad, etSubtotal;
    BasesDeDatosSQLite detallesVentasBD;
    Toolbar cajaDeHerramientasDetalles;
    RecyclerView mostrarTabla;
    DetallesAdapter adaptadorDetallesVentas;
    List<DetallesView> listaDetallesVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_ventas);

        etId_Detalle = findViewById(R.id.eTIdDetalle);
        etId_Venta = findViewById(R.id.eTIDV);
        etId_Producto = findViewById(R.id.eTIDP);
        etCantidad = findViewById(R.id.eTCantidad);
        etSubtotal = findViewById(R.id.eTSubtotal);

        mostrarTabla = findViewById(R.id.rVDV);
        cajaDeHerramientasDetalles = findViewById(R.id.tBDetallesVentas);
        setSupportActionBar(cajaDeHerramientasDetalles);

        listaDetallesVentas = new ArrayList<>();
        adaptadorDetallesVentas = new DetallesAdapter(listaDetallesVentas);
        mostrarTabla.setLayoutManager(new LinearLayoutManager(this));
        mostrarTabla.setAdapter(adaptadorDetallesVentas);

        detallesVentasBD = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarDetallesVentas();
        camposVacios();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDetallesVentas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarDetallesVentas() {
        listaDetallesVentas.clear();
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getReadableDatabase();
        Cursor movDetallesVentas = tablaDeDetallesVentas.rawQuery("SELECT ID_Detalle, ID_Venta, ID_Producto, Cantidad, Subtotal FROM Detalle_Venta", null);
        if (movDetallesVentas.moveToFirst()) {
            do {
                listaDetallesVentas.add(new DetallesView(
                        movDetallesVentas.getInt(0),
                        movDetallesVentas.getInt(1),
                        movDetallesVentas.getInt(2),
                        movDetallesVentas.getInt(3),
                        movDetallesVentas.getDouble(4)
                ));
            } while (movDetallesVentas.moveToNext());
        }
        movDetallesVentas.close();
        tablaDeDetallesVentas.close();
        adaptadorDetallesVentas.notifyDataSetChanged();
    }

    private void limpiarCamposDeDetalles() {
        etId_Detalle.setText("");
        etId_Venta.setText("");
        etId_Producto.setText("");
        etCantidad.setText("");
        etSubtotal.setText("");
    }

    public void onAgregarDetalle(View view) {
        if(etId_Detalle.getText().toString().isEmpty() ||
                etId_Venta.getText().toString().isEmpty() ||
                etId_Producto.getText().toString().isEmpty() ||
                etCantidad.getText().toString().isEmpty() ||
                etSubtotal.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getWritableDatabase();
        ContentValues agregarDetalles = new ContentValues();
        agregarDetalles.put("ID_Detalle", etId_Detalle.getText().toString());
        agregarDetalles.put("ID_Venta", etId_Venta.getText().toString());
        agregarDetalles.put("ID_Producto", etId_Producto.getText().toString());
        agregarDetalles.put("Cantidad", etCantidad.getText().toString());
        agregarDetalles.put("Subtotal", etSubtotal.getText().toString());

        tablaDeDetallesVentas.insert("Detalle_Venta", null, agregarDetalles);
        etId_Detalle.setText("");
        etId_Venta.setText("");
        etId_Producto.setText("");
        etCantidad.setText("");
        etSubtotal.setText("");
        tablaDeDetallesVentas.close();
        cargarDetallesVentas();
        Toast.makeText(this, "DETALLE AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
    }

    public void onModificarDetalle(View view) {
        if(etId_Detalle.getText().toString().isEmpty() ||
                etId_Venta.getText().toString().isEmpty() ||
                etId_Producto.getText().toString().isEmpty() ||
                etCantidad.getText().toString().isEmpty() ||
                etSubtotal.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getWritableDatabase();
        String iD_Detalle = etId_Detalle.getText().toString();
        ContentValues registroDetalles = new ContentValues();
        registroDetalles.put("ID_Venta", etId_Venta.getText().toString());
        registroDetalles.put("ID_Producto", etId_Producto.getText().toString());
        registroDetalles.put("Cantidad", etCantidad.getText().toString());
        registroDetalles.put("Subtotal", etSubtotal.getText().toString());

        int cant = tablaDeDetallesVentas.update("Detalle_Venta", registroDetalles, "ID_Detalle=?", new String[]{iD_Detalle});
        if (cant == 1)
            Toast.makeText(this, "SE MODIFICO EL DETALLE", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "NO EXISTE EL DETALLE", Toast.LENGTH_SHORT).show();

        tablaDeDetallesVentas.close();
        cargarDetallesVentas();
        limpiarCamposDeDetalles();
    }

    public void onBorrarDetalle(View view) {
        String iD_Detalle = etId_Detalle.getText().toString();
        if (iD_Detalle.isEmpty()) {
            Toast.makeText(this, "Ingresa un ID de detalle válido", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getWritableDatabase();
        int cant = tablaDeDetallesVentas.delete("Detalle_Venta", "ID_Detalle=?", new String[]{iD_Detalle});
        tablaDeDetallesVentas.close();
        if (cant > 0) {
            Toast.makeText(this, "Detalle eliminado correctamente", Toast.LENGTH_SHORT).show();
            limpiarCamposDeDetalles();
            cargarDetallesVentas();
            } else {
            Toast.makeText(this, "No existe el detalle con ese ID", Toast.LENGTH_SHORT).show();
        }
    }
    public void onConsultarDetalle(View view) {
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getReadableDatabase();
        String iD_Detalle = etId_Detalle.getText().toString();
        Cursor cursorConsultar = tablaDeDetallesVentas.rawQuery("SELECT ID_Venta, ID_Producto, Cantidad, Subtotal FROM Detalle_Venta WHERE ID_Detalle=?", new String[]{iD_Detalle});
        if (cursorConsultar.moveToFirst()) {
            etId_Venta.setText(cursorConsultar.getString(0));
            etId_Producto.setText(cursorConsultar.getString(1));
            etCantidad.setText(cursorConsultar.getString(2));
            etSubtotal.setText(cursorConsultar.getString(3));
        } else {
            Toast.makeText(this, "NO EXISTE EL DETALLE", Toast.LENGTH_SHORT).show();
            etId_Detalle.setText("");
            etId_Venta.setText("");
            etId_Producto.setText("");
            etCantidad.setText("");
            etSubtotal.setText("");
        }
        cursorConsultar.close();
        tablaDeDetallesVentas.close();
    }

    private boolean camposVacios() {
        return etId_Detalle.getText().toString().isEmpty() ||
                etId_Venta.getText().toString().isEmpty() ||
                etId_Producto.getText().toString().isEmpty() ||
                etCantidad.getText().toString().isEmpty() ||
                etSubtotal.getText().toString().isEmpty();
    }
    public void onSalirDetallesVentas(View view) {
        finish();
    }
}
