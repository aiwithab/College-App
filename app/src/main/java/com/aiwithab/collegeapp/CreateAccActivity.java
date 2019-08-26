package com.aiwithab.collegeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class CreateAccActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etFirstName,etRollNo,etPass,etConfirmPass,etEmail;
    TextView tvBranches,tvYear;
    Button btnSignUp;
    Spinner sBranches,sYear;

    List<String> branches;
    List<String> year;

    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        etFirstName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEMail);
        etRollNo=findViewById(R.id.etRollNo);
        etPass=findViewById(R.id.etPass);
        etConfirmPass=findViewById(R.id.etConfirmPass);

        tvBranches=findViewById(R.id.tvBranches);
        tvYear=findViewById(R.id.tvYear);

        btnSignUp=findViewById(R.id.btnSignUp);

        sBranches=findViewById(R.id.sBranches);
        sYear=findViewById(R.id.sYear);

        branches=new ArrayList<>();
        year=new ArrayList<>();

        sBranches.setOnItemSelectedListener(this);
        branches.add("Automobile");
        branches.add("Civil");
        branches.add("Mechanical");
        branches.add("Computer");
        branches.add("EnTC");
        branches.add("Instrumentation");

        ArrayAdapter<String> branchAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,branches);
        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBranches.setAdapter(branchAdapter);

        sYear.setOnItemSelectedListener(this);
        year.add("F.E");
        year.add("S.E");
        year.add("T.E");
        year.add("B.E");

        ArrayAdapter<String> yearAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,year);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sYear.setAdapter(yearAdapter);

        progressDialog=new ProgressDialog(this);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity(new Intent(CreateAccActivity.this,HomeScreenActivity.class));
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String pass = etPass.getText().toString().trim();

                if(email.isEmpty()|| pass.isEmpty()){
                    Toast.makeText(CreateAccActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(etConfirmPass.getText().toString().trim())) {
                        progressDialog.setMessage("Registering you..please wait..");
                        progressDialog.show();
                        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(CreateAccActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(CreateAccActivity.this, "Email registered successfully!", Toast.LENGTH_SHORT).show();
                                    CreateAccActivity.this.finish();
                                }
                                else{
                                    Toast.makeText(CreateAccActivity.this, "Error: "+task.getException(), Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                        }
                        });
                    }
                }







            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}
