package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arif.sulabhinternational.Adapters.GalleryAdapter;
import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gallery extends Fragment {
    RecyclerView recyclerView;
    int[] img = {R.drawable.adsddddddd, R.drawable.ascaca, R.drawable.asda, R.drawable.asdadasd, R.drawable.asdads, R.drawable.asdasdasd,
            R.drawable.asdf, R.drawable.dasdasd, R.drawable.dasddasda, R.drawable.dsdadasd, R.drawable.fdd, R.drawable.fdvdscxz,
            R.drawable.gfdsae, R.drawable.gfdsagh, R.drawable.hgfdx, R.drawable.lkjh, R.drawable.q, R.drawable.qsc, R.drawable.qwertg,
            R.drawable.re, R.drawable.rt, R.drawable.s, R.drawable.sadasdsad
            , R.drawable.sfasa, R.drawable.su, R.drawable.sul, R.drawable.sula, R.drawable.sulab, R.drawable.sulabbh, R.drawable.sulabbhin,
            R.drawable.sulabh, R.drawable.sulabhi, R.drawable.sulabbhin, R.drawable.sulabhinterna, R.drawable.sulabhinternat,
            R.drawable.sulabhintre, R.drawable.sulabhintre, R.drawable.sulabhinterna
    };
    GalleryAdapter adapter;


    public Gallery() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_gallery);
        adapter = new GalleryAdapter(getContext(), img);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }

}
