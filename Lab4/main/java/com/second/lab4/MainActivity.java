package com.second.lab4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar MyToolbar;
    ListView MyListView;
    ActionMode MyActionMode;
    ArrayList<String> MyArrayList;

    // creating an array adapter to add our arraylist in our listview
    ArrayAdapter<String> MyAdapter;
    int MyAdapterPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListView = findViewById(R.id.my_list_view);
        MyToolbar = findViewById(R.id.my_toolbar);

        // setting the toolbar on our activity
        setSupportActionBar(MyToolbar);

        MyArrayList = new ArrayList<String>();

        for(int i=1; i<=50; i++) {

            MyArrayList.add("Drone " + i);

        }

        // an adapter works like a connector or bridge between two things
        MyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, MyArrayList);
        MyListView.setAdapter(MyAdapter);

        //////////// SINGLE PRESS or SINGLE CLICK //////////////

        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String ArrayText = MyListView.getItemAtPosition(position).toString();
                CharSequence text = "This is " + ArrayText;

                Toast MyToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                MyToast.show();
            }
        });

        //////////// LONG PRESS ///////////////////

        MyListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                MyAdapterPosition = position;
                MyActionMode = MainActivity.this.startActionMode(MyCallBack);
                MyListView.setSelected(true);
                MyListView.setItemChecked(position, true);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // inflate the menu and then add items to the bar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int MyItemId = item.getItemId();
        Toast MyToast;
        int duration = Toast.LENGTH_SHORT;

        switch(MyItemId) {

            case R.id.my_happy_icon:
                // do something when happy icon is selected

                MyToast = Toast.makeText(this, "Happy me", duration);
                MyToast.show();

                return true;

            case R.id.my_sad_icon:
                // do something when sad icon is selected

                MyToast = Toast.makeText(this, "Sad me", duration);
                MyToast.show();

                return true;

            case R.id.my_warning_icon:
                // do something when warning icon is selected

                MyToast = Toast.makeText(this, "Warning", duration);
                MyToast.show();

                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    /////////////////// ANONYMOUS CLASS METHODS , CALL BACK METHODS FOR ACTION MODE //////////////

    private ActionMode.Callback MyCallBack = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            actionMode.getMenuInflater().inflate(R.menu.contexual_menu, menu);
            return true;
        }

        @Override
        public boolean onActionItemClicked(final ActionMode actionMode, MenuItem menuItem) {

            switch (menuItem.getItemId()) {

                case R.id.my_delete_icon:

                    // when delete icon is selected, alert appears with options to delete or not

                    AlertDialog.Builder MyAlertBuilder = new AlertDialog.Builder(MainActivity.this);

                    // set main title of alert box and the message inside

                    MyAlertBuilder.setTitle("Confirm");
                    MyAlertBuilder.setMessage("Are you sure you want to delete the selected Drone?");

                    // dialog buttons

                    MyAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // WHEN YES BUTTON IS CLICKED
                            // ADD FUNCTIONALITY TO DELETE THE LISTVIEW ITEM

                            CharSequence text = "Drone deleted";


                            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                            actionMode.finish();

                            MyArrayList.remove(MyAdapterPosition);
                            MyAdapter.notifyDataSetChanged(); // this refreshes our listview

                        }
                    });

                    MyAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // WHEN CLICKED CANCEL
                            // DO NOTHING

                            Toast.makeText(getApplicationContext(), "Operation cancelled", Toast.LENGTH_SHORT).show();
                            actionMode.finish();

                        }
                    });

                    MyAlertBuilder.show();

            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };


}
