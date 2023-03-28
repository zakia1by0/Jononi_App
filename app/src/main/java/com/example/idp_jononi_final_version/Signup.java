package com.example.idp_jononi_final_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    Button signUp;
    EditText fullname,spousename,email,password,condate, dof, height, emergency;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullname=findViewById(R.id.fullname);
        spousename=findViewById(R.id.spousename);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        condate=findViewById(R.id.condate);
        dof=findViewById(R.id.dof);
        height=findViewById(R.id.height);
        emergency=findViewById(R.id.emergency);
        signUp= findViewById(R.id.signin);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database= FirebaseDatabase.getInstance();
                reference =database.getReference();
                String fn= fullname.getText().toString();
                String pw= password.getText().toString();
                String sn= spousename.getText().toString();
                String em= email.getText().toString();
                String df= dof.getText().toString();
                String ht= height.getText().toString();
                String emr= emergency.getText().toString();
                String cd= condate.getText().toString();


                backup bk=new backup(fn,pw,sn,em,df,ht,emr,cd);
                reference.setValue(bk);
                Toast.makeText(Signup.this, "Signup is successful. Your account has been created", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }


        });



    }
}