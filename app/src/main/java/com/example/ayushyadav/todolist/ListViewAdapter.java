package com.example.ayushyadav.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayushyadav on 14/02/18.
 */
//Custom adapter(every adapter extends base adapter class)
public class ListViewAdapter extends BaseAdapter {


    ArrayList<ListViewItem> listViewItems;
    Context context;

    public ListViewAdapter(Context context, ArrayList<ListViewItem> listViewItems) {
        this.listViewItems = listViewItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public ListViewItem getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //To remove any delay in scrolling we use convert View as it contain list view object which are already made
        View view = convertView;
        if(convertView == null){
            //To get layout inflator service from context
            view = layoutInflater.inflate(R.layout.listview_item,parent,false);
            //To hold view
            ViewHolder holder = new ViewHolder();
            //As view does not have a scope out side these brackets
            //We set tag as to get it any where in the class
            view.setTag(holder);
        }
        //To extract tag from view
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        //To get the position of item
        ListViewItem listViewItem = getItem(position);

        //These are properties of Text View
        viewHolder.name.setText(listViewItem.getName());
        viewHolder.price.setText(listViewItem.getPrice() + "");

        return view;
    }

    class ViewHolder{
        TextView name;
        TextView price;
    }

}