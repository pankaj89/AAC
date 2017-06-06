package com.master.aac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.master.aac.lifecycle.LifeCycle_Activity;
import com.master.aac.livedata.LiveData_Activity;
import com.master.aac.room.Room_Activity;
import com.master.aac.viewmodel.ViewModel_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLifeCycleClicked(View view) {
        startActivity(new Intent(this, LifeCycle_Activity.class));
    }

    public void btnRoomClicked(View view) {
        startActivity(new Intent(this, Room_Activity.class));
    }

    public void btnLiveDataClicked(View view) {
        startActivity(new Intent(this, LiveData_Activity.class));
    }

    public void btnViewModelClicked(View view) {
        startActivity(new Intent(this, ViewModel_Activity.class));
    }
}
