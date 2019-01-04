package com.example.haris.ubuntulab6test0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button myTaskOneButton, myTaskTwoButton;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTaskOneButton = findViewById(R.id.taskone_button);
        myTaskTwoButton = findViewById(R.id.tasktwo_button);

        myTaskOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myIntent = new Intent(getApplicationContext(), TaskOneActivity.class);
                startActivity(myIntent);

            }
        });

        myTaskTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myIntent = new Intent(getApplicationContext(), TaskTwoActivity.class);
                startActivity(myIntent);

            }
        });

    }   // end of onCreate()
}   // end of class
