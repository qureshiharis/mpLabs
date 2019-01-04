package com.example.haris.ubuntulab6test0;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class TaskTwoFragmentList extends ListFragment {

    static interface MyListListener {

        void itemClicked(long id);
    };

    private MyListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<String> myArrayList = new ArrayList<>();

        for(int i = 0; i<50; i++) {

            myArrayList.add("Book code #493" + i );

        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, myArrayList);

        setListAdapter(myArrayAdapter);


        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (MyListListener) context;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener!= null) {

            listener.itemClicked(id);
        }

    }
}
