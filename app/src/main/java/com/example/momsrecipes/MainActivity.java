package com.example.momsrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.momsrecipes.Adapters.RecipeAdapter;
import com.example.momsrecipes.Models.Recipe;
import com.example.momsrecipes.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Recipe> list = new ArrayList<>();
//        list.add(new Recipe(R.drawable.dosa,"Masal Dosa"));
//        list.add(new Recipe(R.drawable.idlivada,"Idli Vada"));
//        list.add(new Recipe(R.drawable.paddu,"Paddu"));
//        list.add(new Recipe(R.drawable.ravaidli,"Rava Idli"));
//        list.add(new Recipe(R.drawable.karchikai,"Karchikai"));
//        list.add(new Recipe(R.drawable.huggi,"Huggi"));
//        list.add(new Recipe(R.drawable.hurakki_holige,"Hurakki Holige"));list.add(new Recipe(R.drawable.dosa,"Masal Dosa"));
//        list.add(new Recipe(R.drawable.idlivada,"Idli Vada"));
//        list.add(new Recipe(R.drawable.paddu,"Paddu"));
//        list.add(new Recipe(R.drawable.ravaidli,"Rava Idli"));
//        list.add(new Recipe(R.drawable.karchikai,"Karchikai"));
//        list.add(new Recipe(R.drawable.huggi,"Huggi"));
//        list.add(new Recipe(R.drawable.hurakki_holige,"Hurakki Holige"));list.add(new Recipe(R.drawable.dosa,"Masal Dosa"));
//        list.add(new Recipe(R.drawable.idlivada,"Idli Vada"));
//        list.add(new Recipe(R.drawable.paddu,"Paddu"));
//        list.add(new Recipe(R.drawable.ravaidli,"Rava Idli"));
//        list.add(new Recipe(R.drawable.karchikai,"Karchikai"));
//        list.add(new Recipe(R.drawable.huggi,"Huggi"));
//        list.add(new Recipe(R.drawable.hurakki_holige,"Hurakki Holige"));


        RecipeAdapter adapter = new RecipeAdapter(list,MainActivity.this);
        binding.recyclerView.setAdapter(adapter);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//        binding.recyclerView.setLayoutManager(gridLayoutManager);

        FirebaseDatabase.getInstance().getReference().child("recipes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    Recipe recipe=snapshot1.getValue(Recipe.class);
                    list.add(recipe);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
//        binding.recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

//
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}