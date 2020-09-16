package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecylerViewHolder> {
    viewData viewData;
    ArrayList<model> arrayList;

    public RecyclerViewAdaptor(com.example.myapplication.viewData viewData, ArrayList<model> arrayList) {
        this.viewData = viewData;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewData.getBaseContext());
        View view = layoutInflater.inflate(R.layout.datalist, parent, false);
        return new RecylerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewHolder holder, int position) {
        holder.mName.setText(arrayList.get(position).getName());
        holder.mAadhar.setText(arrayList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
