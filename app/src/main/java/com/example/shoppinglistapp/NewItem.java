package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityNewItemBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewItem extends AppCompatActivity {

    ActivityNewItemBinding binding;
    public static final List<MyItem> itemList = new ArrayList<>();
    private MyItem item;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        binding = ActivityNewItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyClickListener listener = new MyClickListener();

        binding.save.setOnClickListener(listener);

    }


    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add:
                    finish();
                    break;
                case R.id.save:
                    item = new MyItem(binding.editProductName.getText().toString());
                    itemList.add(item);
                    Intent intent = new Intent(NewItem.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}