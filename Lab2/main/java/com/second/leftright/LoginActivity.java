package com.second.leftright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText myUsername, myPassword;
    Intent myIntent;
    Toast myToast;

    String userEnteredName, userEnteredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginButtonClick(View view) {

        myUsername = findViewById(R.id.loginn_usernameEditText);
        myPassword = findViewById(R.id.login_passwordEditText);

       userEnteredName = myUsername.getText().toString();
       userEnteredPassword = myPassword.getText().toString();

        // compare username and password is same as constant string
        if( userEnteredName.equals(SignUpActivity.USER_NAME) && userEnteredPassword.equals(SignUpActivity.PASS_WORD)) {

            myIntent = new Intent(LoginActivity.this, InfoActivity.class);
            startActivity(myIntent);

        }
        else {
            myToast = Toast.makeText(this, "Wrong Details", Toast.LENGTH_SHORT);
            myToast.show();
        }

    }
}
