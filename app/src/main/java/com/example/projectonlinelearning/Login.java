package com.example.projectonlinelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText user,pass;
    Button btnmasuk,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref= getSharedPreferences("login", MODE_PRIVATE);
        user = findViewById(R.id.txtusername);
        pass = findViewById(R.id.txtpassword);
        btnmasuk = findViewById(R.id.btnlogin);


        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().isEmpty() && pass.getText().toString().isEmpty()){
                    pass.setError("tidak boleh kosong !");
                    user.setError("tidak boleh kosong !");
                }else if (user.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    if (pass.getText().toString().isEmpty()){
                        pass.setError("tidak boleh kosong !");
                    }else if (user.getText().toString().isEmpty()) {
                        user.setError("tidak boleh kosong !");
                    }
                }else {
                    //Saving ke SharedPreference
                    editor = pref.edit();
                    editor.putString("username", user.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();;
                    //menuju ke activity yang dituju

                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
    public void viewRegisterClicked(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}