package com.example.shoppinglistapp;

import static com.example.shoppinglistapp.NewItem.itemList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityMainBinding binding;


    private ItemAdapter itemAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent1 = getIntent();


        binding.add.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItem.class);
            startActivity(intent);
        });

        binding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        binding.recycler.setAdapter(new ItemAdapter(itemList));

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.wtf("RRRR", String.valueOf(position));
        Intent intent1 = new Intent(MainActivity.this, EditProduct.class);
        intent1.putExtra("name", itemList.get(position).getProductName());
        intent1.putExtra("pos", position);
        Log.d("RRRR", "startIntent");
        Log.d("RRRR", String.valueOf(position));
        startActivity(intent1);
    }
}