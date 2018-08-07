package com.example.a1796104.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView firstTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTextView = (TextView) findViewById(R.id.firstTextView);
        firstTextView.append("This is a test");
        firstTextView.isShown();
    }
}
