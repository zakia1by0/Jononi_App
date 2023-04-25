package com.example.idp_jononi_final_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class status_page extends AppCompatActivity {
    ImageView back6,person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_page);
        back6=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);
        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(status_page.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(status_page.this, profilepage.class);
                startActivity(intent);
            }

        });
    }
}