package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arif.sulabhinternational.Adapters.MSAdapter;
import com.example.arif.sulabhinternational.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManualScavenging extends Fragment {
   private ExpandableTextView what_ms;
    private String[] ms_name,ms_des,ms_thought;
   private int[] dp={R.drawable.laltananda,R.drawable.usha,R.drawable.sunita,R.drawable.laxmi,R.drawable.pushpa,R.drawable.guddi};
private MSAdapter adapter;
    private RecyclerView recyclerView;

    public ManualScavenging() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_manual_scavenging, container, false);

        what_ms= (ExpandableTextView) view.findViewById(R.id.expand_what_ans);
        what_ms.setText(getResources().getString(R.string.what_ms_ans));

        ms_name=getResources().getStringArray(R.array.alwar_name);
        ms_thought=getResources().getStringArray(R.array.alwar_thought);
        ms_des=getResources().getStringArray(R.array.alwar_des);

        adapter=new MSAdapter(getActivity(),dp,ms_name,ms_thought,ms_des);
        recyclerView= (RecyclerView) view.findViewById(R.id.ms_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
