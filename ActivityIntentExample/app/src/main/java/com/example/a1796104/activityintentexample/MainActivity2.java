package com.example.a1796104.activityintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView child_tv = findViewById(R.id.child_tv);
        Intent intentReceived = getIntent();

        if(intentReceived.hasExtra((Intent.EXTRA_TEXT))){
            String stringReceived = intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            child_tv.append("\n"+stringReceived);


        }
    }


}
