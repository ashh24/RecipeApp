package com.example.momsrecipes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momsrecipes.Models.Recipe;
import com.example.momsrecipes.R;
import com.example.momsrecipes.ReadRecipeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdapter  extends RecyclerView.Adapter<RecipeAdapter.viewHolder>{

    ArrayList<Recipe> list;
    Context context;

    public RecipeAdapter(ArrayList<Recipe> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recipes,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Recipe recipe = list.get(position);
       // holder.recipeImage.setImageResource(recipe.getImage());

        Picasso.get()
                .load(recipe.getImage())
                .into(holder.recipeImage);
        holder.recipeText.setText(recipe.getRecipeName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReadRecipeActivity.class);
                intent.putExtra("url",recipe.getUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView recipeImage;
        TextView recipeText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.imageView);
            recipeText = itemView.findViewById(R.id.textView);
        }
    }
}
