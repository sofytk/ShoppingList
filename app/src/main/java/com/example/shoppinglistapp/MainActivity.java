package com.example.shoppinglistapp;


import static com.example.shoppinglistapp.MyItem.itemList;

import androidx.annotation.NonNull;
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
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.shoppinglistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    private ItemAdapter itemAdapter;
    ArrayList<MyItem> myItems;
    // SharedPreferences prefs;

    // private Parcelable recyclerViewState;

    DBProduct dbProduct;
    SQLiteDatabase sqLiteDatabase;

    // @Override
//    protected void onStart() {
//        super.onStart();
//        binding.recycler.getLayoutManager().onRestoreInstanceState(recyclerViewState);
//    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myItems = new ArrayList<>();
        dbProduct = new DBProduct(this);
        itemAdapter = new ItemAdapter(myItems, MainActivity.this);

       // displayData();


        binding.recycler.setAdapter(itemAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


        binding.add.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItem.class);
            startActivity(intent);
        });

        updateList();

        binding.scan.setOnClickListener(view -> {
        });

        SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
    }


//    private ArrayList<MyItem> displayData() {
//        sqLiteDatabase = dbProduct.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select *from course", null);
//        ArrayList<MyItem> modelArrayList = new ArrayList<>();
//        if (cursor.moveToFirst()) {
//            do {
//                modelArrayList.add(new MyItem(cursor.getString(1)));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return modelArrayList;
//    }


    private void updateList() {
        //itemAdapter.setArrayMyData(mDBConnector.selectAll());
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

//    @Override
//    protected void onStop() {
//        super.onStop();
//        recyclerViewState = binding.recycler.getLayoutManager().onSaveInstanceState();
//    }
}