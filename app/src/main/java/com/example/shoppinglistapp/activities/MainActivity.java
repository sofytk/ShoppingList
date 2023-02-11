package com.example.shoppinglistapp.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;
import com.example.shoppinglistapp.foritem.ItemAdapter;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.foritem.MyItem;
import com.example.shoppinglistapp.mydb.DBmain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //
//    private static final int ACTION_IMAGE_CAPTURE_REQUEST_CODE = 1;
   ActivityMainBinding binding;
//
//    private ItemAdapter itemAdapter;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        adapterData();
//
//        binding.add.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, NewItem.class);
//            startActivity(intent);
//        });
//        updateList();
//        binding.scan.setOnClickListener(view -> {
//            Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            startActivityForResult(photoPickerIntent, ACTION_IMAGE_CAPTURE_REQUEST_CODE);
//        });
//    }
//
//    private void adapterData() {
//        itemAdapter = new ItemAdapter(itemList, MainActivity.this);
//        binding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        binding.recycler.setAdapter(itemAdapter);
//    }
//    private void updateList() {
//        itemAdapter.notifyDataSetChanged();
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent image) {
//        super.onActivityResult(requestCode, resultCode, image);
//
//        if (requestCode == ACTION_IMAGE_CAPTURE_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                Bitmap photo = (Bitmap) image.getExtras().get("data");
//                Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
//                intent.putExtra("photo", photo);
//                startActivity(intent);
//                Log.v("RRRR", "Load image");
//            }
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.save:
//            case R.id.remove:
//                finish();
//                break;
//        }
//    }
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<MyItem> myItemArrayList;
    ItemAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myItemArrayList = new ArrayList<>();
        dBmain = new DBmain(this);
        myItemArrayList = displayData();
        myAdapter = new ItemAdapter(myItemArrayList, MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL, false);
        binding.recycler.setLayoutManager(linearLayoutManager);
        binding.recycler.setAdapter(myAdapter);


        binding.add.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItem.class);
            startActivity(intent);
        });
    }

    private ArrayList<MyItem> displayData() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from nameProduct", null);
        ArrayList<MyItem> modelArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                modelArrayList.add(new MyItem(cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        Log.v("RRRR", modelArrayList.toString());
        cursor.close();
        return modelArrayList;
    }
}