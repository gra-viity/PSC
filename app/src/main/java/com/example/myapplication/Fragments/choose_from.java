package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public class choose_from extends Fragment {
    TextView ngoLogin;
    TextView selfLogin;


    View view;

    public choose_from() {
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
        view = inflater.inflate(R.layout.fragment_choose_from, container, false);
        ngoLogin = view.findViewById(R.id.ngo);
        selfLogin = view.findViewById(R.id.self);


        ngoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new login_screen_ngo());
            }
        });

        selfLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new login_screen());
            }
        });


        return view;
    }

    void loadFragment(Fragment object) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, object).addToBackStack("added").commit();
        //getWindow().setStatusBarColor(Color.rgb(38,16,117));
    }

    //need to implement different types of login
}