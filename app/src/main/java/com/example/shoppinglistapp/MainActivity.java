package com.example.shoppinglistapp;

import static com.example.shoppinglistapp.NewItem.itemList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;


    private ItemAdapter itemAdapter;
   // private List<MyItem> itemList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();

        binding.newItemButton.setOnClickListener(this);

        binding.items.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        binding.items.setAdapter(new ItemAdapter(itemList));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_item_button:
                Intent intent = new Intent(MainActivity.this, NewItem.class);
                startActivity(intent);
                break;
            case R.id.save:
                finish();
                break;
        }
    }
}