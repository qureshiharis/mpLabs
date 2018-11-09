package com.second.impliciteverywhere;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity {

    EditText DataEditText;
    Button CallButton, CameraButton, ContactButton, BrowserButton, CallLogButton, GalleryButton, DialPadButton;
    Intent MyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        // GETTING REFERENCES TO VIEWS USED (EDIT TEXT AND BUTTONS)

        DataEditText = findViewById(R.id.main_edit_text);

        CallButton = findViewById(R.id.call_button);
        CameraButton = findViewById(R.id.camera_button);
        ContactButton = findViewById(R.id.contact_button);
        BrowserButton = findViewById(R.id.browser_button);
        CallLogButton = findViewById(R.id.call_log_button);
        GalleryButton = findViewById(R.id.gallery_button);
        DialPadButton = findViewById(R.id.dial_pad_button);

    }

    public void callButtonClicked(View view) {

        // calls the number entered, if edit text is empty shows a toast saying enter number
        String number = DataEditText.getText().toString();

        if( number.length()>0) {
            MyIntent = new Intent(Intent.ACTION_CALL);
            MyIntent.setData(Uri.parse("tel:" + number));
            startActivity(MyIntent);
        }
        else {

            CharSequence text = "Enter number";
            int duration = Toast.LENGTH_SHORT;

            Toast myToast = Toast.makeText(this, text, duration);
            myToast.show();
        }
    }

    public void cameraButtonClicked(View view) { //CHECK

        // launches camera

        MyIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(MyIntent);

    }

    public void contactButtonClicked(View view) {

        // launches contact application
        MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(MyIntent);

    }

    public void browserButtonClicked(View view) {

        String website = DataEditText.getText().toString();

        if( !website.startsWith("http://") && !website.startsWith("https://"))
        {
            website = "http://" + website;
        }

        MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(MyIntent);
    }

    public void callLogButtonClicked(View view) {

        MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://call_log/calls/"));
        startActivity(MyIntent);

    }

    public void galleryButtonClicked(View view) {

        MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/external/images/media/"));
        startActivity(MyIntent);
    }

    public void dialPadButtonClicked(View view) {

        MyIntent = new Intent(Intent.ACTION_DIAL);
        String number = DataEditText.getText().toString();
        MyIntent.setData(Uri.parse("tel:" + number));
        startActivity(MyIntent);
    }


}
