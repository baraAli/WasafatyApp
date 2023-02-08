package com.example.wasafatyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public Context context;
    public ArrayList<DishModel> dishModelArrayList;

    public RecyclerAdapter(Context context, ArrayList<DishModel> dishModelArrayList) {
        this.context = context;
        this.dishModelArrayList = dishModelArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_dish_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        DishModel dishes = dishModelArrayList.get(position);
        holder.textView.setText(dishes.getTitle());
        Glide.with(context)
                .load(dishes.getImgUrl())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent i = new Intent(context, DishDetailsActivity.class);
                       i.putExtra("title", dishes.getTitle());
                       i.putExtra("descr", dishes.getDishDesc());
                       i.putExtra("image", dishes.getImgUrl());
                       i.putExtra("video", dishes.getVideoUrl());
                       i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       context.startActivity(i);
                   }
               }
        );
    }

    @Override
    public int getItemCount() {
        return dishModelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
