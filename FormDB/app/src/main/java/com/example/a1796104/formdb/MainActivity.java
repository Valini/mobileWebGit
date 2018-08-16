package com.example.a1796104.formdb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText addressEditText;
    EditText phoneEditText;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void saveVariables(View view){

       nameEditText = findViewById(R.id.tv_nameInput);
       addressEditText = findViewById(R.id.tv_addressInput);
       phoneEditText=findViewById(R.id.tv_phoneInput);

       String name = nameEditText.getText().toString();
       String address = addressEditText.getText().toString();
       String phone = phoneEditText.getText().toString();


        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setPhone(phone);
        studentList.add(student);

        //clear
        nameEditText.setText("");
        addressEditText.setText("");
        phoneEditText.setText("");

    }

    public void logAllEntries (View view) {

        TextView tvResults = findViewById(R.id.tv_results);
        tvResults.setText("Student List:" + "\n");
        for(Student student : studentList) {
            tvResults.append(student.getName() + "||" + student.getAddress() + "||" + student.getPhone() + "\n");
        }


    }

    public void saveValuesToDB(View view){
        MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
        //creating an instance of the db
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //get the values
        nameEditText = findViewById(R.id.tv_nameInput);
        addressEditText = findViewById(R.id.tv_addressInput);
        phoneEditText=findViewById(R.id.tv_phoneInput);

        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        //to help you insert data
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("phone", phone);
        //nullCoLumnHack:null does not allow null entry. To allow null pass  nullCoLumnHack:"name"
        long rowId = db.insert("user", null,values);

        //print the id of the new row inserted
        Log.i("MyTag", "Row Number is " +rowId);

        //clear
        nameEditText.setText("");
        addressEditText.setText("");
        phoneEditText.setText("");

    }

    public void fetchDataFromDB(View view){

        MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //mention which columns to fetch
        String [] columns ={"name", "address", "phone"};
        Cursor cursor = db.query("user", columns, null, null, null, null, null );

        cursor.moveToFirst();
        Log.i("ValueFromDB", cursor.getString(2));

        TextView tvResults = findViewById(R.id.tv_results);
        tvResults.setText("Student List:" + "\n");

        while (cursor.moveToNext()) {

            tvResults.append(cursor.getString(0) + "||" +cursor.getString(1) + "||" + cursor.getString(2) + "\n");
        }


    }






}
