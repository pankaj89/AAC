package com.master.aac.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by Pankaj Sharma on 6/6/17.
 */

public class LifeCycleAwareModel implements LifecycleObserver {
    private static final String TAG = "LifeCycleAwareModel";

    private Lifecycle lifecycle;

    public LifeCycleAwareModel() {

    }

    //There is only need to send this to check what is current life cycle.
    public LifeCycleAwareModel(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) {
            //means activity is currently resumed
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d(TAG, "onResume() called");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.d(TAG, "onPause() called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "onCreate() called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.d(TAG, "onStart() called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.d(TAG, "onStop() called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
//        Log.d(TAG, "onAny() called");
    }
}
