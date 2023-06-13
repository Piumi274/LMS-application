package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

import java.security.cert.CertPathBuilder;

public class ShowLecMaterialActivity extends AppCompatActivity {
Button homeBtn,next;
RecyclerView recyclerView;
ImageButton menu;
LecAdapter lecAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lec_material);

        homeBtn= findViewById(R.id.home_btn);
        next= findViewById(R.id.next_btn);
       menu= findViewById(R.id.recycler_View);
        recyclerView= findViewById(R.id.recycler_View);

        homeBtn.setOnClickListener((v)-> startActivity(new Intent(ShowLecMaterialActivity.this,MainActivity.class)));
        next.setOnClickListener((v)-> startActivity(new Intent(ShowLecMaterialActivity.this,MainActivity.class)));
        menu.setOnClickListener((v)->showMenu());
        setUpRecyclerView();
        }

        void showMenu() {
            //Display menu
        }

        void setUpRecyclerView() {
//Firebase data display
            Query query= Utility.getCollectionReferenceForNotes().orderBy("timestamp",Query.Direction.DESCENDING);
            //FirestoreRecyclerOptions<Note> options=new Builder<Note>()
                    //.setQuery(query,Note.class).build();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
//lecAdapter=new LecAdapter(options,this);
recyclerView.setAdapter(lecAdapter);

    }



    private class Builder<T> {
        public CertPathBuilder setQuery(Query query, Class<T> noteClass) {
            return null;
        }


    }

    //display notes


    @Override
    protected void onStart() {
        super.onStart();
        lecAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lecAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
}}