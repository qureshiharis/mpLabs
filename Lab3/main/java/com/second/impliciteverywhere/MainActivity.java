package com.second.impliciteverywhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button TaskTwoButton, TaskThreeButton;
    Intent MyIntent;
    Toast MyToast;
    int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskTwoButton = findViewById(R.id.task_two_button);
        TaskThreeButton = findViewById(R.id.task_three_button);

    }

    public void onTaskTwoClicked(View view) {

        MyIntent = new Intent(this, ImplicitActivity.class);
        startActivity(MyIntent);

        CharSequence text = "Please allow 'call' and 'camera' permission from settings/apps/ImplicitEverywhere/permissions";

        MyToast = Toast.makeText(this, text, duration);
        MyToast.show();

    }

    public void onTaskThreeClicked(View view) {

        MyIntent = new Intent(this, TaskThreeActivity.class);
        startActivity(MyIntent);

    }

}
