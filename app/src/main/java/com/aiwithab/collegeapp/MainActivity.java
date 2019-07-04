package com.aiwithab.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUserName,etUserPass;
    Button btnLogin,btnGuest;
    TextView tvForgetPass,tvCreateAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.etUserName);
        etUserPass=findViewById(R.id.etUserPass);
        tvForgetPass=findViewById(R.id.tvForgetPass);
        tvCreateAcc=findViewById(R.id.tvCreateAcc);
        btnLogin=findViewById(R.id.btnLogin);
        btnGuest=findViewById(R.id.btnGuest);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etUserPass.getText().toString().equals("admin") && etUserName.getText().toString().equals("123")){
                        startActivity(new Intent(MainActivity.this,HomeScreenActivity.class));

                }
                if (!(etUserPass.getText().toString().equals("admin") && etUserName.getText().toString().equals("123"))){
                    Toast.makeText(MainActivity.this,"Invalid Credentials!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        tvCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CreateAccActivity.class));

            }
        });

    }

}
