package com.sahrilhasan10gmail.cakerjo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewKampusAdapter extends RecyclerView.Adapter<CardViewKampusAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Kampus> listKampus;
    DataHelper dbHelper;

    public CardViewKampusAdapter(Context context, ArrayList<Kampus> listKampus) {
        this.context = context;
        this.listKampus = listKampus;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_kampus, viewGroup, false);
        return new CardViewViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewKampusAdapter.CardViewViewHolder cardViewViewHolder , int i) {
        dbHelper = new DataHelper(context);

        Kampus kampus = listKampus.get(i);
        final String photo = listKampus.get(i).getPhoto();
        final String name = listKampus.get(i).getName();
        final String deskripsi = listKampus.get(i).getFrom();
        final String lat = listKampus.get(i).getLat();
        final String ling = listKampus.get(i).getLing();
        final String id = listKampus.get(i).getId();
        Glide.with(context)
                .load(kampus.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(kampus.getName());
        cardViewViewHolder.tvFrom.setText(kampus.getFrom());

        cardViewViewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailKampus.class);
                intent.putExtra("PHOTO",photo);
                intent.putExtra("name",name);
                intent.putExtra("deskripsi",deskripsi);
                intent.putExtra("lat",lat);
                intent.putExtra("ling",ling);

                context.startActivity(intent);

                Log.d("desk", deskripsi);
            }
        });

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kampus(no, nama, deskripsi, foto, lat, ling, fav) values('" +
                        id+ "','" +
                        name+ "','" +
                        deskripsi + "','" +
                        photo + "','" +
                        lat + "','" +
                        ling + "','" +
                        "ya" + "')");
                Toast.makeText(context, "Berhasil", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }
        }));

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM kampus WHERE no = "+id+"",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            if (cursor.getString(6).toString().equals("ya")){
                Log.d("fav id:", cursor.getString(6).toString());
                cardViewViewHolder.btnFavorite.setVisibility(View.INVISIBLE);

            }
        }
            }


    @Override
    public int getItemCount() {
        return listKampus.size();
    }

class CardViewViewHolder extends RecyclerView.ViewHolder {
    ImageView imgPhoto;
    TextView tvName, tvFrom;
    Button btnFavorite, btnShare;

    CardViewViewHolder(View itemView) {
        super(itemView);
        imgPhoto = itemView.findViewById(R.id.img_item_photo);
        tvName = itemView.findViewById(R.id.tv_item_name);
        tvFrom = itemView.findViewById(R.id.tv_item_from);
        btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
        btnShare = itemView.findViewById(R.id.btn_set_share);
    }
}
    void setFilter(ArrayList<Kampus> filterList){

        Log.d("name", filterList.toString());
        listKampus = new ArrayList<>();
        listKampus.addAll(filterList);
        notifyDataSetChanged();
    }
}
