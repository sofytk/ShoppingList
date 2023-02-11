package com.example.shoppinglistapp.activities;

import static com.example.shoppinglistapp.foritem.MyItem.itemList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.shoppinglistapp.databinding.ActivityEditProductBinding;
import com.example.shoppinglistapp.foritem.MyItem;
import com.example.shoppinglistapp.mydb.DBmain;

public class EditProduct extends AppCompatActivity {
    ActivityEditProductBinding binding;
    private int pos;
    MyItem item;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        pos = intent.getIntExtra("pos", pos);
        binding.editProductName.setText(intent.getStringExtra("name"));
        Log.wtf("RRRR", "editstrart" + pos);

        dBmain = new DBmain(this);
        Intent intent1 = new Intent(EditProduct.this, MainActivity.class);

        binding.save.setOnClickListener(view -> {
            sqLiteDatabase = dBmain.getWritableDatabase();
            ContentValues values = new ContentValues();
//            itemList.get(pos).setProductName(binding.editProductName.getText().toString());
//            Log.d("RRRR", "edit");
            values.put("name", binding.editProductName.getText().toString());
            sqLiteDatabase.update("nameProduct", values,
                    "name" + "= ?", new String[]{intent.getStringExtra("name")});
            startActivity(intent1);
        });
        binding.remove.setOnClickListener(view -> {
            sqLiteDatabase = dBmain.getWritableDatabase();
            ContentValues values = new ContentValues();
          // itemList.remove(pos);
            values.put("name", intent.getStringExtra("name"));
            sqLiteDatabase.delete("nameProduct", "name" + "= ?", new String[]{binding.editProductName.getText().toString()});
            Log.d("RRRR", "remove" + pos);
            startActivity(intent1);
        });
    }
}