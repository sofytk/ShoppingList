package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityPhotoBinding;

public class PhotoActivity extends AppCompatActivity{

    ActivityPhotoBinding binding;
    Bitmap photo;
    private static final int ACTION_IMAGE_CAPTURE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preview();

        binding.canel.setOnClickListener(view ->{
            Intent intent = new Intent(PhotoActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    private void preview() {
        Intent intent = getIntent();
        photo = intent.getParcelableExtra("photo");
        binding.preview.setImageBitmap(photo);
    }


}