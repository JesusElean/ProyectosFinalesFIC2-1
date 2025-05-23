package com.example.fruteriarancholopezapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductosViewAdapter extends RecyclerView.Adapter<ProductosViewAdapter.ProductoViewHolder> {

    private List<ProductosView> listaProductos;

    // Constructor
    public ProductosViewAdapter(List<ProductosView> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDeTabla = LayoutInflater.from(parent.getContext()).inflate(R.layout.tablasproductos, parent, false);
        return new ProductoViewHolder(vistaDeTabla);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        ProductosView producto = listaProductos.get(position);
        holder.tvID.setText(String.valueOf(producto.getID_Producto()));
        holder.tvNombre.setText(producto.getNombre());
        holder.tvPrecio.setText("$ " + producto.getPrecio());
        holder.tvStock.setText(String.valueOf(producto.getStock()));
        holder.tvUnidad.setText(String.valueOf(producto.getUnidad()));


        String nombreNormalizado = producto.getNombre()
                .toLowerCase()
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .trim();
        switch (nombreNormalizado) {
            case "mango":
                holder.imgProducto.setImageResource(R.drawable.mango);
                break;
            case "platano":
                holder.imgProducto.setImageResource(R.drawable.platano);
                break;
            case "sandia":
                holder.imgProducto.setImageResource(R.drawable.sandia);
                break;
            case "mazorca":
                holder.imgProducto.setImageResource(R.drawable.mazorca);
                break;
            case "frijol":
                holder.imgProducto.setImageResource(R.drawable.frijol);
                break;
            case "manzana":
                holder.imgProducto.setImageResource(R.drawable.apple);
                break;
            case "aguacate" :
                holder.imgProducto.setImageResource(R.drawable.avocado);
                break;
            case "kiwi":
                holder.imgProducto.setImageResource(R.drawable.kiwi);
                break;
            case "trigo":
                holder.imgProducto.setImageResource(R.drawable.trigo);
                break;
            case "fresa":
                holder.imgProducto.setImageResource(R.drawable.strawberry);
                break;
            case "melon":
                holder.imgProducto.setImageResource(R.drawable.melon);
                break;
            case "piña":
                holder.imgProducto.setImageResource(R.drawable.pineapple);
                break;
            case "arroz":
                holder.imgProducto.setImageResource(R.drawable.rice);
                break;

            default:
                holder.imgProducto.setImageResource(R.drawable.cuadradoblanco);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvID, tvNombre, tvPrecio, tvStock, tvUnidad;
        ImageView imgProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tVId_Productos1);
            tvNombre = itemView.findViewById(R.id.tVNombre1);
            tvPrecio = itemView.findViewById(R.id.tVPrecio1);
            tvStock = itemView.findViewById(R.id.tVStock1);
            tvUnidad = itemView.findViewById(R.id.tVUnidad1);
            imgProducto = itemView.findViewById(R.id.iVImagenProducto1);

            tvID.setText("");
            tvNombre.setText("");
            tvPrecio.setText("");
            tvStock.setText("");
            tvUnidad.setText("");

        }
    }

}
