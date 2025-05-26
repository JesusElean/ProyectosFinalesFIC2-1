package com.example.fruteriarancholopezapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientesAdaptador extends RecyclerView.Adapter<ClientesAdaptador.ClienteViewHolder> {
    private List<ClientesView> listaDeClientes;
    public ClientesAdaptador(List<ClientesView> listaDeClientes){
        this.listaDeClientes = listaDeClientes;
    }

    @NonNull
    @Override
    public ClientesAdaptador.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDeClientes = LayoutInflater.from(parent.getContext()).inflate(R.layout.tablaclientes, parent, false);
        return new ClienteViewHolder(vistaDeClientes);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdaptador.ClienteViewHolder holder, int position) {
    ClientesView cliente = listaDeClientes.get(position);
    holder.tvIdCliente.setText(String.valueOf(cliente.getidCliente()));
    holder.tvNombre.setText(cliente.getNombreCliente());
    holder.tvTelefono.setText(cliente.getTelefono());
    holder.tvSaldoPendiente.setText(String.valueOf(cliente.getSaldoPendiente()));
    }

    @Override
    public int getItemCount() {
        return listaDeClientes.size();
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdCliente, tvNombre, tvTelefono, tvSaldoPendiente;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdCliente = itemView.findViewById(R.id.tVIdCliente);
            tvNombre = itemView.findViewById(R.id.tVNombreCliente);
            tvTelefono = itemView.findViewById(R.id.tvTelefonoCliente);
            tvSaldoPendiente = itemView.findViewById(R.id.tvSaldoPendiente);

            tvIdCliente.setText("IdCliente");
            tvNombre.setText("Nombre");
            tvTelefono.setText("Telefono");
            tvSaldoPendiente.setText("SaldoPendiente");
        }
    }
}

