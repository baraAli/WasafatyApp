package com.example.wasafatyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DishDetailsActivity extends AppCompatActivity {

    String title, desc, imageURL, video_url;
    TextView txtTitle, txtDesc;
    ImageView imgDish;
    Button btnVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dish_details);

        Intent in = getIntent();
        title = in.getStringExtra("title");
        desc = in.getStringExtra("descr");
        imageURL = in.getStringExtra("image");
        video_url = in.getStringExtra("video");

        txtTitle = findViewById(R.id.txtTitle);
        txtDesc = findViewById(R.id.txtDesc);
        imgDish = findViewById(R.id.imgDish);
        btnVideo = findViewById(R.id.btnVideo);

        if(title.contains("السمك")){
            desc = "  المقادير \n" + Descriptions.contents[0] + " \n \n خطوات التحضير \n" + Descriptions.steps[0];
        }else if(title.contains("بامية")){
            desc = "  المقادير \n" + Descriptions.contents[1] + " \n \n خطوات التحضير \n" + Descriptions.steps[1];
        }else if(title.contains("بيض")){
            desc = "  المقادير \n" + Descriptions.contents[2] + " \n \n خطوات التحضير \n" + Descriptions.steps[2];
        }else if(title.contains("كشري")){
            desc = "  المقادير \n" + Descriptions.contents[3] + " \n \n خطوات التحضير \n" + Descriptions.steps[3];
        }else if(title.contains("بيتزاء")){
            desc = "  المقادير \n" + Descriptions.contents[4] + " \n \n خطوات التحضير \n" + Descriptions.steps[4];
        }else if(title.contains("كوكيز")){
            desc = "  المقادير \n" + Descriptions.contents[5] + " \n \n خطوات التحضير \n" + Descriptions.steps[5];
        }else if(title.contains("سفنجية")){
            desc = "  المقادير \n" + Descriptions.contents[6] + " \n \n خطوات التحضير \n" + Descriptions.steps[6];
        }else if(title.contains("ساخنة")){
            desc = "  المقادير \n" + Descriptions.contents[7] + " \n \n خطوات التحضير \n" + Descriptions.steps[7];
        }else if(title.contains("الافوكادو")){
            desc = "  المقادير \n" + Descriptions.contents[8] + " \n \n خطوات التحضير \n" + Descriptions.steps[8];
        }else if(title.contains("الموهيتو")){
            desc = "  المقادير \n" + Descriptions.contents[9] + " \n \n خطوات التحضير \n" + Descriptions.steps[9];
        }else if(title.contains("نسكافية")){
            desc = "  المقادير \n" + Descriptions.contents[10] + " \n \n خطوات التحضير \n" + Descriptions.steps[10];
        }else if(title.contains("براونيز")){
            desc = "  المقادير \n" + Descriptions.contents[11] + " \n \n خطوات التحضير \n" + Descriptions.steps[11];
        }else if(title.contains("بسبوسة")){
            desc = "  المقادير \n" + Descriptions.contents[12] + " \n \n خطوات التحضير \n" + Descriptions.steps[12];
        }

        txtTitle.setText(title);
        txtDesc.setText(desc);
        Glide.with(getApplicationContext())
                .load(imageURL)
                .into(imgDish);

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(video_url));
                startActivity(i);
            }
        });
    }
}