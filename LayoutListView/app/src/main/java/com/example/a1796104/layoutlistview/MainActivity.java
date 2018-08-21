package com.example.a1796104.layoutlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] myStringArray ={"John", "Doe", "Jane", "Foo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.per_item_layout, myStringArray);

        ListView mylistview = findViewById(R.id.list_view);
        mylistview.setAdapter(adapter);

    }
}
