package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText user,pass,email;
    Button btnmasuk;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.txtemailreg);
        user = findViewById(R.id.txtusernamereg);
        pass = findViewById(R.id.txtpasswordreg);
        radioGroup = findViewById(R.id.RadioGroup);
        btnmasuk = findViewById(R.id.btnreg);

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() && user.getText().toString().isEmpty() && pass.getText().toString().isEmpty()){
                    email.setError("Masukkan Email !");
                    user.setError("Masukkan Username !");
                    pass.setError("Masukkan Password !");
                }else if (email.getText().toString().isEmpty() || user.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    if (email.getText().toString().isEmpty()){
                        email.setError("Masukkan Email !");
                    }else if (user.getText().toString().isEmpty()) {
                        user.setError("Masukkan Username !");
                    }else if (pass.getText().toString().isEmpty()) {
                        pass.setError("Masukkan Password !");}
                }else {
                    Intent i = new Intent(Register.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}