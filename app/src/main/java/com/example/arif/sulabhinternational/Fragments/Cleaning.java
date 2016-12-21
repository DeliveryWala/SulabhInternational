package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arif.sulabhinternational.Adapters.CleaningAdapter;
import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cleaning extends Fragment {
    private int[] img={R.drawable.girlghat,R.drawable.bringbackghat,R.drawable.ummahes,R.drawable.bringbackghat,R.drawable.cleanindiaus,
            R.drawable.motherganga,R.drawable.ghatsclean,R.drawable.bringbak,R.drawable.airport,R.drawable.ghatsclean,R.drawable.ghats,
    R.drawable.bringbak,R.drawable.nalanearghat};
    private CleaningAdapter adapter;
    private RecyclerView recyclerView;


    public Cleaning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cleaning, container, false);

        String[] head=getResources().getStringArray(R.array.cleaning_head);
        String[] info=getResources().getStringArray(R.array.cleaning_info);
        String[] details=getResources().getStringArray(R.array.cleaning_details);

        recyclerView= (RecyclerView) view.findViewById(R.id.cleaning_recycler);
        adapter=new CleaningAdapter(getContext(),img,head,info,details);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }


}
