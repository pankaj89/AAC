package com.master.aac.room;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.aac.R;

import java.util.List;


/**
 * Created by Pankaj sharma on 5/6/17.
 * Database Helper class for managing database and there queries
 */

public class Room_Activity extends Activity implements View.OnClickListener {
    User user;
    EditText edtFirstName, edtLastName;
    Button btnInsert, btnClear, btnSave, btnDelete;
    LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        edtFirstName = (EditText) findViewById(R.id.edt_first_name);
        edtLastName = (EditText) findViewById(R.id.edt_last_name);

        container = (LinearLayout) findViewById(R.id.container);

        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDelete = (Button) findViewById(R.id.btn_delete);

        btnInsert.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        //Async method to get all users.
        getAppDatabase().userDao().getAllAsync(new UserDao.GetAllCallback() {
            @Override
            public void getAll(List<User> list) {
                container.removeAllViews();
                for (User user1 : list) {
                    View view = View.inflate(Room_Activity.this, R.layout.items, null);
                    ((TextView) view.findViewById(R.id.txt_first_name)).setText(user1.getFirstName());
                    ((TextView) view.findViewById(R.id.txt_last_name)).setText(user1.getLastName());
                    container.addView(view);
                }
            }
        });
    }

    private void setUpInsert() {
        user = null;
        edtFirstName.setText("");
        edtLastName.setText("");

        btnInsert.setVisibility(View.VISIBLE);
        btnClear.setVisibility(View.GONE);
        btnSave.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);
    }

    private void setUpEdit(User user) {
        this.user = user;
        edtFirstName.setText(user.getFirstName());
        edtLastName.setText(user.getLastName());

        btnInsert.setVisibility(View.GONE);
        btnClear.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                User user = new User();
                user.setUid((int) System.currentTimeMillis());
                user.setFirstName(edtFirstName.getText().toString());
                user.setLastName(edtLastName.getText().toString());


                new AsyncTask<User, Void, List<User>>() {
                    @Override
                    protected List<User> doInBackground(User... params) {
                        UserDao userDao = getAppDatabase().userDao();
                        userDao.insertAll(params);
                        UserDao userDao1 = getAppDatabase().userDao();
                        List<User> list = userDao1.getAll();
                        return list;
                    }

                    @Override
                    protected void onPostExecute(List<User> list) {
                        super.onPostExecute(list);

                        container.removeAllViews();
                        for (User user1 : list) {
                            View view = View.inflate(Room_Activity.this, R.layout.items, null);
                            ((TextView) view.findViewById(R.id.txt_first_name)).setText(user1.getFirstName());
                            ((TextView) view.findViewById(R.id.txt_last_name)).setText(user1.getLastName());
                            container.addView(view);
                        }
                    }
                }.execute(user);


                break;
            case R.id.btn_clear:
                setUpInsert();
                break;
            case R.id.btn_save:
                break;
            case R.id.btn_delete:
                break;
        }
    }

    AppDatabase db;

    private AppDatabase getAppDatabase() {
        if (db == null)
            db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        return db;
    }
}
