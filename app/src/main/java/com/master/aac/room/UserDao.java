package com.master.aac.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.os.AsyncTask;

import java.util.List;

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    abstract List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    abstract User findByName(String first, String last);

    @Insert
    abstract void insertAll(User... users);

    @Delete
    abstract void delete(User user);

    interface GetAllCallback {
        void getAll(List<User> list);
    }

    @Query("SELECT * FROM user")
    abstract List<User> getAll();

    public void getAllAsync(final GetAllCallback callback) {
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... params) {
                return getAll();
            }

            @Override
            protected void onPostExecute(List<User> list) {
                super.onPostExecute(list);
                callback.getAll(list);
            }
        }.execute();
    }
}