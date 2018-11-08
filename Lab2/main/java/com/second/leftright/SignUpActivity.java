package com.second.leftright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    public static String USER_NAME;
    public static String PASS_WORD;
    public static String EMAIL;
    public static String GENDER;
    public static String D_O_B;

    EditText myName, myEmail, myPassword, myDOB;
    Button signUpButton;
    RadioButton femaleRadioButton, maleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUpButtonClicked(View view) {

        myName = findViewById(R.id.sign_up_name_edit_text);
        myEmail = findViewById(R.id.email_edit_text);
        myPassword = findViewById(R.id.sign_up_password_edit_text);
        myDOB = findViewById(R.id.dob_edit_text);

        signUpButton = findViewById(R.id.sign_up_button);

        femaleRadioButton = findViewById(R.id.female_signup_button);
        maleRadioButton = findViewById(R.id.male_signup_button);

        // store data in static constant variable

        USER_NAME = myName.getText().toString();
        PASS_WORD = myPassword.getText().toString();
        EMAIL = myEmail.getText().toString();
        D_O_B = myDOB.getText().toString();

        if(femaleRadioButton.isSelected()) {
            GENDER = "Female";
        }
        else {
            GENDER = "MALE";
        }

        // go back to previous screen
        finish();
    }
}
