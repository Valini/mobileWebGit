package com.example.valini.task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView firstTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String studentId[]={"1", "2" ,"3","1", "2" ,"3"};
        firstTextView= findViewById(R.id.firstTextView);
        firstTextView.setText("List of Student Ids:" + '\n');
        for( int i=0; i< studentId.length ; i++){


           firstTextView.append(studentId[i] + "\n");

        }

    }
}
