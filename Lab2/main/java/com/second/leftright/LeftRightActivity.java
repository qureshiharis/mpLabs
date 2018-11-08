package com.second.leftright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LeftRightActivity extends AppCompatActivity {

    ImageView myPic;
    TextView myName, myAge, myJob;
    ImageButton prev, next;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right);

        // GETTING REFERENCES TO ALL VIEWS

        myPic = (ImageView) findViewById(R.id.pictureImageView);

        myName = (TextView) findViewById(R.id.nameTextView);
        myAge = (TextView) findViewById(R.id.ageTextView);
        myJob = (TextView) findViewById(R.id.jobTextView);

        prev = (ImageButton) findViewById(R.id.previousButton);
        next = (ImageButton) findViewById(R.id.nextButton);

        // SETTING DEFAULT CHARACTER DATA ON FIRST START UP

        myPic.setImageResource(CharacterData.getCharacterPicture(0));
        myName.setText(CharacterData.getCharacterName(0));
        myAge.setText(CharacterData.getCharacterAge(0));
        myJob.setText(CharacterData.getCharacterJob(0));

        counter = 0;

    }

    public void previousButtonClicked(View view) {

        CharSequence text = "You are at the start already!";
        int duration = Toast.LENGTH_SHORT;

        if(counter!=0) {

            counter--;

            myPic.setImageResource(CharacterData.getCharacterPicture(counter));
            myName.setText(CharacterData.getCharacterName(counter));
            myAge.setText(CharacterData.getCharacterAge(counter));
            myJob.setText(CharacterData.getCharacterJob(counter));

        }
        else {
            Toast myToast = Toast.makeText(this, text, duration);
            myToast.show();
        }
    }

    public void nextButtonClicked(View view) {

        CharSequence text = "That is it, the end!";
        int duration = Toast.LENGTH_SHORT;

        if(counter!=5) {

            //set counter++ and show next data

            counter++;

            myPic.setImageResource(CharacterData.getCharacterPicture(counter));
            myName.setText(CharacterData.getCharacterName(counter));
            myAge.setText(CharacterData.getCharacterAge(counter));
            myJob.setText(CharacterData.getCharacterJob(counter));
        }
        else {

            // show a toast saying we are at the end already

            Toast myToast = Toast.makeText(this, text, duration);
            myToast.show();
        }

    }
}
