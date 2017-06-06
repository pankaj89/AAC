package com.master.aac.lifecycle;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Pankaj Sharma on 6/6/17.
 * Life cycle specific methods calls on LifeCycleAwareModel, see logs
 */

public class LifeCycle_Activity extends LifecycleActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeCycleAwareModel model = new LifeCycleAwareModel();
        getLifecycle().addObserver(model);
    }
}
