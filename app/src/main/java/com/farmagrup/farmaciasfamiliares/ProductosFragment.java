package com.farmagrup.farmaciasfamiliares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;


public class ProductosFragment extends Fragment {

    MaterialCardView naturales;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        naturales = view.findViewById(R.id.btn_naturales);
        naturales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NaturalesFragment naturalesFragment = new NaturalesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor,naturalesFragment)
                        .commit();
            }
        });
        return view;
    }


}