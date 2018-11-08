package com.second.leftright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView myName, myEmail, myGender, myDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        myName = findViewById(R.id.info_name_text_view);
        myEmail = findViewById(R.id.info_email_text_view);
        myGender = findViewById(R.id.info_gender_text_view);
        myDOB = findViewById(R.id.info_dob_text_view);

        myName.setText(SignUpActivity.USER_NAME);
        myEmail.setText(SignUpActivity.EMAIL);
        myDOB.setText(SignUpActivity.D_O_B);
        myGender.setText(SignUpActivity.GENDER);


    }






}
