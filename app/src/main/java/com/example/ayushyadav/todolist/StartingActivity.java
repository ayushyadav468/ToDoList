package com.example.ayushyadav.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        startButton = findViewById(R.id.startButton);

        //Click Handled on Start Button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code to start another activity
                Intent intent =  new Intent(StartingActivity.this, MainActivity.class);
                //This line will start activity mentioned in intent object
                startActivity(intent);
            }
        });

    }


}
