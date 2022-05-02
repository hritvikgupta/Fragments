package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements listfrag.ItemsSelected{

    TextView tvDescription;
    ArrayList<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription = findViewById(R.id.tvDiscription);

        description = new ArrayList<String>();
        description.add("Description for item:1 ");
        description.add("Description for item:2 ");
        description.add("Description for item:3 ");

    }

    //this method is implemented using option+enter after writing the listfrag.itemsSelected
    @Override
    public void OnItemSelected(int index) {
        // this takes the argument from the list fragment and wriiten in here of which index user selected
        //tv Description is Text view that we have created in Detail Fragments xml file and declared it here
        //tvDesciption set text to be viewed on Detaill Fragment.
        tvDescription.setText(description.get(index));


    }
}