package com.example.ayushyadav.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText nameEditText, otherDetailEditText;
    Button doneButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        nameEditText = findViewById(R.id.editActivityEditText1);
        otherDetailEditText = findViewById(R.id.editActivityEditText2);
        doneButton = findViewById(R.id.editActivityButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                String name = nameEditText.getText().toString();
                String otherDetail = otherDetailEditText.getText().toString();

                intent.putExtra("name_key",name);
                intent.putExtra("other_key",otherDetail);

                setResult(1,intent);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });
    }



}
