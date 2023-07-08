package com.example.newsz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adaptor(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adaptor.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, webView.class);
            intent.putExtra("url", modelClassArrayList.get(holder.getAdapterPosition()).getUrl());
            context.startActivity(intent);
        });
        holder.mtime.setText(modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);


    }


    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading, mcontent, mauthor, mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mauthor = itemView.findViewById(R.id.author);
            mcontent=itemView.findViewById(R.id.content);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imgview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
