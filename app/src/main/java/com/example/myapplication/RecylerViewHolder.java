package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecylerViewHolder extends RecyclerView.ViewHolder {
    public TextView mName, mAadhar;

    public RecylerViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.viewName);
        mAadhar = itemView.findViewById(R.id.viewAddhar);

    }
}
