package com.example.hp.fyat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Student_Info extends AppCompatActivity {


    private ListView postList;
    private ArrayList<String> listArray;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__info);


        //show users posts
        postList=(ListView)findViewById(R.id.postList_id);
        listArray=new ArrayList<String>();

        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listArray);
        postList.setAdapter(listAdapter);
        listArray.add("I may fail in this semister ," +
                "should i sign up for RS in the next semister?");
        listArray.add("Consultation needed");
    }
}
