package com.example.shoppinglistapp.activities;

import static com.example.shoppinglistapp.foritem.MyItem.itemList;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.databinding.ActivityNewItemBinding;
import com.example.shoppinglistapp.foritem.MyItem;
import com.example.shoppinglistapp.mydb.DBmain;

public class NewItem extends AppCompatActivity {

    ActivityNewItemBinding binding;

//    private MyItem item;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_item);
//        Log.d("RRRR", "newItem");
//
//        binding = ActivityNewItemBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        MyClickListener listener = new MyClickListener();
//
//        binding.save.setOnClickListener(listener);
//
//    }
//
//
//    class MyClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.save:
//                    item = new MyItem(binding.editProductName.getText().toString());
//                    itemList.add(item);
//                    Log.d("RRRR", "item" + item.toString());
//                    Intent intent = new Intent(NewItem.this, MainActivity.class);
//                    startActivity(intent);
//                    break;
//            }
//
//        }
//    }

    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        binding = ActivityNewItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dBmain = new DBmain(this);
        //create method
        binding.save.setOnClickListener(view -> {
                sqLiteDatabase = dBmain.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("name", binding.editProductName.getText().toString());

                Long id = sqLiteDatabase.insert("nameProduct", null, cv);
                if (id != null) {
                    Toast.makeText(NewItem.this, "successfully insert", Toast.LENGTH_SHORT).show();
                    cleardata();
                } else {
                    Toast.makeText(NewItem.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(NewItem.this, MainActivity.class));
        });
       // cleardata();
    }

    private void cleardata() {
        binding.editProductName.setText("");
    }

//    private void insertData() {
//
//    }
}