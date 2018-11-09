package com.second.impliciteverywhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskThreeActivity extends AppCompatActivity {

    TextView MessageTextView;
    Button GetMessageButton;
    Intent MyIntent;

    public static final int REQUEST_CODE = 05;

    String repliedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_three);

        MessageTextView = findViewById(R.id.message_text_view);
        GetMessageButton = findViewById(R.id.get_message_button);

    }

    public void getMessageButtonClicked(View view) {

        MyIntent = new Intent(this, EnterMessageActivity.class);
        startActivityForResult(MyIntent, REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                repliedMessage = intent.getStringExtra(EnterMessageActivity.MY_MESSAGE);
                MessageTextView.setText(repliedMessage);
            }
        }
    }
}
