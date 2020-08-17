package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void ClickMakanan(View view) {
        Intent i = new Intent(mainMenu.this, MainActivity.class);
        startActivity(i);

    }
}