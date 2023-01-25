package com.farmagrup.farmaciasfamiliares;

import android.animation.LayoutTransition;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class adapter_productos2 extends RecyclerView.Adapter<adapter_productos2.ViewHolder> {
    private ArrayList<productos_datos> mDatos;
    private int resource;


    public adapter_productos2(ArrayList<productos_datos> mDatos,int resource ){
        this.mDatos = mDatos;
        this.resource = resource;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_productos2.ViewHolder holder, int position) {
        final productos_datos productos_datos = mDatos.get(position);
        holder.nombre.setText(productos_datos.getNombre());
        holder.precio.setText("$"+productos_datos.getPrecio()+".00");
        holder.imagen.setImageResource(productos_datos.getImagen());

    }


    @Override
    public int getItemCount() {
        return mDatos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre, precio;
        public  View view;

        ViewHolder(View view){
            super(view);
            this.view = view;
            this.nombre = view.findViewById(R.id.producto_nombre);
            this.precio = view.findViewById(R.id.producto_precio);
            this.imagen= view.findViewById(R.id.producto_imagen);

        }
    }


}
