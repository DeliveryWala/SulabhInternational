package com.example.arif.sulabhinternational.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.arif.sulabhinternational.Activities.MainActivity;
import com.example.arif.sulabhinternational.Activities.MapActivity;
import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Locate extends Fragment {
    private Button getGPS;


    public Locate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_locate, container, false);
        getGPS= (Button) view.findViewById(R.id.getgps);
        getGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapActivity.class));
            }
        });


        return view;
    }

}
