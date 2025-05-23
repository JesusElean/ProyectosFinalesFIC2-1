package com.example.fruteriarancholopezapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VentasAdapter extends RecyclerView.Adapter<VentasAdapter.VentaViewHolder> {
    private List<VentasView> listaVentas;

    public VentasAdapter(List<VentasView> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @NonNull
    @Override
    public VentasAdapter.VentaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDeTablaVentas = LayoutInflater.from(parent.getContext()).inflate(R.layout.tablaventas, parent, false);
        return new VentaViewHolder(vistaDeTablaVentas);
    }

    @Override
    public void onBindViewHolder(@NonNull VentasAdapter.VentaViewHolder holder, int position) {
        VentasView venta = listaVentas.get(position);
        holder.tVIdVenta.setText(String.valueOf(venta.getIdVenta()));
        holder.tVFechaVenta.setText(venta.getFechaVenta());
        holder.tVTotalVentas.setText(String.valueOf(venta.getTotalVenta()));
        holder.tVIdCliente.setText(String.valueOf(venta.getIdCliente()));
        holder.tVTipoPago.setText(venta.getTipoPago());

        String caracteresNormalizados = venta.getTipoPago()
                .toLowerCase()
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .trim();
    }

    @Override
    public int getItemCount() {
        return listaVentas.size();
    }

    public static class VentaViewHolder extends RecyclerView.ViewHolder {
        TextView tVIdVenta, tVFechaVenta, tVTotalVentas, tVIdCliente, tVTipoPago;

        public VentaViewHolder(@NonNull View itemView) {
            super(itemView);

            tVIdVenta = itemView.findViewById(R.id.tVId_Venta_1);
            tVFechaVenta = itemView.findViewById(R.id.tVFechaVenta_1);
            tVTotalVentas = itemView.findViewById(R.id.tVTotalVenta_1);
            tVIdCliente = itemView.findViewById(R.id.tVId_Cliente_1);
            tVTipoPago = itemView.findViewById(R.id.tVTipoDePago_1);

            tVIdVenta.setText("IdVenta");
            tVFechaVenta.setText("Fecha");
            tVTotalVentas.setText("Total");
            tVIdCliente.setText("IdCliente");
            tVTipoPago.setText("TipoPago");
        }
    }
}

