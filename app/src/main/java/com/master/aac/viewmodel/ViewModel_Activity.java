package com.master.aac.viewmodel;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by Pankaj Sharma on 6/6/17.
 * ViewModel used to retain data when configuration changes. change orientation and see logs
 */

public class ViewModel_Activity extends LifecycleActivity {
    private static final String TAG = "ViewModel_Activity";
    UserModel user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            user = ViewModelProviders.of(this).get(UserModel.class);
            user.firstName = "Pankaj";
            user.lastName = System.currentTimeMillis() + "";
        }
        user = ViewModelProviders.of(this).get(UserModel.class);

        Log.d(TAG, "onCreate() called with: = [" + user + "]");

    }
}
