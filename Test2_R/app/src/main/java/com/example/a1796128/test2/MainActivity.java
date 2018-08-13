package com.example.a1796128.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.helloWorldTextView);

        myTextView.setText(R.string.second_string);

        Log.e("resource_value", Integer.toString(R.string.click_name));
        Log.e("resource_value2", Integer.toString(R.string.app_name));

    }
}
