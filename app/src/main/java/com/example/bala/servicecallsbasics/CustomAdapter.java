package com.example.bala.servicecallsbasics;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ImageViewHolder> {
    ArrayList<BasicModel> basicModels = new ArrayList<>();

    public CustomAdapter(ArrayList<BasicModel> basicModels) {
        this.basicModels = basicModels;
    }

    public void addItemsToList(ArrayList<BasicModel> basicModels) {
        this.basicModels.addAll(basicModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.textView.setText(basicModels.get(i).getName());
        ServiceClass.setImageToImageView(imageViewHolder.itemView.getContext(),basicModels.get(i).imgUrl,imageViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return basicModels.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.i_iv_img);
            textView = itemView.findViewById(R.id.i_tv_img);
        }
    }
}
