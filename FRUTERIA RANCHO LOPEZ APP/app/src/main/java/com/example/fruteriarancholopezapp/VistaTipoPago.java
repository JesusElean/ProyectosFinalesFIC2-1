package com.example.fruteriarancholopezapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class VistaTipoPago extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnSalir;
    List<PagoTipoView> listaPagos;
    PagoTipoAdapter adapter;
    BasesDeDatosSQLite bdTipoPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_tipo_pago);


        recyclerView = findViewById(R.id.recyclerView);
        btnSalir = findViewById(R.id.btnSalirRe2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaPagos = new ArrayList<>();
        adapter = new PagoTipoAdapter(listaPagos);
        recyclerView.setAdapter(adapter);

        bdTipoPago = new BasesDeDatosSQLite(this, "FruteriaRanchoLopez.db", null, 1);
        cargarPagos();

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para cargar los registros de Pago_Credito y llenar la lista
    private void cargarPagos() {
        listaPagos.clear();
        SQLiteDatabase db = bdTipoPago.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT ID_Pago, ID_Cliente, Fecha_Pago, Monto FROM Pago_Credito", null);
        if (cursor.moveToFirst()) {
            do {
                int idPago = cursor.getInt(cursor.getColumnIndexOrThrow("ID_Pago"));
                int idCliente = cursor.getInt(cursor.getColumnIndexOrThrow("ID_Cliente"));
                String fechaPago = cursor.getString(cursor.getColumnIndexOrThrow("Fecha_Pago"));
                double monto = cursor.getDouble(cursor.getColumnIndexOrThrow("Monto"));

                listaPagos.add(new PagoTipoView(idPago, idCliente, fechaPago, monto));
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "No hay registros para mostrar.", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
        adapter.notifyDataSetChanged();
    }

    public class PagoTipoAdapter extends RecyclerView.Adapter<PagoTipoAdapter.ViewHolder> {
        List<PagoTipoView> pagos;

        public PagoTipoAdapter(List<PagoTipoView> pagos) {
            this.pagos = pagos;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.tipodepago, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PagoTipoView pago = pagos.get(position);

            holder.tvIdPago.setText(String.valueOf(pago.getIdPago()));
            holder.tvIdCliente.setText(String.valueOf(pago.getIdCliente()));
            holder.tvFechaPago.setText(pago.getFechaPago());
            holder.tvMonto.setText(String.valueOf(pago.getMonto()));
        }

        @Override
        public int getItemCount() {
            return pagos.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            android.widget.TextView tvIdPago, tvIdCliente, tvFechaPago, tvMonto;

            public ViewHolder(View itemView) {
                super(itemView);
                tvIdPago = itemView.findViewById(R.id.textView3);
                tvIdCliente = itemView.findViewById(R.id.textView5);
                tvFechaPago = itemView.findViewById(R.id.textView7);
                tvMonto = itemView.findViewById(R.id.textView9);
            }
        }
    }
}
