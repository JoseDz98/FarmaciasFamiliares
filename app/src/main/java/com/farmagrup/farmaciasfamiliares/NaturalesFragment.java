package com.farmagrup.farmaciasfamiliares;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NaturalesFragment extends Fragment {

    TextView error_text;
    RecyclerView recycler_naturales, recycler_naturales2;
    ArrayList<productos_datos> arrayList = new ArrayList<>();
    ArrayList<productos_datos> arrayList2 = new ArrayList<>();
    adapter_productos2 adapter_productos2, adapter_productos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_naturales, container, false);
        recycler_naturales = view.findViewById(R.id.recycler_naturales);
        recycler_naturales.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_naturales2 = view.findViewById(R.id.recycler_naturales2);
        recycler_naturales2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        error_text = view.findViewById(R.id.error);

        //Conectar a base de datos y extraer informacion
        String url = "http://192.168.1.20/FarmaciasFamiliares/obtener_lista_naturales.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                error_text.setText(response);
                String[] datos =response.split("\n");
                List<String> stringList = new ArrayList<>(Arrays.asList(datos));
                int tamaño = stringList.size();
                int mitad = tamaño/2;
                for(int x=0; x<mitad; x++){
                    String name =  datos[x].substring(0,datos[x].indexOf(":"));
                    String id = datos[x].substring(datos[x].indexOf(":")+1, datos[x].indexOf("$"));
                    String precio = datos[x].substring(datos[x].indexOf("$")+1);
                    String url_imagen = "http://192.168.1.20/imagenes/"+id+".png";
                    arrayList.add(new productos_datos(precio, name, R.drawable.calcio));
                }
                for(int x=mitad; x<tamaño; x++){
                    String name =  datos[x].substring(0,datos[x].indexOf(":"));
                    String id = datos[x].substring(datos[x].indexOf(":")+1, datos[x].indexOf("$"));
                    String precio = datos[x].substring(datos[x].indexOf("$")+1);
                    String url_imagen = "http://192.168.1.20/imagenes/"+id+".png";
                    arrayList2.add(new productos_datos(precio, name, R.drawable.calcio));
                }

                adapter_productos = new adapter_productos2(arrayList2, R.layout.cards_productos);
                adapter_productos2 = new adapter_productos2(arrayList, R.layout.cards_productos);
                recycler_naturales.setAdapter(adapter_productos2);
                recycler_naturales2.setAdapter(adapter_productos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        return view;
    }
}