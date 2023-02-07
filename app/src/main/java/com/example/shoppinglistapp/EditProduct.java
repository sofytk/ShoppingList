package com.example.shoppinglistapp;

import static com.example.shoppinglistapp.NewItem.itemList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityEditProductBinding;

import java.util.zip.Inflater;

public class EditProduct extends AppCompatActivity   {

    ActivityEditProductBinding binding;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        binding.editProductName.setText(intent.getStringExtra("name"));
        pos = Integer.parseInt(intent.getStringExtra("pos"));

        MyClickListener listener = new MyClickListener();

        binding.save.setOnClickListener(listener);
    }
    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.remove:
                    itemList.remove(pos);
                    Log.d("RRRR", "remove");
                    break;
                case R.id.save:
                    itemList.get(pos).setProductName(binding.editProductName.getText().toString());
                    itemList.notify();
                    Log.d("RRRR", "edit");
                    Intent intent = new Intent(EditProduct.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}