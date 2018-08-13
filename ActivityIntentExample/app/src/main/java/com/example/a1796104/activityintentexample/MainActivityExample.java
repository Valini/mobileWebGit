package com.example.a1796104.activityintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_example);

    }


    public void startSecondActivity(View view){
        Intent intentToStartActivity = new Intent(MainActivityExample.this, MainActivity2.class);
        intentToStartActivity.putExtra(Intent.EXTRA_TEXT, "This is extra text");
        startActivity(intentToStartActivity);



    }


}
