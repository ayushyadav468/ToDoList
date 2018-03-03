package com.example.ayushyadav.todolist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //For Custom Adapter
    ListViewAdapter listViewAdapter;
    ArrayList<ListViewItem> listViewItems ;
    //Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To get any information send by the activity starting this activity
        Intent intent = getIntent();

        listView = findViewById(R.id.listView);

        //For getting an array list of the size given
        listViewItems = ListViewItem.dummyItems(null, 0);
        //Custom adapter for crating list view
        listViewAdapter = new ListViewAdapter(this, listViewItems);
        //For setting custom adapter to list view
        listView.setAdapter(listViewAdapter);

    }

    //Menu linked with Main Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.addItem){
            Intent intent =  new Intent(this, EditActivity.class);
            startActivityForResult(intent,1);

        }
        return super.onOptionsItemSelected(item);
    }
    //Result from activity started above
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            String name = data.getStringExtra("name_key");
            int otherDetail = data.getIntExtra("other_key",-1);
            listViewItems = ListViewItem.dummyItems(name, otherDetail);
        } else if(resultCode == 0){
            listViewItems = ListViewItem.dummyItems(null, -1);
        }
    }
}
