package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shoppinglistapp.databinding.ActivityEditProductBinding;

import java.util.zip.Inflater;

public class EditProduct extends AppCompatActivity {

    ActivityEditProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}