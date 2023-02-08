package com.example.shoppinglistapp;

import static com.example.shoppinglistapp.MyItem.itemList;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityNewItemBinding;

import java.util.ArrayList;

public class NewItem extends AppCompatActivity {

    ActivityNewItemBinding binding;

    private MyItem item;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        Log.d("RRRR", "newItem");

        binding = ActivityNewItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyClickListener listener = new MyClickListener();

        binding.save.setOnClickListener(listener);

    }


    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.save:
                    item = new MyItem(binding.editProductName.getText().toString());
                    itemList.add(item);
                    Log.d("RRRR", "item" + item.toString());
                    Intent intent = new Intent(NewItem.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }

        }
    }
}