package com.farmagrup.farmaciasfamiliares;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class productos_adapter extends RecyclerView.Adapter<productos_adapter.ViewHolder> {

    private ArrayList<productos_datos> arrayList;
    private int resource;

    public productos_adapter(ArrayList<productos_datos> arrayList, int resource){
        this.arrayList = arrayList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public productos_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productos_adapter.ViewHolder holder, int position) {
        final productos_datos productos_datos = arrayList.get(position);
        holder.precio.setText(productos_datos.getPrecio());
        holder.nombre.setText(productos_datos.getNombre());
        holder.img_product.setImageResource(productos_datos.getImagen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView precio, nombre;
        ImageView img_product;
        ViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.home_producto);
            this.img_product = view.findViewById(R.id.home_image);
            this.precio = view.findViewById(R.id.home_precio);
        }
    }
}
