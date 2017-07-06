package com.example.man.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> items;
ArrayAdapter<String> itemsAdapter;
ListView lvlItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvlItems = ((ListView) findViewById(R.id.lvlItems));
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        lvlItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
    }
}
