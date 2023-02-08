package com.example.shoppinglistapp;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyItem extends AppCompatActivity{
    public static final ArrayList<MyItem> itemList = new ArrayList<>();
    private String productName;
    public static Context context;

    public MyItem(String productName) {
        this.productName = productName;
        this.context = this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
