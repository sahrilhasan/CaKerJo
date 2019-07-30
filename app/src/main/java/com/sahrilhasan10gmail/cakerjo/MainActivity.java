package com.sahrilhasan10gmail.cakerjo;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvKampus;
    private ArrayList<Kampus> list = new ArrayList<>();
    CardViewKampusAdapter cardViewKampusAdapter;

    FloatingActionButton floatingActionButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKampus = findViewById(R.id.rv_kampus);
        rvKampus.setHasFixedSize(true);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , KampusFav.class);
                startActivity(intent);
            }
        });


        list.addAll(KampusData.getListData());
        showRecyclerCardView();

    }

    private void showRecyclerCardView() {
        rvKampus.setLayoutManager(new LinearLayoutManager(this));
        cardViewKampusAdapter = new CardViewKampusAdapter(this, list);
        rvKampus.setAdapter(cardViewKampusAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                //Data akan berubah saat user menginputkan text/kata kunci pada SearchView
                nextText = nextText.toLowerCase();
                ArrayList<Kampus> dataFilter = new ArrayList<>();
                for(Kampus data : list){
                    String nama = data.getName().toLowerCase();
                    if(nama.contains(nextText)){
                        dataFilter.add(data);
                        Log.d("data: ", nama);
                    }
                }
                cardViewKampusAdapter.setFilter(dataFilter);
                cardViewKampusAdapter.notifyDataSetChanged();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

}
