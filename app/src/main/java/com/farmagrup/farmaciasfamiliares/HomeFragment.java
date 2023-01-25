package com.farmagrup.farmaciasfamiliares;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView recycler_destacados, recycler_ventas, recycler_novedades;
    ArrayList<productos_datos> array_destacados = new ArrayList<>();
    ArrayList<productos_datos> array_servicios = new ArrayList<>();
    productos_adapter productos_adapter, servicios_adapter;
    ViewPager viewpager_portadas;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout_dots;
    ImageView whatsapp, facebook, web;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Declaracion
        recycler_destacados = view.findViewById(R.id.recycler_destacados);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_destacados.setLayoutManager(linearLayoutManager);
        recycler_novedades = view.findViewById(R.id.recycler_novedades);
        recycler_novedades.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recycler_ventas = view.findViewById(R.id.recycler_ventas);
        recycler_ventas.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        viewpager_portadas = view.findViewById(R.id.viewpager_portadas);
        tabLayout_dots = view.findViewById(R.id.tab_dots);
        web = view.findViewById(R.id.btn_web);


        //Arreglo de imagenes portada
        int portadas[] ={R.drawable.portada, R.drawable.sucursales, R.drawable.portada_1};
        //Adaptador portadas
        viewPagerAdapter = new ViewPagerAdapter(getActivity(),portadas);
        viewpager_portadas.setAdapter(viewPagerAdapter);


        //Puntos
        tabLayout_dots.setupWithViewPager(viewpager_portadas);

        //llenar arreglos
        int imagenes[] = {R.drawable.calcio};
        array_destacados.clear();
        array_destacados.add(new productos_datos("$50.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$149.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$10.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$79.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$89.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$99.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$119.00", "Calcio",imagenes[0]));
        array_destacados.add(new productos_datos("$100.00", "Calcio",imagenes[0]));






        //Adaptadores de recycler view
        servicios_adapter = new productos_adapter(array_servicios, R.layout.home_cards);
        productos_adapter = new productos_adapter(array_destacados, R.layout.home_cards);
        recycler_destacados.setAdapter(productos_adapter);
        recycler_ventas.setAdapter(productos_adapter);
        recycler_novedades.setAdapter(productos_adapter);




        //Botones redes sociales
        whatsapp = view.findViewById(R.id.btn_whatsapp);
        facebook = view.findViewById(R.id.btn_facebook);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://api.whatsapp.com/send/?phone=523320656261&text&type=phone_number&app_absent=0");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://es-la.facebook.com/FarmaciasFamiliares/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.farmaciasfamiliares.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return  view;
    }

}