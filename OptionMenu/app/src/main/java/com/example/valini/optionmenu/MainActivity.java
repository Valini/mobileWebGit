package com.example.valini.optionmenu;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList studentList = new ArrayList();
    TextView textViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();

        if(selectedItemId== R.id.menuItem1){
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

            Random rand = new Random();
            int  n = rand.nextInt(studentList.size());
            Student s = (Student)studentList.get(n);
            String line1 = "Selected Student ID : " + s.getStudentId() + "\n";
            String line2 = "Selected Student Name : " + s.getStudentName();
            textViewResults = findViewById(R.id.textViewResults);
            textViewResults.setText(line1);
            textViewResults.append(line2);



        }

        else if (selectedItemId==R.id.menuItem2){

            Resources res = getResources();
            String[] planets = res.getStringArray(R.array.planets_array);
            textViewResults = findViewById(R.id.textViewResults);
            textViewResults.setText("Lists of planets "+ "\n");
            for( int i=0; i< planets.length ; i++){


                textViewResults.append(planets[i] + "\n");

            }



        }
        else {

            return super.onOptionsItemSelected(item);
        }

        return true;
    }


    public void getAllInfo (MenuItem item){

        Random rand = new Random();
        int  n = rand.nextInt(studentList.size());
        Student s = (Student)studentList.get(n);
        String line1 = "Selected Student ID : " + s.getStudentId() + "\n";
        String line2 = "Selected Student Name : " + s.getStudentName();
        textViewResults = findViewById(R.id.textViewResults);
        textViewResults.setText(line1);
        textViewResults.append(line2);

        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets_array);

        for( int i=0; i< planets.length ; i++){


            textViewResults.append("\n" + planets[i] + "\n");

        }


        Toast.makeText(MainActivity.this, "Hi there! This is a Toast", Toast.LENGTH_LONG).show();

    }
}
