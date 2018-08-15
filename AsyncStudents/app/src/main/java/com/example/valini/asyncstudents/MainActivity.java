package com.example.valini.asyncstudents;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   List<Student> studentList = new ArrayList();

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

        if (selectedItemId == R.id.allStudents) {
            new GetAllStudents().execute();

        }
        else if (selectedItemId == R.id.studentId) {
            new GetRandomStudentId().execute();

        }
        else if (selectedItemId == R.id.studentInfo) {
            new GetRandomStudentInfo().execute();

        }

        return true;
    }

    public class GetAllStudents extends AsyncTask<String, String, List<Student>> {

        @Override
        protected void onPreExecute() {

            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Data Starting to Load...");
        }

        @Override
        protected List<Student> doInBackground(String... strings) {

            String response = "";
            String title = "";
            Student s1 = new Student();
            s1.setStudentId(1);
            s1.setStudentName("John");
            studentList.add(s1);

            Student s2 = new Student();
            s2.setStudentId(2);
            s2.setStudentName("James");
            studentList.add(s2);

            Student s3 = new Student();
            s3.setStudentId(3);
            s3.setStudentName("Pam");
            studentList.add(s3);

            Student s4 = new Student();
            s4.setStudentId(4);
            s4.setStudentName("John");
            studentList.add(s4);

            Student s5 = new Student();
            s5.setStudentId(5);
            s5.setStudentName("James");
            studentList.add(s5);

            Student s6 = new Student();
            s6.setStudentId(6);
            s6.setStudentName("Pam");
            studentList.add(s6);

            Student s7 = new Student();
            s7.setStudentId(7);
            s7.setStudentName("Pam");
            studentList.add(s7);


            return studentList;
        }

        @Override
        protected void onPostExecute(List<Student> s) {
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student List:" + "\n");
            for(Student student : s) {
                tvResults.append(student.getStudentName()+ "\n");
            }


        }


    }

    public class GetRandomStudentId extends AsyncTask<String, String, Integer> {

        @Override
        protected void onPreExecute() {


            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Data Starting to Load...");
        }

        @Override
        protected Integer doInBackground(String... strings) {


            Student s1 = new Student();
            s1.setStudentId(1);
            s1.setStudentName("John");
            studentList.add(s1);

            Student s2 = new Student();
            s2.setStudentId(2);
            s2.setStudentName("James");
            studentList.add(s2);

            Student s3 = new Student();
            s3.setStudentId(3);
            s3.setStudentName("Pam");
            studentList.add(s3);

            Student s4 = new Student();
            s4.setStudentId(4);
            s4.setStudentName("John");
            studentList.add(s4);

            Student s5 = new Student();
            s5.setStudentId(5);
            s5.setStudentName("James");
            studentList.add(s5);

            Student s6 = new Student();
            s6.setStudentId(6);
            s6.setStudentName("Pam");
            studentList.add(s6);

            Student s7 = new Student();
            s7.setStudentId(7);
            s7.setStudentName("Pam");
            studentList.add(s7);



            Random rand = new Random();
            int  n = rand.nextInt(studentList.size());
            Student s = (Student)studentList.get(n);


            return s.getStudentId();
        }

        @Override
        protected void onPostExecute(Integer s) {
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student ID:" + s);



        }


    }

    public class GetRandomStudentInfo extends AsyncTask<String, String, Student> {

        @Override
        protected void onPreExecute() {


            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Data Starting to Load...");
        }

        @Override
        protected Student doInBackground(String... strings) {


            Student s1 = new Student();
            s1.setStudentId(1);
            s1.setStudentName("John");
            studentList.add(s1);

            Student s2 = new Student();
            s2.setStudentId(2);
            s2.setStudentName("James");
            studentList.add(s2);

            Student s3 = new Student();
            s3.setStudentId(3);
            s3.setStudentName("Pam");
            studentList.add(s3);

            Student s4 = new Student();
            s4.setStudentId(4);
            s4.setStudentName("John");
            studentList.add(s4);

            Student s5 = new Student();
            s5.setStudentId(5);
            s5.setStudentName("James");
            studentList.add(s5);

            Student s6 = new Student();
            s6.setStudentId(6);
            s6.setStudentName("Pam");
            studentList.add(s6);

            Student s7 = new Student();
            s7.setStudentId(7);
            s7.setStudentName("Pam");
            studentList.add(s7);



            Random rand = new Random();
            int  n = rand.nextInt(studentList.size());
            Student s = (Student)studentList.get(n);


            return s;
        }

        @Override
        protected void onPostExecute(Student s) {
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student ID:" + s.getStudentId() + "\n" + "Student Name" + s.getStudentName() + "\n");



        }


    }


}
