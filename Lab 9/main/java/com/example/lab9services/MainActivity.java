package com.example.lab9services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup myRadioGroup;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRadioGroup = findViewById(R.id.my_radiogroup);
        myButton = findViewById(R.id.my_button_);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(MainActivity.this, MyService.class);
                if (!MyService.IS_SERVICE_RUNNING) {
                    service.setAction(MyService.STARTFOREGROUND_ACTION);
                    MyService.IS_SERVICE_RUNNING = true;
                    myButton.setText("Stop Service");
                } else {
                    service.setAction(MyService.STOPFOREGROUND_ACTION);
                    MyService.IS_SERVICE_RUNNING = false;
                    myButton.setText("Start Service");

                }
                startService(service);
            }
        });


    }
}
