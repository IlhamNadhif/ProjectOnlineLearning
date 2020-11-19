package com.example.projectonlinelearning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListDataFavourite extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;
    private RecyclerView recyclerView;
    private DataAdapterFavourite adapter;
    private List<ModelMovieRealm> DataArrayList; //kit add kan ke adapter
    TextView tvnodata;

    //private ProgressBar PrgrsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_data);

        tvnodata = (TextView) findViewById(R.id.tvnodata);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        DataArrayList = new ArrayList<>();

        //PrgrsBar = (ProgressBar) findViewById(R.id.progresBar);
        //PrgrsBar.setVisibility(View.INVISIBLE);


        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        DataArrayList = realmHelper.getAllMahasiswa();

        if (DataArrayList.size() == 0){
            tvnodata.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            tvnodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new DataAdapterFavourite(DataArrayList, new DataAdapterFavourite.Callback() {
                @Override
                public void onClick(int position) {
                    //intent ke detail movie
                    Intent move = new Intent(getApplicationContext(), DetailFavourite.class);
                    move.putExtra("title",DataArrayList.get(position).getJudul());
                    // picture, desc, release, dll
                    move.putExtra("judul",DataArrayList.get(position).getJudul());
                    move.putExtra("path",DataArrayList.get(position).getPath());
                    move.putExtra("date",DataArrayList.get(position).getReleaseDate());
                    move.putExtra("deskripsi",DataArrayList.get(position).getDesc());

                    startActivity(move);
                }

                @Override
                public void test() {

                }
            });
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListDataFavourite.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }


    }

//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case 1:
//                //Do stuff
//                displayMassage("halo");
//                return true;
//
//            case 2:
//                //Do stuff
//                displayMassage("halo..");
//                adapter.RemoveItem(item.getGroupId());
//                return true;
//
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
//
//    private void displayMassage(String massage){
//        Snackbar.make(findViewById(R.id.rootId), massage, Snackbar.LENGTH_SHORT).show();
//    }


}