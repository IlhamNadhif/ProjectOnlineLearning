package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageview;
    TextView tittle, description;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageview = findViewById(R.id.mainImageView);
        tittle = findViewById(R.id.tittle);
        description = findViewById(R.id.description);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("description")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("description");
            myImage = getIntent().getIntExtra("myImage", 1);

        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        tittle.setText(data1);
        description.setText(data2);
        mainImageview.setImageResource(myImage);
    }
}