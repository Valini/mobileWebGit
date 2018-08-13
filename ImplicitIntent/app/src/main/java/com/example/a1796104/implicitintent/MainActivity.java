package com.example.a1796104.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWebPageActivity(View view){

        Uri uri = Uri.parse("http://www.google.ca/");

        Intent openWebpageIntent = new Intent(Intent.ACTION_VIEW, uri);

        if(openWebpageIntent.resolveActivity(getPackageManager())!= null){


            startActivity(openWebpageIntent);
        }



    }


}
