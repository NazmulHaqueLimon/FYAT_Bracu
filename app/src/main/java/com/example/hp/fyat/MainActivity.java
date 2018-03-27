package com.example.hp.fyat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView newsAndEvents;
    private ArrayList<String> ListArray;
    private ArrayAdapter<String> ListAdapter;
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textView4);
        tv2=(TextView)findViewById(R.id.textView5);

        //homepage list view for news and events
        newsAndEvents=(ListView)findViewById(R.id.listView_id);
        ListArray=new ArrayList<String>();

        ListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ListArray);
        newsAndEvents.setAdapter(ListAdapter);
        ListArray.add("Seminar on Carear Boost");
        ListArray.add("RS Campus visit");
        //setupListViewListener();
    }

    public void userSignUp(View view){
        switch (view.getId()){
            case R.id.signUpButton1:
                startActivity(new Intent(this, SignUp.class));


                break;

        }
    }



}
