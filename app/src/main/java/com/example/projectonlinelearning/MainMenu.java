package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    CardView action;
    CardView horor;
    CardView comedy;
    CardView drama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        action = (CardView)findViewById(R.id.action);
        horor = (CardView)findViewById(R.id.horor);
        comedy = (CardView)findViewById(R.id.comedy);
        drama = (CardView)findViewById(R.id.drama);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListData.class));
            }
        });
    }
}