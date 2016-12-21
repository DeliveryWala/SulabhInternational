package com.example.arif.sulabhinternational.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arif.sulabhinternational.Adapters.NewsAdapter;
import com.example.arif.sulabhinternational.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    RecyclerView recycler;
    NewsAdapter adapter;
    String[] news_head,news_det,news;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        news_head=getResources().getStringArray(R.array.news_heading);
        news_det=getResources().getStringArray(R.array.news_detail);
        news=getResources().getStringArray(R.array.news);
        recycler= (RecyclerView) view.findViewById(R.id.recycler);
        adapter=new NewsAdapter(getActivity(),news_head,news_det,news);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setNestedScrollingEnabled(false);
        recycler.setAdapter(adapter);



        return  view;
    }

}
