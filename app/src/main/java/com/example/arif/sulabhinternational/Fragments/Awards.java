package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arif.sulabhinternational.Adapters.AwardAdapter;
import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Awards extends Fragment {
    String[] awardDetail,awarDate,no;
    private RecyclerView recycler;
    private AwardAdapter adapter;


    public Awards() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_awards, container, false);
        awardDetail=getResources().getStringArray(R.array.awards);
        awarDate=getResources().getStringArray(R.array.award_date);
        no=getResources().getStringArray(R.array.award_no);
        int len=awarDate.length;

        recycler= (RecyclerView) view.findViewById(R.id.award_recycler);
        adapter=new AwardAdapter(getContext(),no,awardDetail,awarDate);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);


        return view;
    }

}
