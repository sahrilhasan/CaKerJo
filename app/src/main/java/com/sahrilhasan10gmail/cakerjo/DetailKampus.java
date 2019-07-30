package com.sahrilhasan10gmail.cakerjo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailKampus extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    String photo;
    String nama;
    String deskripsi;
    String ratingkampus;


    TextView namakampus;
    TextView rating;
    TextView penjelasan;

    ImageView photoIkan;
    Button button;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_kampus_ugm);
//
        namakampus=findViewById(R.id.namakampus);
        photoIkan=findViewById(R.id.fotoikandetail);
        penjelasan=findViewById(R.id.penjelasankampus);
        rating=findViewById(R.id.rating);
      //  button=findViewById(R.id.btn_menujulokasi);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        photo= getIntent().getStringExtra("PHOTO");
        nama= getIntent().getStringExtra("name");
        ratingkampus = getIntent().getStringExtra("rating");
        deskripsi= getIntent().getStringExtra("deskripsi");





//
        Log.d("PHOTO", photo);

        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().override(350, 550))
                .into(photoIkan);

        penjelasan.setText(deskripsi);
        namakampus.setText(nama);
        rating.setText(ratingkampus);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Kampus");
        }
        final String lat = getIntent().getStringExtra("lat");
        final String ling = getIntent().getStringExtra("ling");

        Log.d("lat",lat+"ling"+ling);

//        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(DetailKampus.this, MapsActivity.class);
////                intent.putExtra("lat",lat);
////                intent.putExtra("ling",ling);
////
////                startActivity(intent);
////            }
////        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(Double.parseDouble(getIntent().getStringExtra("lat")),
                Double.parseDouble(getIntent().getStringExtra("ling")));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        mMap.addMarker(new MarkerOptions().position(sydney).title(getIntent().getStringExtra("name")));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
