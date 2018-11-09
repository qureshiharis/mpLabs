package com.second.impliciteverywhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterMessageActivity extends AppCompatActivity {

    EditText MessageEditText;
    Button SendMessageButton;
    Intent MyIntent;

    String message;

    public static String MY_MESSAGE;
    public static final int RESULT_CODE = 06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_message);

        MessageEditText = findViewById(R.id.message_edit_text);
        SendMessageButton = findViewById(R.id.send_message_button);

    }

    public void sendMessageButtonClicked(View view) {

        message = MessageEditText.getText().toString();

        Intent MyIntentTwo = new Intent();
        MyIntentTwo.putExtra(MY_MESSAGE, message);
        setResult(RESULT_OK, MyIntentTwo);
        finish();

    }
}
