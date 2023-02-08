package com.example.wasafatyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class TypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_types);

        CircleImageView imgMain, imgPastry, imgSweets, imgDrinks;
        TextView txtMain, txtPastry, txtSweets, txtDrinks;

        imgMain = findViewById(R.id.imgMain);
        imgPastry = findViewById(R.id.imgPastry);
        imgSweets = findViewById(R.id.imgSweets);
        imgDrinks = findViewById(R.id.imgDrinks);
        txtMain = findViewById(R.id.txtMain);
        txtPastry = findViewById(R.id.txtPastry);
        txtSweets = findViewById(R.id.txtSweets);
        txtDrinks = findViewById(R.id.txtDrinks);

        imgMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, MainDishesActivity.class);
                startActivity(i);
            }
        });
        txtMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, MainDishesActivity.class);
                startActivity(i);
            }
        });
        imgPastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, PastryActivity.class);
                startActivity(i);
            }
        });
        txtPastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, PastryActivity.class);
                startActivity(i);
            }
        });
        imgSweets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, SweetsActivity.class);
                startActivity(i);
            }
        });
        txtSweets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, SweetsActivity.class);
                startActivity(i);
            }
        });
        imgDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, DrinksActivity.class);
                startActivity(i);
            }
        });
        txtDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypesActivity.this, DrinksActivity.class);
                startActivity(i);
            }
        });

    }
}