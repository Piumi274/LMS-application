package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CardView CardLMaterials,CardExamMarks,CardLSchedules,CardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardLMaterials = (CardView )findViewById(R.id.CardLMaterials);
        CardExamMarks = (CardView )findViewById(R.id.CardExamMarks);
        CardLSchedules = (CardView )findViewById(R.id.CardLSchedules);
        CardLogout = (CardView )findViewById(R.id.CardLogout);

        CardLMaterials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ShowLecMaterialActivity.class);
                startActivity(intent);
            }
        });
        CardExamMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ShowExamMarksActivity.class);
                startActivity(intent);
            }
        });

        CardLSchedules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ShowScheduleActiviy.class);
                startActivity(intent);
            }
        });

        CardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}