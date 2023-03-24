package com.example.idp_jononi_final_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BMI_input extends AppCompatActivity {
    Button submit;
    ImageView back,person;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_input);
        submit=findViewById(R.id.weight);
        back=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI_input.this, BMI.class);
                startActivity(intent);
            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI_input.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI_input.this, profilepage.class);
                startActivity(intent);
            }

        });



    }
}