package com.master.aac.livedata;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.master.aac.R;


/**
 * Created by Pankaj Sharma on 6/6/17.
 * LiveData used to listen for any changes in some model, Use this in place of LocalBroadcast. see logs
 */

public class LiveData_Activity extends AppCompatActivity {
    private static final String TAG = "LiveData_Activity";

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
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveData_Activity.this, LiveData_Activity2.class);
                startActivity(intent);
            }
        });

        userLiveData.observeForever(new Observer<UserLiveData>() {
            @Override
            public void onChanged(@Nullable UserLiveData userLiveData) {
                Log.d(TAG, "onChanged() called with: userLiveData = [" + userLiveData + "]");
            }
        });
    }
}
