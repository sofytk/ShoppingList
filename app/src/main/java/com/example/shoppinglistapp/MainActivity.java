package com.example.shoppinglistapp;


import static com.example.shoppinglistapp.MyItem.itemList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACTION_IMAGE_CAPTURE_REQUEST_CODE = 1;
    ActivityMainBinding binding;

    private ItemAdapter itemAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        itemAdapter = new ItemAdapter(itemList, MainActivity.this);

        binding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.recycler.setAdapter(itemAdapter);

        binding.add.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItem.class);
            startActivity(intent);
        });

        updateList();

        binding.scan.setOnClickListener(view -> {
            Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(photoPickerIntent, ACTION_IMAGE_CAPTURE_REQUEST_CODE);
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent image) {
        super.onActivityResult(requestCode, resultCode, image);

        switch (requestCode) {
            case ACTION_IMAGE_CAPTURE_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap photo = (Bitmap) image.getExtras().get("data");
                    Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
                    intent.putExtra("photo", photo);
                    startActivity(intent);
                    Log.v("RRRR", "Load image");
                }
        }
    }


    private void updateList() {
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