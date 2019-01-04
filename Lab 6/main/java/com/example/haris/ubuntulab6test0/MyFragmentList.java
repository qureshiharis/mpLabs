package com.example.haris.ubuntulab6test0;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MyFragmentList extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<String> myArrayList = new ArrayList<>();

        for(int i = 0; i<50; i++) {

            myArrayList.add("Item number " + i );

        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, myArrayList);

        setListAdapter(myArrayAdapter);


        return super.onCreateView(inflater, container, savedInstanceState);

    }

}
