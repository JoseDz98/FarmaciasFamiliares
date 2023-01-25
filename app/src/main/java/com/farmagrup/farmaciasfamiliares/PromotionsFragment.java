package com.farmagrup.farmaciasfamiliares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PromotionsFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<promotions_datos> arrayList = new ArrayList<>();
    private  Promotions_Adapter promotions_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promotions, container, false);
        recyclerView = view.findViewById(R.id.recycler_promos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        int imagen[] = {R.drawable.calcio};
        arrayList.clear();
        arrayList.add(new promotions_datos("Caramelo la tia trini","3x100", imagen[0]));
        promotions_adapter = new Promotions_Adapter(arrayList, R.layout.cards_promotions);
        recyclerView.setAdapter(promotions_adapter);
        return  view;
    }
}