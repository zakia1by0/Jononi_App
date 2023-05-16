package com.example.idp_jononi_final_version;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Bloodpressure extends AppCompatActivity {
    ImageView back3,person;
    TextView bppp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodpressure);
        back3=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);
        bppp=findViewById(R.id.bppp);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("bp");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temperature = dataSnapshot.getValue(String.class);
                String temper="your Blood Pressure is "+temperature+" mmHg";
                bppp.setText(temper);
                Log.d("YOUR SUCCESS LOG TAG", "Value is: " + temperature);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bloodpressure.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bloodpressure.this, profilepage.class);
                startActivity(intent);
            }

        });

    }
}