package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class personalInfo extends Fragment {
    public personalInfo() {
        // Required empty public constructor
    }
    View view;
    private String[] gen={"Male","Female","LGBT"};
    private String[] maritalStatus={"Married","Unmarried","Divorced","Others"};
    private String[] empStatus={"Employed","Unemployed","Student","Laid off"};
    private String[] caste={"General","SC","ST","OBC","Others"};
    private AutoCompleteTextView gender,mariStatus,emp,category;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_personal_info, container, false);
        gender=view.findViewById(R.id.gender);
        emp=view.findViewById(R.id.empstatus);
        mariStatus=view.findViewById(R.id.martital_status);
        category=view.findViewById(R.id.category);
        // Inflate the layout for this fragment
        arryAdap();

        return view;
    }

    void arryAdap(){
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),R.layout.list_items,gen);
        gender.setThreshold(1);
        gender.setAdapter(adapter);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(view.getContext(),R.layout.list_items,maritalStatus);
        mariStatus.setThreshold(1);
        mariStatus.setAdapter(adapter1);

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(view.getContext(),R.layout.list_items,empStatus);
        emp.setThreshold(1);
        emp.setAdapter(adapter2);

        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(view.getContext(),R.layout.list_items,caste);
        category.setThreshold(1);
        category.setAdapter(adapter3);
    }

}