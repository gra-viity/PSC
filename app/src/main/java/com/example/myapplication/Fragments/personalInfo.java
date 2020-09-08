package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class personalInfo extends Fragment {
    public personalInfo() {
        // Required empty public constructor
    }

    View view;
    Button buttonSubmit;
    private String[] gen = {"Male", "Female", "LGBT"};
    private String[] maritalStatus = {"Married", "Unmarried", "Divorced", "Others"};
    private String[] empStatus = {"Employed", "Unemployed", "Student", "Laid off"};
    private String[] caste = {"General", "SC", "ST", "OBC", "Others"};
    private AutoCompleteTextView gender, mariStatus, emp, category;
    private AutoCompleteTextView name, AddcardNumber, mobNo, email, address, dist, state, nation, religion;
    private AutoCompleteTextView education, workExp, workingSector, list_of_skill, your_dependant, no_of_dependant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        gender = view.findViewById(R.id.gender);
        emp = view.findViewById(R.id.empstatus);
        mariStatus = view.findViewById(R.id.martital_status);
        category = view.findViewById(R.id.category);
        AddcardNumber = view.findViewById(R.id.addnumber);
        name = view.findViewById(R.id.migrantName);
        mobNo = view.findViewById(R.id.mobnumber);
        email = view.findViewById(R.id.email_ad);
        address = view.findViewById(R.id.address);
        dist = view.findViewById(R.id.district);
        state = view.findViewById(R.id.State);
        nation = view.findViewById(R.id.nationality);
        religion = view.findViewById(R.id.religion);
        education = view.findViewById(R.id.education);
        workExp = view.findViewById(R.id.work_experience);
        workingSector = view.findViewById(R.id.sector);
        list_of_skill = view.findViewById(R.id.list_of_skill);
        your_dependant = view.findViewById(R.id.your_dependant);
        no_of_dependant = view.findViewById(R.id.no_of_dependent);
        buttonSubmit = view.findViewById(R.id.submit);
        // Inflate the layout for this fragment
        submit();
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

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(view.getContext(), R.layout.list_items, empStatus);
        emp.setThreshold(1);
        emp.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(view.getContext(), R.layout.list_items, caste);
        category.setThreshold(1);
        category.setAdapter(adapter3);
    }

    void submit() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}