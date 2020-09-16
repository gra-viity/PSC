package com.example.myapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.viewData;


public class AfterLoginFragNgo extends Fragment {
    View view;
    CardView accessMigrantsDATA;

    public AfterLoginFragNgo() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_after_login_frag_ngo, container, false);
        initializeUI();
        accessDATA();
        return view;
    }

    private void accessDATA() {
        accessMigrantsDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), viewData.class);
                startActivity(i);
            }
        });
    }

    private void initializeUI() {
        accessMigrantsDATA = view.findViewById(R.id.accessMigrant);
    }

}