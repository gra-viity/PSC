package com.example.myapplication.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class personalInfo extends Fragment {
    public personalInfo() {
        // Required empty public constructor
    }

    View view;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    ProgressBar progressBar;
    Button buttonSubmit;
    private String[] gen = {"Male", "Female", "LGBT"};
    private String[] maritalStatus = {"Married", "Unmarried", "Divorced", "Others"};
    private String[] empStatus = {"Employed", "Unemployed", "Student", "Laid off"};
    private String[] caste = {"General", "SC", "ST", "OBC", "Others"};
    private AutoCompleteTextView gender, mariStatus, emp, category;
    private EditText name, AddcardNumber, mobNo, email, address, dist, state, nation, religion;
    private EditText education, workExp, workingSector, list_of_skill, your_dependant, no_of_dependant;

    private String ename, eAddcardNumber, emobNo, eemail, eaddress, edist, estate, enation, ereligion, eeducation, eworkExp, eworkingSector, elist_of_skill, eyour_dependant, eno_of_dependant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        initilizeUI();
        // Inflate the layout for this fragment
        submit();
        arryAdap();

        return view;
    }

    void arryAdap() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), R.layout.list_items, gen);
        gender.setThreshold(1);
        gender.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(view.getContext(), R.layout.list_items, maritalStatus);
        mariStatus.setThreshold(1);
        mariStatus.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(view.getContext(), R.layout.list_items, empStatus);
        emp.setThreshold(1);
        emp.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(view.getContext(), R.layout.list_items, caste);
        category.setThreshold(1);
        category.setAdapter(adapter3);
    }

    void initilizeUI() {
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
    }

    void submit() {
        ename = name.getText().toString();
        eAddcardNumber = AddcardNumber.getText().toString().trim();
        emobNo = mobNo.getText().toString().trim();
        eemail = email.getText().toString();
        eaddress = address.getText().toString();
        edist = dist.getText().toString();
        estate = state.getText().toString();
        enation = nation.getText().toString();
        ereligion = religion.getText().toString();
        eeducation = education.getText().toString();
        eworkExp = workExp.getText().toString();
        eworkingSector = workingSector.getText().toString();
        elist_of_skill = list_of_skill.getText().toString();
        eyour_dependant = your_dependant.getText().toString();
        eno_of_dependant = no_of_dependant.getText().toString();
        if (TextUtils.isEmpty(ename) && TextUtils.isEmpty(estate) && TextUtils.isEmpty(edist) && TextUtils.isEmpty(enation) && emobNo.length() < 10 && eAddcardNumber.length() < 16) {

            name.setError("Input Name");
            state.setError("Input State");
            dist.setError("Input District");
            nation.setError("Input Nation");
            mobNo.setError("Invalid mobile number");
            AddcardNumber.setError("Invalid Addhar Card");
        }
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ename = name.getText().toString();
                eAddcardNumber = AddcardNumber.getText().toString().trim();
                emobNo = mobNo.getText().toString().trim();
                eemail = email.getText().toString();
                eaddress = address.getText().toString();
                edist = dist.getText().toString();
                estate = state.getText().toString();
                enation = nation.getText().toString();
                ereligion = religion.getText().toString();
                eeducation = education.getText().toString();
                eworkExp = workExp.getText().toString();
                eworkingSector = workingSector.getText().toString();
                elist_of_skill = list_of_skill.getText().toString();
                eyour_dependant = your_dependant.getText().toString();
                eno_of_dependant = no_of_dependant.getText().toString();

                Map<String, Object> data = new HashMap<>();
                data.put("Name", ename);
                data.put("AddharCard", eAddcardNumber);
                data.put("Mobile", emobNo);
                data.put("eMail", eemail);
                data.put("Address", eaddress);
                data.put("District", edist);
                data.put("State", estate);
                data.put("Nation", enation);
                data.put("Religion", ereligion);
                data.put("Education", eeducation);
                data.put("Work_Experience", eworkExp);
                data.put("Working_sector", eworkingSector);
                data.put("List_of_skills", elist_of_skill);
                data.put("Dependents", eyour_dependant);
                data.put("Number_of_dependent", eno_of_dependant);
                fStore.collection("Migrants").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //  Toast.makeText(getActivity(), "Done", Toast.LENGTH_LONG).show();
                        AlertDialogShow("Data Added. Want to add more?");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                        Log.d("Error", e.toString());
                    }
                });

            }
        });

    }


    private void AlertDialogShow(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearFields();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void clearFields() {
        name.setText("");
        AddcardNumber.setText("");
        mobNo.setText("");
        email.setText("");
        address.setText("");
        dist.setText("");
        state.setText("");
        nation.setText("");
        religion.setText("");
        education.setText("");
        workExp.setText("");
        workingSector.setText("");
        list_of_skill.setText("");
        your_dependant.setText("");
        no_of_dependant.setText("");
    }
}