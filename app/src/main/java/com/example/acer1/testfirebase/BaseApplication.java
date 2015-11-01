package com.example.acer1.testfirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Acer1 on 01/11/2015.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
