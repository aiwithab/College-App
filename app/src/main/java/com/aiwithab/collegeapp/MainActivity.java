package com.aiwithab.collegeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    EditText etUserEmail,etUserPass;
    Button btnLogin,btnGuest;
    TextView tvForgetPass,tvCreateAcc;


    FirebaseAuth firebaseAuth;

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
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this,HomeScreenActivity.class));

        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUserEmail.getText().toString().trim();
                String pass = etUserPass.getText().toString().trim();
                if(email.isEmpty()||pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    dialog.setMessage("Signing in..please wait..");
                    dialog.show();
                    firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(MainActivity.this,HomeScreenActivity.class));
                                Toast.makeText(MainActivity.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                                MainActivity.this.finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Error: "+task.getException(), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });
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
