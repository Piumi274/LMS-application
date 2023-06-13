package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lecture_studentActivity extends AppCompatActivity {

    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_student);
        //Lecture or Student button click
        button = (Button)findViewById(R.id.button_1id);
        button2 = (Button)findViewById(R.id.button_2id);

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(Lecture_studentActivity.this,MainActivity.class);
              startActivity(intent);

          }
      });

      button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(Lecture_studentActivity.this,MainActivity.class);
              startActivity(intent);
          }
      });
    }
}