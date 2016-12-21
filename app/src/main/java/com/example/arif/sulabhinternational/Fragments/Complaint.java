package com.example.arif.sulabhinternational.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arif.sulabhinternational.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Complaint extends Fragment {
    private Button camera,gps;
    private TextView location;
    private ImageView photo;
    private Bitmap image;
    final int CAMERA_REQUEST_CODE=1;


    public Complaint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_complaint, container, false);
        camera= (Button) view.findViewById(R.id.camera);
        photo= (ImageView) view.findViewById(R.id.complain_image);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1888);
            }
        });
        return view;
    }
}
