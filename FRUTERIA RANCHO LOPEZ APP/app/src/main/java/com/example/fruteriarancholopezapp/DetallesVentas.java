package com.example.fruteriarancholopezapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DetallesVentas extends AppCompatActivity {
    EditText etIdDetalle, etCantidad, etSubtotal;
    BasesDeDatosSQLite detallesVentasBD;
    RecyclerView mostrarTabla;
    DetallesAdapter adaptadorDetallesVentas;
    List<DetallesView> listaDetallesVentas;
    Button btnExportar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_ventas);

        etIdDetalle = findViewById(R.id.eTIdDetalle);
        etCantidad = findViewById(R.id.eTCantidad);
        etSubtotal = findViewById(R.id.eTSubtotal);
        btnExportar = findViewById(R.id.btnExportar);
        Spinner spinnerProductos = findViewById(R.id.spinnerProductos);

        mostrarTabla = findViewById(R.id.rVDV);

        listaDetallesVentas = new ArrayList<>();
        adaptadorDetallesVentas = new DetallesAdapter(listaDetallesVentas);
        mostrarTabla.setLayoutManager(new LinearLayoutManager(this));
        mostrarTabla.setAdapter(adaptadorDetallesVentas);

        detallesVentasBD = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarDetallesVentas();


        List<ProductosView> listaProductosSpinner = new ArrayList<>();

        SQLiteDatabase bd = detallesVentasBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT ID_Producto, Nombre FROM producto", null);
        if (cursor.moveToFirst()) {
            do {

                int idProducto = cursor.getInt(0);
                String nombreProducto = cursor.getString(1);
                listaProductosSpinner.add(new ProductosView(idProducto, nombreProducto, 0, 0, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();

        ArrayAdapter<ProductosView> adapterSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listaProductosSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProductos.setAdapter(adapterSpinner);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDetallesVentas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarDetallesVentas() {
        listaDetallesVentas.clear();
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getReadableDatabase();
        Cursor movDetallesVentas = tablaDeDetallesVentas.rawQuery(
                "SELECT ID_Detalle, ID_Venta, ID_Producto, Cantidad, Subtotal FROM Detalle_Venta", null);
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
        etIdDetalle.setText("");
        etCantidad.setText("");
        etSubtotal.setText("");
    }


    public void onExportar(View view) {
        SQLiteDatabase db = detallesVentasBD.getReadableDatabase();
        String tabla = "Detalle_Venta";
        String nombreArchivo = "detalles_ventas.csv";

        exportarTablaACSV(db, tabla, nombreArchivo);
        db.close();
    }

    public void exportarTablaACSV(SQLiteDatabase db, String tabla, String archivoCSV) {
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM " + tabla, null);

            File exportDir = new File(getExternalFilesDir(null), "");
            if (!exportDir.exists()) {
                exportDir.mkdirs();
            }
            File file = new File(exportDir, archivoCSV);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            String[] columnNames = cursor.getColumnNames();
            String cabecera = TextUtils.join(",", columnNames);
            bw.write(cabecera);
            bw.newLine();

            while (cursor.moveToNext()) {
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    String dato = cursor.getString(i);
                    if (dato != null) {
                        if (dato.contains(",") || dato.contains("\n")) {
                            dato = "\"" + dato + "\"";
                        }
                    } else {
                        dato = "";
                    }
                    row.append(dato);
                    if (i < cursor.getColumnCount() - 1) {
                        row.append(",");
                    }
                }
                bw.write(row.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            cursor.close();
            Toast.makeText(this, "Exportado a " + archivoCSV, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al exportar a CSV", Toast.LENGTH_LONG).show();
        }
    }
    public void onAgregarDetalle(View view) {
        if(etIdDetalle.getText().toString().isEmpty() ||
                etCantidad.getText().toString().isEmpty() ||
                etSubtotal.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        int foreignIDVenta = getIntent().getIntExtra("ID_Venta", -1);
        if(foreignIDVenta == -1) {
            Toast.makeText(this, "Error al obtener el ID de Venta", Toast.LENGTH_SHORT).show();
            return;
        }

        Spinner spinnerProductos = findViewById(R.id.spinnerProductos);
        ProductosView productoSeleccionado = (ProductosView) spinnerProductos.getSelectedItem();
        int foreignIDProducto = productoSeleccionado.getID_Producto();

        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getWritableDatabase();
        ContentValues agregarDetalles = new ContentValues();
        agregarDetalles.put("ID_Venta", foreignIDVenta);
        agregarDetalles.put("ID_Producto", foreignIDProducto);
        agregarDetalles.put("Cantidad", etCantidad.getText().toString());
        agregarDetalles.put("Subtotal", etSubtotal.getText().toString());

        long resultado = tablaDeDetallesVentas.insert("Detalle_Venta", null, agregarDetalles);
        if (resultado == -1) {
            Toast.makeText(this, "Error al agregar el detalle", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "DETALLE AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
        }
        limpiarCamposDeDetalles();
        tablaDeDetallesVentas.close();
        cargarDetallesVentas();
    }


    public void onModificarDetalle(View view) {
        if(etIdDetalle.getText().toString().isEmpty() ||
                etCantidad.getText().toString().isEmpty() ||
                etSubtotal.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase tablaDeDetallesVentas = detallesVentasBD.getWritableDatabase();
        String iD_Detalle = etIdDetalle.getText().toString();
        ContentValues registroDetalles = new ContentValues();
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
        String iD_Detalle = etIdDetalle.getText().toString();
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
        String iD_Detalle = etIdDetalle.getText().toString();
        Cursor cursorConsultar = tablaDeDetallesVentas.rawQuery(
                "SELECT Cantidad, Subtotal FROM Detalle_Venta WHERE ID_Detalle=?", new String[]{iD_Detalle});
        if (cursorConsultar.moveToFirst()) {
            etCantidad.setText(cursorConsultar.getString(0));
            etSubtotal.setText(cursorConsultar.getString(1));
        } else {
            Toast.makeText(this, "NO EXISTE EL DETALLE", Toast.LENGTH_SHORT).show();
            limpiarCamposDeDetalles();
        }
        cursorConsultar.close();
        tablaDeDetallesVentas.close();
    }

    public void onSalirDetallesVentas(View view) {
        finish();
    }
}
