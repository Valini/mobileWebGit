package com.example.valini.task3;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView studentView;
    ArrayList studentList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student s1 = new Student();
        s1.setStudentId(1);
        s1.setStudentName("John");
        studentList.add(s1);
        Student s2 = new Student();
        s2.setStudentId(2);
        s2.setStudentName("James");
        studentList.add(s2);
        Student s3 = new Student();
        s3.setStudentId(3);
        s3.setStudentName("Pam");
        studentList.add(s3);
    }


    public void getStudentInfo (View view){

        Random rand = new Random();
        int  n = rand.nextInt(studentList.size());
        Student s = (Student)studentList.get(n);
        String line1 = "Selected Student ID : " + s.getStudentId() + "\n";
        String line2 = "Selected Student Name : " + s.getStudentName();
        studentView = findViewById(R.id.studentView);
        studentView.setText(line1);
        studentView.append(line2);

        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets_array);

        for( int i=0; i< planets.length ; i++){


            studentView.append("\n" + planets[i] + "\n");

        }


        Toast.makeText(MainActivity.this, "Hi there! This is a Toast", Toast.LENGTH_LONG).show();

    }
}
