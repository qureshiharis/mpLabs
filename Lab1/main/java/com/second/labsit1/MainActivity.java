package com.second.labsit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Intent myIntent;
    TextView myText;
    Button myBut;
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBut = findViewById(R.id.myButton);
        myText = findViewById(R.id.myTextView);

        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Toast.makeText(getApplicationContext(),"Button Clicked!", Toast.LENGTH_SHORT).show();
                myText.setText("YOU REBEL!"+ number);
                number++;

            }
        });
    }

}

