package com.farmagrup.farmaciasfamiliares;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Promotions_Adapter extends RecyclerView.Adapter<Promotions_Adapter.ViewHolder> {
    private ArrayList<promotions_datos> arrayList;
    private int image_code;
    private int resource;

    public Promotions_Adapter(ArrayList<promotions_datos> arrayList, int resource){
        this.arrayList = arrayList;
        this.resource = resource;
    }



    @NonNull
    @Override
    public Promotions_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Promotions_Adapter.ViewHolder holder, int position) {
        final promotions_datos promotions_datos = arrayList.get(position);
        holder.imagen.setImageResource(promotions_datos.getImagen());
        holder.nombre.setText(promotions_datos.getProducto());
        holder.descripcion.setText(promotions_datos.getDescripcion());
        holder.setIsRecyclable(false);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView descripcion;
        private ImageView imagen;

        ViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.promo_producto);
            this.descripcion = view.findViewById(R.id.promo_description);
            this.imagen = view.findViewById(R.id.promo_imagen);
        }

    }
}
