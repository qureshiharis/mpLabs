package com.second.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyItem> MyListItems;
    private Context MyContext;

    ////////////////////// CONSTRUCTOR ////////////////////////

    public MyAdapter(List<MyItem> myListItems, Context myContext) {
        MyListItems = myListItems;
        MyContext = myContext;
    }

    ///////////////////////// ABSTRACT METHODS ////////////////////////////////

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View MyView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_items, viewGroup, false);
        return new ViewHolder(MyView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        MyItem MyItemObject = MyListItems.get(i);
        viewHolder.MyTitleTextView.setText(MyItemObject.getItem());

    }

    @Override
    public int getItemCount() {
        return MyListItems.size();
    }

    ////////////////////// INNER CLASS ////////////////////////

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView MyTitleTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            MyTitleTextView = (TextView) itemView.findViewById(R.id.my_text_view);

            MyTitleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int MyPosition = getAdapterPosition();
                    Toast MyToast = Toast.makeText(MyContext, "Cop " + MyPosition, Toast.LENGTH_SHORT);
                    MyToast.show();
                }
            });
        }
    }
}
