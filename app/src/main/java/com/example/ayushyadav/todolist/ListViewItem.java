package com.example.ayushyadav.todolist;

import java.util.ArrayList;

/**
 * Created by ayushyadav on 14/02/18.
 */

public class ListViewItem {

    private String name;
    private int price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListViewItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //creating items equal to the size given and adding them to array list
    static ArrayList<ListViewItem> dummyItems(String name, int price){
        ArrayList<ListViewItem> listViewItems = new ArrayList<>();
        ListViewItem listViewItem = new ListViewItem(name,price);
        //Items added in array list
        listViewItems.add(listViewItem);
        //Returned ArrayList object
        return listViewItems;
    }
}