package com.sahrilhasan10gmail.cakerjo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class KampusFav extends AppCompatActivity {

    private RecyclerView rvKampus;
    private ArrayList<Kampus> list = new ArrayList<>();
    ListKampusAdapter listKampusAdapter;



    protected Cursor cursor;
    DataHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus_fav);

        rvKampus = findViewById(R.id.rvfav);
        DataHelper db = new DataHelper(this);

        list.addAll(db.allKampus());
        showRecyclerlistView();
    }
    private void showRecyclerlistView() {
        rvKampus.setLayoutManager(new LinearLayoutManager(this));
        listKampusAdapter = new ListKampusAdapter(list);
        rvKampus.setAdapter(listKampusAdapter);
    }
}
