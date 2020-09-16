package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class viewData extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    ArrayList<model> arrayList;
    RecyclerView recyclerView;
    RecyclerViewAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        firebaseFirestore = FirebaseFirestore.getInstance();
        setUpRecyclerView();
        arrayList = new ArrayList<>();

        loadUpFirebase();
    }

    private void AlertDialogShow(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadUpFirebase();
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

    private void loadUpFirebase() {
        if (arrayList.size() > 0)
            arrayList.clear();
        firebaseFirestore.collection("Migrants").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                for (DocumentSnapshot documentSnapshot : task.getResult()) {
                    model m = new model(documentSnapshot.getString("Name"), documentSnapshot.getString("AddharCard"));
                    arrayList.add(m);
                }
                adaptor = new RecyclerViewAdaptor(viewData.this, arrayList);
                recyclerView.setAdapter(adaptor);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                AlertDialogShow("Failed to load data due to some technical issue. Want to retry?");
                Log.w("LoadError", e.getMessage());
            }
        });
    }

    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

//TODO:Post jobs
//TODO:Stories