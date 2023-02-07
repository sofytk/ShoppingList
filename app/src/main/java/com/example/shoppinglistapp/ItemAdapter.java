package com.example.shoppinglistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private final List<MyItem> myItems;

    public ItemAdapter(List<MyItem> myItems) {
        this.myItems = myItems;
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
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }
}
