package com.example.shoppinglistapp.foritem;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglistapp.activities.EditProduct;
import com.example.shoppinglistapp.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private ArrayList<MyItem> myItems;
    private Context mContext;


    public ItemAdapter(ArrayList<MyItem> myItems, Context context) {
        this.myItems = myItems;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        return new MyViewHolder(view);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView productName;
        private final RelativeLayout item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            this.item = itemView.findViewById(R.id.item);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        MyItem item = myItems.get(position);
        holder.productName.setText(item.getProductName());
        holder.item.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, EditProduct.class);
            intent.putExtra("name", item.getProductName());
            intent.putExtra("pos", position);
            Log.d("RRRR", "startIntent");
            Log.d("RRRR", String.valueOf(position));
            mContext.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return myItems.size();
    }
}
