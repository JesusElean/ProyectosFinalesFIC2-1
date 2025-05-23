package com.example.fruteriarancholopezapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder> {
    private List<VistaUsuario> listaUsuarios;

    public AdaptadorUsuario(List<VistaUsuario> listaUsuarios) {this.listaUsuarios = listaUsuarios;}

    @NonNull
    @Override
    public AdaptadorUsuario.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDeUsuario = LayoutInflater.from(parent.getContext()).inflate(R.layout.tablausuario, parent, false);
        return new UsuarioViewHolder(vistaDeUsuario);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUsuario.UsuarioViewHolder holder, int position) {
        VistaUsuario usuario = listaUsuarios.get(position);
        holder.tVIdUsuario.setText(String.valueOf(usuario.getIdUsuario()));
        holder.tVNombreUsuario.setText(usuario.getNombreUsuario());
        holder.tVRol.setText(usuario.getRol());
        holder.tVContrasena.setText(usuario.getContrasena());
        String caracteresNormalizados = usuario.getNombreUsuario().toLowerCase()
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .trim();
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView tVIdUsuario, tVNombreUsuario, tVRol, tVContrasena;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tVIdUsuario = itemView.findViewById(R.id.tVIdUsuario_2);
            tVNombreUsuario = itemView.findViewById(R.id.tVNombreUsuario_2);
            tVRol = itemView.findViewById(R.id.tVRol_2);
            tVContrasena = itemView.findViewById(R.id.tVContraseña_2);

            tVIdUsuario.setText("IdUsuario");
            tVNombreUsuario.setText("NombreUsuario");
            tVRol.setText("Rol");
            tVContrasena.setText("Contraseña");
        }

    }
}
