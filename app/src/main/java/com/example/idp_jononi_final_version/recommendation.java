package com.example.idp_jononi_final_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

public class recommendation extends AppCompatActivity {
    ImageView back6,person;
    FirebaseAuth fAuth;
    TextView temp;
    TextView bs;
    TextView bp;
//    TextView bmi_me;
    TextView recommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        back6=findViewById(R.id.backbutton);
        person=findViewById(R.id.imageperson);
        temp=findViewById(R.id.temp_r);
//        bmi_me=findViewById(R.id.bmi_r);
        bs = findViewById(R.id.bs_r);
        bp = findViewById(R.id.bp_r);
        recommendation = findViewById(R.id.recom_r);
        fAuth=FirebaseAuth.getInstance();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("mother0/Sensor Data/temperature");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temperature = dataSnapshot.getValue(String.class);
                int t=Integer.parseInt(temperature);
                t=Math.round(((t * 9)/5)+32);
                String temper="\n  Body \n Temperature \n"+t+"\u00B0 F";
                if (t<95){
                    temper="\n Your Body \n Temperature is \n too low \n please seek help";
                }
                else if (t>103){
                    temper="\n Your Body \n Temperature is \n too high \n please seek help";
                }
                else if (t>101 && t<103)
                {
                    temper="\n You have \n mild fever \n please take rest \n and medication properly";
                }
                else
                {
                    temper="\n Your Body \n Temperature is \n normal";
                }
                temp.setText(temper);
                Log.d("temperature", "Value is: " + t);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });
        DatabaseReference myRef1 = database.getReference("mother0/Sensor Data/pulse rate");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String blood_pressure = dataSnapshot.getValue(String.class);
                int p=Integer.parseInt(blood_pressure);
                String b_p="\n  Pulse \n Rate \n"+ blood_pressure +"bpm";
                if (p>100)
                {
                    b_p="\n Your pulse \n rate is \n too high \n please seek help";
                }
                else if (p>60)
                {
                    b_p="\n Your pulse \n rate is \n too low \n please seek help";
                }
                else
                {
                    b_p="\n Your pulse \n rate is \n normal";
                }
                bp.setText(b_p);
                Log.d("blood_pressure", "Value is: " + p );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });

        DatabaseReference myRef2 = database.getReference("App Value/Blood Sugar");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String blood_sugar = dataSnapshot.getValue(String.class);
                float s=Float.parseFloat(blood_sugar);
                String b_s="\n  Blood \n  Sugar \n"+ blood_sugar;
                if (s>100)
                {
                    b_s="\n Your blood sugar \n is too high \n please seek help";
                }
                else if (s>60)
                {
                    b_s="\n Your blood sugar \n  is \n too low \n please seek help";
                }
                else
                {
                    b_s="\n Your blood sugar \n  is normal";
                }
                bs.setText(b_s);
                Log.d("blood sugar", "Value is: " + blood_sugar );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });

//        DatabaseReference myRef3 = database.getReference("App Value/Bmi");
//        myRef3.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String bmi_val = dataSnapshot.getValue(String.class);
//                String bmi="a";
//                float b= Float.parseFloat(bmi_val);
//                String bm_i="\n  BMI \n \n"+ Math.round(b);
//                if (b>100)
//                {
//                    bm_i="\n Your pulse \n rate is \n too high \n please seek help";
//                }
//                else if (b>60)
//                {
//                    bm_i="\n Your pulse \n rate is \n too low \n please seek help";
//                }
//                else
//                {
//                    bm_i="\n Your pulse \n rate is \n normal";
//                }
//                bmi_me.setText(bm_i);
//                Log.d("YOUR bmi is", "Value is: " + bmi_val );
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Failed to read value
//                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
//            }
//        });

        DatabaseReference myRef4 = database.getReference("mother0/Sensor Data/Risk Level");
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String bmi_val = dataSnapshot.getValue(String.class);
                char bm=bmi_val.charAt(1);
                int b=Integer.parseInt(String.valueOf(bm));
                String b_mi="\n  BMI \n \n"+ bmi_val;
                if (b==2){
                    b_mi="You have a high level of risk \n your close contacts are informed\n of the situation please take necessary actions";
                }
                else if (b==1){
                    b_mi="You have a mid level of risk \n please take rest \n and necessary medications";
                }
                else if (b==0){
                    b_mi="Your heath is \n normal";
                }
                recommendation.setText(b_mi);
                System.out.println("amar risk:"+b);
                Log.d("YOUR bmi is", "Value is: " + bmi_val );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("YOUR LOG TAG", "Failed to read value.", error.toException());
            }
        });

        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recommendation.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(recommendation.this, profilepage.class);
                startActivity(intent);
            }

        });
    }
}