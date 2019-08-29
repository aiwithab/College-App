package com.aiwithab.collegeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    EditText etUserEmail,etUserPass;
    Button btnLogin,btnGuest;
    TextView tvForgetPass,tvCreateAcc;



    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserEmail=findViewById(R.id.etUserEmail);
        etUserPass=findViewById(R.id.etUserPass);
        tvForgetPass=findViewById(R.id.tvForgetPass);
        tvCreateAcc=findViewById(R.id.tvCreateAcc);
        btnLogin=findViewById(R.id.btnLogin);
        btnGuest=findViewById(R.id.btnGuest);


        dialog = new ProgressDialog(this);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUserEmail.getText().toString().trim();
                String pass = etUserPass.getText().toString().trim();
                if(email.isEmpty()||pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("admin")||pass.equals("admin")){
                    dialog.setMessage("Signing in..please wait..");
                    dialog.show();
                    startActivity(new Intent(MainActivity.this,HomeScreenActivity.class));
                    finish();




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
