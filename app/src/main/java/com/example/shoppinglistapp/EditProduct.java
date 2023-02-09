package com.example.shoppinglistapp;

import static com.example.shoppinglistapp.MyItem.itemList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityEditProductBinding;

public class EditProduct extends AppCompatActivity {
    ActivityEditProductBinding binding;
    private int pos;
    MyItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        pos = intent.getIntExtra("pos", pos);
        binding.editProductName1.setText(intent.getStringExtra("name"));
        Log.wtf("RRRR", "editstrart" + pos);


        Intent intent1 = new Intent(EditProduct.this, MainActivity.class);
        binding.save1.setOnClickListener(view -> {
            itemList.get(pos).setProductName(binding.editProductName1.getText().toString());
            Log.d("RRRR", "edit");
            startActivity(intent1);
        });
        binding.remove.setOnClickListener(view -> {
           itemList.remove(pos);
            Log.d("RRRR", "remove" + pos);
            startActivity(intent1);
        });
    }
}