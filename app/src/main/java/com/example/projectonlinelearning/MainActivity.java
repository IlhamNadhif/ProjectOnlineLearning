package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[];
    int images[] = {R.drawable.gudeg, R.drawable.keraktelor, R.drawable.sotokudus, R.drawable.lumpia,
            R.drawable.lentog, R.drawable.kerupuktengiri, R.drawable.jenang, R.drawable.mieaceh,
            R.drawable.ayambetutu};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.NamaMakanan);
        s2 = getResources().getStringArray(R.array.Asal);
        s3 = getResources().getStringArray(R.array.Deskripsi);


        RVadaptor rVadaptor = new RVadaptor(this, s1, s2, s3, images);
        recyclerView.setAdapter(rVadaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}