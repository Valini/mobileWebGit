package com.example.a1796104.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void getHeight(View view){

        Button button= findViewById(R.id.btn_layout);
        button.setPadding(100, 120,120,120);
        Integer height = button.getHeight();
        Integer width = button.getWidth();

        TextView textView= findViewById(R.id.tv_results);
        textView.setText("Width:"+ width + "Height:" + height );





    }
}
