package com.example.shoppinglistapp;


import static com.example.shoppinglistapp.MyItem.itemList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;


    private ItemAdapter itemAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        itemAdapter = new ItemAdapter(itemList, MainActivity.this);
        binding.recycler.setAdapter(itemAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


        binding.add.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItem.class);
            startActivity(intent);
        });

        updateList();

        binding.scan.setOnClickListener(view -> {
        });
    }

    private void updateList() {
        //itemAdapter.setArrayMyData(mDBConnector.selectAll());
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
            case R.id.remove:
                    finish();
                break;
        }
    }
}