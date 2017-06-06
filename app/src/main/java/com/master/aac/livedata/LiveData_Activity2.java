package com.master.aac.livedata;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.master.aac.R;


/**
 * Created by Pankaj Sharma on 6/6/17.
 */

public class LiveData_Activity2 extends LifecycleActivity {
    private static final String TAG = "LiveData_Activity2";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmodel_activity);
        Button btnChange = (Button) findViewById(R.id.btn_change);
        Button btnNextActivity = (Button) findViewById(R.id.btn_next_activity);

        final UserLiveData userLiveData = UserLiveData.getInstance();
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLiveData.changeValue();
            }
        });
        btnNextActivity.setText("Prev Activity");
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        userLiveData.observe(this, new Observer<UserLiveData>() {
            @Override
            public void onChanged(@Nullable UserLiveData userLiveData) {
                Log.d(TAG, "onChanged() called with: userLiveData = [" + userLiveData + "]");
            }
        });
    }
}
