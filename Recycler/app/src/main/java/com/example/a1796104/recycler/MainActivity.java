package com.example.a1796104.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> studentList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");
        studentList.add("Valini");
        studentList.add("Suim");

        initRecylerView();
    }

    public void initRecylerView(){
        RecyclerView myRcView = findViewById(R.id.rc_view);

        String[] strings ={"James", "Sean", "Steve", "Jane", "Peter"};
        UserAdapter userAdapter = new UserAdapter(strings);

        //userAdapter.studentList = studentList;

        myRcView.setAdapter(userAdapter);
        myRcView.setLayoutManager(new LinearLayoutManager(this));


    }
}
