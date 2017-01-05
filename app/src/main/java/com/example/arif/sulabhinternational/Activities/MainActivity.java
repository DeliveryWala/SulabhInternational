package com.example.arif.sulabhinternational.Activities;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.arif.sulabhinternational.Adapters.ExpandListAdapter;
import com.example.arif.sulabhinternational.Fragments.Awards;
import com.example.arif.sulabhinternational.Fragments.Cleaning;
import com.example.arif.sulabhinternational.Fragments.Complaint;
import com.example.arif.sulabhinternational.Fragments.Contact;
import com.example.arif.sulabhinternational.Fragments.Gallery;
import com.example.arif.sulabhinternational.Fragments.Home;
import com.example.arif.sulabhinternational.Fragments.Locate;
import com.example.arif.sulabhinternational.Fragments.ManualScavenging;
import com.example.arif.sulabhinternational.Fragments.Stories;
import com.example.arif.sulabhinternational.Fragments.Upcoming;
import com.example.arif.sulabhinternational.Fragments.WasteWater;
import com.example.arif.sulabhinternational.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int[] icon = {R.drawable.home, R.drawable.awards, R.drawable.upcoming, R.drawable.complaint,
            R.drawable.locate, R.drawable.gallery, R.drawable.contact};
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ExpandListAdapter adapter;
    private ExpandableListView expandList;
    private View view;
    private List<String> header;
    private HashMap<String, List<String>> child;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandList.setIndicatorBounds(expandList.getRight() - 80, expandList.getWidth());
        } else {
            expandList.setIndicatorBoundsRelative(expandList.getRight() - 80, expandList.getWidth());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                        , Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.INTERNET,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 6);
         Fragment  fragment=new Home();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        expandList = (ExpandableListView) findViewById(R.id.navigationmenu);

        navigationView = (NavigationView) findViewById(R.id.navigation);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandList = (ExpandableListView) findViewById(R.id.navigationmenu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);

        if (navigationView != null) {
            setUpDrawerContent(navigationView);
        }
        prepareList();
        adapter = new ExpandListAdapter(this, header, child);

        // setting list adapter
        expandList.setAdapter(adapter);

        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView,
                                        View view,
                                        int groupPosition,
                                        int childPosition, long id) {
                Fragment fragment;
                android.support.v4.app.FragmentTransaction ft;

                switch (childPosition) {
                    case 0:
                        Log.d("DEBUG", "submenu item clicked" + childPosition);
                        fragment = new Awards();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 1:
                        Log.d("DEBUG", "submenu item clicked" + childPosition);
                        fragment = new Cleaning();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 2:
                        Log.d("DEBUG", "submenu item clicked" + childPosition);
                        fragment = new ManualScavenging();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 3:
                        Log.d("DEBUG", "submenu item clicked" + childPosition);
                        fragment = new Stories();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 4:
                        Log.d("DEBUG", "submenu item clicked" + childPosition);
                        fragment = new WasteWater();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;

                }


                Toast.makeText(MainActivity.this,
                        "Header: " + String.valueOf(groupPosition) +
                                "\nItem: " + String.valueOf(childPosition), Toast.LENGTH_SHORT)
                        .show();
                view.setSelected(false);
                drawerLayout.closeDrawers();
                return false;
            }
        });
        expandList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                android.support.v4.app.Fragment fragment;
                android.support.v4.app.FragmentTransaction ft;
                switch (i) {
                    case 0:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Home();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 1:
                        break;
                    case 2:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Upcoming();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 3:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Complaint();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 4:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Locate();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 5:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Gallery();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 6:
                        Log.d("DEBUG", "submenu item clicked" + i);
                        fragment = new Contact();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                }

                if (i != 1) {
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    public void prepareList() {
        header = new ArrayList<>();
        child = new HashMap<>();

        header.add("Home");
        header.add("Awards and Achievements");
        header.add("Upcoming Projects");
        header.add("Complaint");
        header.add("Locate nearest Sulabh");
        header.add("Gallery");
        header.add("Contact Us");

        List<String> awards = new ArrayList<>();
        awards.add("Awards");
        awards.add("Cleaning of Ghats");
        awards.add("Manual Scavenging");
        awards.add("Success Stories");
        awards.add("Waste Water Treatment Plant");

        child.put(header.get(1), awards);
    }

    private void setUpDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
