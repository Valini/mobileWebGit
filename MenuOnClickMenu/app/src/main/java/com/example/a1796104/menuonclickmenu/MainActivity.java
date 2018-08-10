package com.example.a1796104.menuonclickmenu;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView firstTextView;

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


    public void randomStudent(MenuItem item) {

        String studentId[] = {"1", "2", "3", "4", "5"};
        Random r = new Random();
        int j = r.nextInt(studentId.length);


        firstTextView = findViewById(R.id.firstTextView);
        firstTextView.setText("Student Number: " + studentId[j]);

    }
}
