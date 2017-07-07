package com.example.man.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String task = getIntent().getStringExtra("taskName");
        String position = getIntent().getStringExtra("taskPos");


       TextView tv1 = (TextView) findViewById(R.id.textView);
        tv1.setText(task);

        TextView tv2 = (TextView) findViewById(R.id.textView4);
        tv2.setText(position);

    }

  /*  public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    */



}