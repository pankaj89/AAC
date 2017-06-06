package com.master.aac.viewmodel;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Pankaj Sharma on 6/6/17.
 */

public class UserModel extends ViewModel {
    public String firstName;
    public String lastName;

    public UserModel() {

    }

    public UserModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
