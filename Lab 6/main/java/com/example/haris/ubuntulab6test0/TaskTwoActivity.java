package com.example.haris.ubuntulab6test0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TaskTwoActivity extends AppCompatActivity implements TaskTwoFragmentList.MyListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
    }

    @Override
    public void itemClicked(long id) {

        Intent myIntent = new Intent(getApplicationContext(), NewTestActivity.class);
        startActivity(myIntent);
    }
}
