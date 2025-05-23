package com.example.fruteriarancholopezapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.DetalleViewHolder>{
    private List<DetallesView> listaDetallesVentas;
    public DetallesAdapter(List<DetallesView> listaDetallesVentas){
        this.listaDetallesVentas = listaDetallesVentas;
    }
    @NonNull
    @Override
    public DetallesAdapter.DetalleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDeDetallesDeVentas = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabladedetallesdeventas, parent, false);
        return new DetalleViewHolder(vistaDeDetallesDeVentas);
    }

    @Override
    public void onBindViewHolder(@NonNull DetallesAdapter.DetalleViewHolder holder, int position) {
        DetallesView detalleVentas = listaDetallesVentas.get(position);
        holder.tvIdDetalle.setText(String.valueOf(detalleVentas.getIdDetalleVentas()));
        holder.tvIdVenta.setText(String.valueOf(detalleVentas.getIdVenta()));
        holder.tvIdProducto.setText(String.valueOf(detalleVentas.getID_Producto()));
        holder.tvCantidad.setText(String.valueOf(detalleVentas.getCantidad()));
        holder.tvSubtotal.setText(String.valueOf(detalleVentas.getSubtotal()));
    }

    @Override
    public int getItemCount() {
        return listaDetallesVentas.size();
    }

    public static class DetalleViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdDetalle, tvIdVenta, tvIdProducto, tvCantidad, tvSubtotal;
        public DetalleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdDetalle = itemView.findViewById(R.id.tVIdDetalles1);
            tvIdVenta = itemView.findViewById(R.id.tVIdVentas1);
            tvIdProducto = itemView.findViewById(R.id.tVIdProducto1);
            tvCantidad = itemView.findViewById(R.id.tVCantidad1);
            tvSubtotal = itemView.findViewById(R.id.tVSubtotal1);

            tvIdDetalle.setText("IdDetalle");
            tvIdVenta.setText("IdVenta");
            tvIdProducto.setText("IdProducto");
            tvCantidad.setText("Cantidad");
            tvSubtotal.setText("Subtotal");
        }
    }
}


