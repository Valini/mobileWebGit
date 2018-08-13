package com.example.a1796104.johnabbottintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            Uri geoLocation = Uri.parse("geo:45.4060, -73.9419?z=18");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }




    }
        else if (selectedItemId == R.id.website) {
            Uri uri = Uri.parse("http://www.johnabbott.qc.ca/");

            Intent openWebpageIntent = new Intent(Intent.ACTION_VIEW, uri);

            if(openWebpageIntent.resolveActivity(getPackageManager())!= null){


                startActivity(openWebpageIntent);
            }



        }


        else if (selectedItemId == R.id.collegeInfo) {

            Intent intentToStartActivity = new Intent(MainActivity.this, Main2Activity.class);
            intentToStartActivity.putExtra(Intent.EXTRA_TEXT, "This is extra text");
            startActivity(intentToStartActivity);

        }

        return true;
    }
}
