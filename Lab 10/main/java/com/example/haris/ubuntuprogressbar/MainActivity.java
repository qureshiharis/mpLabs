package com.example.haris.ubuntuprogressbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progress;
    TextView text;
    Handler handler;
    Thread myThread;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.my_progress_bar);
        text = (TextView) findViewById(R.id.my_textview);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                progress.setProgress(msg.getData().getInt("value"));
                text.setText(msg.getData().getString("info"));
            }
        };}

    public void startProgress(View view) {
        // do something long
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    doFakeWork();

                    Message msg = new Message();
                    Bundle b = new Bundle();
                    b.putInt("value",i);
                    if(i!=100)
                        b.putString("info","Downloading...");
                    else
                        b.putString("info","Downloaded");
                    msg.setData(b);
                    handler.sendMessage(msg);

                   // startActivity(new Intent(getApplicationContext(), Main2Activity.class));

                }
            }
        };

        myThread = new Thread(runnable);
        myThread.start();


    }
    private void doFakeWork() {
        try {  SystemClock.sleep(50);
        } catch (Exception e) { e.printStackTrace();}}

    public void pauseProgress(View view) {



    }
}