package com.example.wasafatyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PastryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DishModel> dishModelArrayList;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pastry);

        recyclerView = findViewById(R.id.recyclerView);
        ImageView imgBack = findViewById(R.id.imgBack);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);

        dishModelArrayList = new ArrayList<>();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PastryActivity.this, TypesActivity.class);
                startActivity(i);
            }
        });

        clearAll();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("pastry");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearAll();

                for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                    DishModel dishModel = dataSnapshot.getValue(DishModel.class);
                    dishModelArrayList.add(dishModel);
                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), dishModelArrayList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void clearAll(){
        if(dishModelArrayList != null){
            dishModelArrayList.clear();
        }
        if(recyclerAdapter != null){
            recyclerAdapter.notifyDataSetChanged();
        }
    }
}