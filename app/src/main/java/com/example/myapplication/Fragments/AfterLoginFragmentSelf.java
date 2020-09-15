package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;


public class AfterLoginFragmentSelf extends Fragment {
    View view;
    CardView peform, post, calender, share, talk;
    FragmentTransaction fragmentTransaction;

    public AfterLoginFragmentSelf() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_after_login_self, container, false);
        initializeUI();

        peform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, new personalInfo()).addToBackStack("loginStack").commit();

            }
        });
        return view;
    }

    void initializeUI() {
        peform = view.findViewById(R.id.pef);
        post = view.findViewById(R.id.postJobFromSelf);
        calender = view.findViewById(R.id.trainingCalender);
        share = view.findViewById(R.id.shareStory);
        talk = view.findViewById(R.id.talkTous);
    }
}