package com.example.myapplication.firebase;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseDatabaseReference {
    private FirebaseDatabaseReference() {
    }
    public static final FirebaseFirestore DATABASE = FirebaseFirestore .getInstance();
}