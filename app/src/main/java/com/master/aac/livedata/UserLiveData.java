package com.master.aac.livedata;

import android.arch.lifecycle.LiveData;

/**
 * Created by Pankaj Sharma on 6/6/17.
 */

public class UserLiveData extends LiveData<UserLiveData> {

    long timestamp;

    private static UserLiveData userLiveData;

    private UserLiveData() {

    }

    public static UserLiveData getInstance() {
        if (userLiveData == null) {
            userLiveData = new UserLiveData();
        }
        return userLiveData;
    }

    public void changeValue() {
        timestamp = System.currentTimeMillis();
        setValue(this);
    }

    @Override
    public String toString() {
        return "Time : " + timestamp;
    }


}
