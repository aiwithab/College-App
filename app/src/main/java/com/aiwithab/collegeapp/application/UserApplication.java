package com.aiwithab.collegeapp.application;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserApplication extends Application {

    public static FirebaseUser user;
    public static FirebaseAuth auth;
    public static FirebaseFirestore database;
}
