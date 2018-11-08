package com.second.leftright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginButtonClicked(View view) {

        myIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(myIntent);
    }

    public void signUpButtonClicked(View view) {

        myIntent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(myIntent);
    }

    public void infoButtonClicked(View view) {

        myIntent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(myIntent);
    }

    public void leftRightButtonClicked(View view) {

        myIntent = new Intent(MainActivity.this, LeftRightActivity.class);
        startActivity(myIntent);
    }
}
