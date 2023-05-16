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

public class Babykickcount extends AppCompatActivity {
    ImageView back2,person;
    TextView ttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babykickcount);
        back2=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);
        ttt = findViewById(R.id.ttt);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("temp");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temperature = dataSnapshot.getValue(String.class);
                String temper="your Body Temperature is "+temperature+"\u00B0 F";
                ttt.setText(temper);
                Log.d("YOUR SUCCESS LOG TAG", "Value is: " + temperature);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Babykickcount.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Babykickcount.this, profilepage.class);
                startActivity(intent);
            }

        });


    }
}