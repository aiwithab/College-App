package com.aiwithab.collegeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateAccActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etFirstName,etLastName,etRollNo,etPass,etConfirmPass;
    TextView tvBranches,tvYear;
    Button btnSignUp;
    Spinner sBranches,sYear;

    List<String> branches;
    List<String> year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
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

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    //here we'll send the data to server


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
