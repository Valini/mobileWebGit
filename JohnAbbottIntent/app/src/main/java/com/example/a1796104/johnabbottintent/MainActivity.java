package com.example.a1796104.johnabbottintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Valini", "onCreate");
    }


    @Override
    protected void onStart() {
        Log.i("Valini", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("Valini", "onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i("Valini", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.i("Valini", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("Valini", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("Valini", "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();

        if (selectedItemId == R.id.location) {

            //IMPLICIT INTENT
            Uri geoLocation = Uri.parse("geo:45.4060, -73.9419?z=18");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }




    }
        else if (selectedItemId == R.id.website) {

            //IMPLICIT INTENT
            Uri uri = Uri.parse("http://www.johnabbott.qc.ca/");

            Intent openWebpageIntent = new Intent(Intent.ACTION_VIEW, uri);

            if(openWebpageIntent.resolveActivity(getPackageManager())!= null){


                startActivity(openWebpageIntent);
            }


        }


        else if (selectedItemId == R.id.collegeInfo) {
            //EXPLICIT INTENT
            Intent intentToStartActivity = new Intent(MainActivity.this, Main2Activity.class);
            intentToStartActivity.putExtra(Intent.EXTRA_TEXT, "This is extra text");
            startActivity(intentToStartActivity);

        }

        return true;
    }
}
