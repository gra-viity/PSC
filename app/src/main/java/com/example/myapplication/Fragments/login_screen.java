package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login_screen extends Fragment {
    View view;
    TextInputEditText email, pass;
    Button submit;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    FragmentTransaction fragmentTransaction;

    public login_screen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_login_screen, container, false);
        initializeUI();
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        return view;
    }

    private void loginUser() {
        progressBar.setVisibility(View.VISIBLE);
        String emailID, Password;
        Password = pass.getText().toString();
        emailID = email.getText().toString();
        if (TextUtils.isEmpty(emailID)) {
            email.setError("Please input email");
            progressBar.setVisibility(View.GONE);

            return;
        }
        if (TextUtils.isEmpty(Password)) {
            pass.setError("Please input password");
            progressBar.setVisibility(View.GONE);

            return;
        }
        mAuth.signInWithEmailAndPassword(emailID, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Please wait", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    fragmentTransaction.replace(R.id.placeHolder, new AfterLoginFragmentSelf()).commit();
                } else {
                    Toast.makeText(getActivity(), "Login failed try again", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }


    private void initializeUI() {
        email = view.findViewById(R.id.input_username);
        pass = view.findViewById(R.id.input_password);
        submit = view.findViewById(R.id.btn_login);
        progressBar = view.findViewById(R.id.progressBar);
    }

}

//TODO:login seprator
//TODO:View and modify data