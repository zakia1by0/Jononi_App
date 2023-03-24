package com.example.idp_jononi_final_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SOS_confirmed extends AppCompatActivity {
    ImageView back,person;
    Button confirmed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_confirmed);
        back=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);
        confirmed=findViewById(R.id.confirmed);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SOS_confirmed.this, SOS.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SOS_confirmed.this, profilepage.class);
                startActivity(intent);
            }

        });
        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SOS_confirmed.this, MainActivity2.class);
                startActivity(intent);
            }

        });

    }
}