package com.example.valini.tempconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;

public class TestActivity extends AppCompatActivity {
EditText temp;
RadioButton toCelsius;
RadioButton toFarenheit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        temp=(EditText)findViewById(R.id.TemperatureEditText);
        toCelsius=(RadioButton)findViewById(R.id.rbToCelsius);
        toFarenheit=(RadioButton)findViewById(R.id.rbToFarenheit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void convert(View view){
        double Celsius;
        double Farenheit;
        double value=new Double(temp.getText().toString());
        if(toCelsius.isChecked()){
            Celsius=UnitConverter.FahrenheitToCelsius(value);

            temp.setText(new Double(Celsius).toString());
        }
        else{
          Farenheit=UnitConverter.celsiusToFahrenheit(value);
            temp.setText(new Double(Farenheit).toString());

        }

    }
    public void clear(View view){

        String empty="0";
        temp.setText(new Double(empty).toString());

    }
}
