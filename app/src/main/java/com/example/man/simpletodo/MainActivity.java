package com.example.man.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
        readItems();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvlItems.setAdapter(itemsAdapter);
        // items.add("First Item");
        //  items.add("Second Item");
        setupListViewListener();
        //toast();

    }


    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();

    }

    public void toast() {

        Toast.makeText(getApplicationContext(), "toast",
                Toast.LENGTH_SHORT).show();

    }

//    public void setupListViewListener() {
//        lvlItems.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//
//                    @Override
//
//                    public void onItemClick(AdapterView<?> adapter,
//                                                   View item, int pos, long id) {
//                        items.remove(pos);
//                        // writeItems();
//                        itemsAdapter.notifyDataSetChanged(); //refresh self
//                        //return true;
//                    }
//                }
//        );
//    }


    public void setupListViewListener() {
        lvlItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {

                    @Override

                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        items.remove(pos);
                        writeItems();
                        itemsAdapter.notifyDataSetChanged(); //refresh self
                        return true;
                    }
                }
        );
        lvlItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override

                    public void onItemClick(AdapterView<?> adapter,
                                            View item, int pos, long id) {
                        //toast();
// creating list of item properties
                        String listValue = String.valueOf(adapter.getAdapter().getItem(pos)) + ", " + String.valueOf(pos) + ", " + String.valueOf(id);
                        String taskName = String.valueOf(adapter.getAdapter().getItem(pos));
                        String taskPos = String.valueOf(pos);

//displaying in toast
                        Toast toast1 = Toast.makeText(getApplicationContext(), listValue, Toast.LENGTH_SHORT);
                        toast1.show();


                        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                        // put "extras" into the bundle for access in the second activity
                        i.putExtra("taskName", taskName);
                        i.putExtra("taskPos", taskPos);
                        // brings up the second activity
                        startActivity(i);

                    }
                }
        );

    }

//    public void launchComposeView() {
//        // first parameter is the context, second is the class of the activity to launch
//        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
//        startActivity(i); // brings up the second activity
//        // put "extras" into the bundle for access in the second activity
//        i.putExtra("entry", pos);
//        i.putExtra("in_reply_to", "george");
//        i.putExtra("code", 400);
//        // brings up the second activity
//        startActivity(i);
//
//
//    }

    private void readItems() {

        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));

        } catch (IOException e) {
            items = new ArrayList<String>();
        }

    }


    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}





