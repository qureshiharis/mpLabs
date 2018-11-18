package com.second.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView MyRecyclerView;
    RecyclerView.Adapter MyAdapter;

    List<MyItem> MyAddedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up recycler view

        MyRecyclerView = findViewById(R.id.my_recycler_view);
        MyRecyclerView.setHasFixedSize(true);
        MyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // creating an arraylist and populating it and putting it in List created of MyItem.java

        MyAddedItems = new ArrayList<>();

        for(int i=0; i<=50; i++) {

            MyItem NewItem = new MyItem("Robocop " + i);
            MyAddedItems.add(NewItem);

        }

        // creating an adapter object from MyAdapter.java class and setting it to our recycler view

        MyAdapter = new MyAdapter(MyAddedItems, this);
        MyRecyclerView.setAdapter(MyAdapter);


    }
}
