package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arif.sulabhinternational.Adapters.SuccessAdapter;
import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Stories extends Fragment {
    private RecyclerView recycler;
    private SuccessAdapter adapter;

    int[] images={R.drawable.sulabhyellow,R.drawable.sulabhred,R.drawable.sulabhblue,R.drawable.sulabhgreen,R.drawable.sulabhnavy,
            R.drawable.sulabhtoilet,R.drawable.sulabhorange,R.drawable.sulabhtwo,R.drawable.sulabhduckwed,R.drawable.sulabhcomposting,
            R.drawable.sulabhgoing};


    public Stories() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stories, container, false);

        String[] successHead=getResources().getStringArray(R.array.success_head);
        String[] successDetail=getResources().getStringArray(R.array.success_stories);

        adapter=new SuccessAdapter(getActivity(),images,successHead,successDetail);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_success);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);

        return view;
    }

}
