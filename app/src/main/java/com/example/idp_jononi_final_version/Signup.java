package com.example.idp_jononi_final_version;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;



public class Signup extends AppCompatActivity {
    Button signUp;
    EditText fullname,spousename,email,password,condate, dof, height, emergency;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
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
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            finish();

        }
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn= fullname.getText().toString();
                String pw= password.getText().toString().trim();
                String sn= spousename.getText().toString();
                String em= email.getText().toString().trim();
                String df= dof.getText().toString();
                String ht= height.getText().toString();
                String emr= emergency.getText().toString();
                String cd= condate.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]+";
                Pattern pattern = Pattern.compile(emailPattern);
                Matcher matcher = pattern.matcher(em);
                if (TextUtils.isEmpty(em)){
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pw)){
                    password.setError("Password is required");
                    return;
                }
                if(pw.length()<6){
                    password.setError("The password must be 6 charecters long");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(em, pw)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = fAuth.getCurrentUser();
                                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                                Toast.makeText(Signup.this,"A verification email has been sent.",Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Signup.this,"verification failed due to : "+e.getMessage(),Toast.LENGTH_SHORT).show();

                                        }
                                    });



                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Signup.this, "Authentication Successfull.",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity2.class));

                                } else {
                                    // If sign in fails, display a message to the user
                                    Toast.makeText(Signup.this, "Error !"+ task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


//                backup bk=new backup(fn,sn,em,pw,cd,df,ht,emr);
//                reference.setValue(bk);
//                Toast.makeText(Signup.this, "Signup is successful. Your account has been created", Toast.LENGTH_SHORT).show();
//
//                Intent intent=new Intent(Signup.this, MainActivity.class);
//                startActivity(intent);
            }


        });



    }
}