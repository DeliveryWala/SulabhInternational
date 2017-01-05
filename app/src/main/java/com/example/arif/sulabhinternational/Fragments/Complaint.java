package com.example.arif.sulabhinternational.Fragments;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arif.sulabhinternational.R;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class Complaint extends Fragment {
    public static final int MEDIA_TYPE_IMAGE = 1;
    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "Sulabh";
    Bitmap photo;
    View view;
    private Button camera, submit;
    private EditText complain, area;
    private TextView location;
    private Uri fileUri; // file url to store image/video

    private ImageView photos;

    public Complaint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_complaint, container, false);

        complain = (EditText) view.findViewById(R.id.complaint_txt);
        area = (EditText) view.findViewById(R.id.complaint_location);

        camera = (Button) view.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                // start the image capture Intent
                startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
            }
        });

        submit = (Button) view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = String.valueOf(complain.getText());
                String loc = String.valueOf(area.getText());

                complain.setText("");
                area.setText("");

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"sulabhinternational14@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Complain");
                email.putExtra(Intent.EXTRA_TEXT, message + "\n Location:" + loc);
                email.putExtra(Intent.EXTRA_STREAM, getImageUri(getContext(), photo));
                email.setType("image/jpeg");

                startActivity(Intent.createChooser(email, "Choose an Email Client:"));
                Toast.makeText(getContext(), "Message sent", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            photos = (ImageView) view.findViewById(R.id.complain_image);

            Uri selectedImage = fileUri;
            getContext().getContentResolver().notifyChange(selectedImage, null);

            ContentResolver contentResolver = getContext().getContentResolver();


            try {
                photo = android.provider.MediaStore.Images.Media
                        .getBitmap(contentResolver, selectedImage);
                photo = (Bitmap) data.getExtras().get("data");
                photos.setImageBitmap(photo);
                Log.e("", "Chal ja bhnchd");

            } catch (Exception e) {

                Log.e("Camera", e.toString());
            }
            //photo = (Bitmap) data.getExtras().get("data");
            //photos.setImageBitmap(photo);
        }

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}