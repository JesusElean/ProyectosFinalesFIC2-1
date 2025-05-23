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

public class Productos extends AppCompatActivity {
    EditText etID_Producto, etNombre, etPrecio, etStock, etUnidad;
    BasesDeDatosSQLite database;
    RecyclerView recyclerView;
    ProductosViewAdapter adaptadorproductosview;
    List<ProductosView> listaProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productos);

        etID_Producto = findViewById(R.id.eTId_Producto);
        etNombre = findViewById(R.id.eTNombre);
        etPrecio = findViewById(R.id.eTPrecio);
        etStock = findViewById(R.id.eTStock);
        etUnidad = findViewById(R.id.eTUnidad);
        recyclerView = findViewById(R.id.rVTablasProductos);

        listaProductos = new ArrayList<>();
        adaptadorproductosview = new ProductosViewAdapter(listaProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorproductosview);


        database = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarProductos();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProductos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarProductos() {
        listaProductos.clear(); // Limpiar la lista antes de cargar nuevos datos

        SQLiteDatabase bd = database.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT ID_Producto, Nombre, Precio, Stock, Unidad FROM producto", null);

        if (cursor.moveToFirst()) {
            do {
                listaProductos.add(new ProductosView(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getInt(3),
                        cursor.getString(4)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();

        adaptadorproductosview.notifyDataSetChanged();
    }


    private void limpiarCampos() {
        etID_Producto.setText("");
        etNombre.setText("");
        etPrecio.setText("");
        etStock.setText("");
        etUnidad.setText("");
    }
    public void onAgregar(View view) {
        // Validar si hay campos vacíos.
        if (etNombre.getText().toString().isEmpty() ||
                etPrecio.getText().toString().isEmpty() ||
                etStock.getText().toString().isEmpty() ||
                etUnidad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase bd = database.getWritableDatabase();
        ContentValues registroproductos = new ContentValues();
        registroproductos.put("Nombre", etNombre.getText().toString());
        registroproductos.put("Precio", etPrecio.getText().toString());
        registroproductos.put("Stock", etStock.getText().toString());
        registroproductos.put("Unidad", etUnidad.getText().toString());

        bd.insert("producto", null, registroproductos);
        etID_Producto.setText("");
        etNombre.setText("");
        etPrecio.setText("");
        etStock.setText("");
        etUnidad.setText("");
        bd.close();
        cargarProductos();
        Toast.makeText(this, "PRODUCTO AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
    }

    public void onConsultar(View view) {
        SQLiteDatabase bd = database.getReadableDatabase();
        String iD_Producto = etID_Producto.getText().toString();
        Cursor cursor = bd.rawQuery("SELECT Nombre, Precio, Stock, Unidad FROM producto WHERE ID_Producto=?", new String[]{iD_Producto});

        if (cursor.moveToFirst()) {
            etNombre.setText(cursor.getString(0));
            etPrecio.setText(cursor.getString(1));
            etStock.setText(cursor.getString(2));
            etUnidad.setText(cursor.getString(3));
        } else {
            Toast.makeText(this, "NO EXISTE EL PRODUCTO", Toast.LENGTH_SHORT).show();
            etID_Producto.setText("");
            etNombre.setText("");
            etPrecio.setText("");
            etStock.setText("");
            etUnidad.setText("");
        }
        cursor.close();
        bd.close();
    }

    public void onBorrar(View view) {
        String iD_Producto = etID_Producto.getText().toString();

        if (iD_Producto.isEmpty()) {
            Toast.makeText(this, "Ingresa un ID de producto válido", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase bd = database.getWritableDatabase();
        int cant = bd.delete("producto", "ID_Producto=?", new String[]{iD_Producto});
        bd.close();

        if (cant > 0) {
            Toast.makeText(this, "Producto eliminado correctamente", Toast.LENGTH_SHORT).show();
            limpiarCampos();
            cargarProductos();
        } else {
            Toast.makeText(this, "No existe el producto con ese ID", Toast.LENGTH_SHORT).show();
        }
    }


    public void onModificar(View view) {

        if (etID_Producto.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty() ||
                etPrecio.getText().toString().isEmpty() ||
                etStock.getText().toString().isEmpty() ||
                etUnidad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase bd = database.getWritableDatabase();
        String iD_Producto = etID_Producto.getText().toString();
        ContentValues registroproductos = new ContentValues();
        registroproductos.put("Nombre", etNombre.getText().toString());
        registroproductos.put("Precio", etPrecio.getText().toString());
        registroproductos.put("Stock", etStock.getText().toString());
        registroproductos.put("Unidad", etUnidad.getText().toString());


        int cant = bd.update("producto", registroproductos, "ID_Producto=?", new String[]{iD_Producto});
        if (cant == 1)
            Toast.makeText(this, "SE MODIFICO EL PRODUCTO", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "NO EXISTE EL PRODUCTO", Toast.LENGTH_SHORT).show();

        bd.close();
        cargarProductos();
        limpiarCampos();
    }

    private boolean datosVacios() {
        return etID_Producto.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty() ||
                etPrecio.getText().toString().isEmpty() ||
                etStock.getText().toString().isEmpty() ||
                etUnidad.getText().toString().isEmpty();
    }

    public void onSalirDeProductos(View view){
        finish();
    }
}
