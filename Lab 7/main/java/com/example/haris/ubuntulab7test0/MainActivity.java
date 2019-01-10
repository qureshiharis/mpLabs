package com.example.haris.ubuntulab7test0;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter myBluetoothAdapter;
    Button myTurnOnButton, myTurnOffButton, myPairButton, myVisibleButton;
    ListView myListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // intialize bluetooth adapter to use bluetooth
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //references to views
        myTurnOnButton = findViewById(R.id.turn_on_button);
        myTurnOffButton = findViewById(R.id.turn_off_button);
        myPairButton = findViewById(R.id.paired_button);
        myVisibleButton = findViewById(R.id.visible_button);
        myListView = findViewById(R.id.my_list_view);

        // on click listener turn on

        myTurnOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!myBluetoothAdapter.isEnabled()) {

                    Intent myIntentTurnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(myIntentTurnOn, 0);

                } else {

                    Toast.makeText(getApplicationContext(), "Already turned on", Toast.LENGTH_SHORT).show();
                }


            }
        });

        // on click listener turn off

        myTurnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myBluetoothAdapter.isEnabled()) {

                    myBluetoothAdapter.disable();

                } else {

                    Toast.makeText(getApplicationContext(), "Already turned off", Toast.LENGTH_SHORT).show();
                }


            }
        });

        // on click listener visibility

        myVisibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!myBluetoothAdapter.isDiscovering()) {

                    Intent myIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        // on click listener view discoverable devices

        myPairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Set<BluetoothDevice> myAvailableDevices = myBluetoothAdapter.getBondedDevices();

                // Adding available bluetooth names into a list

                List<String> myArrayList = new ArrayList<String>();
                for(BluetoothDevice myBluetoothDevices : myAvailableDevices) {
                    myArrayList.add(myBluetoothDevices.getName());
                }

                // creating adapter to add arraylist data to listview

                ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, myArrayList){};
                myListView.setAdapter(MyAdapter);



            }
        });

    } // end of onCreate
} // end of class

