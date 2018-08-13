package com.example.valini.asyncstudentsbackend;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<Student> studentListLoaded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetAllStudents().execute();
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

            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student List:" + "\n");
            for(Student student : studentListLoaded) {
                tvResults.append(student.getStudentName()+ "\n");
            }

        }
        else if (selectedItemId == R.id.studentId) {
            Random rand = new Random();
            int  n = rand.nextInt(studentListLoaded.size());
            Student s = (Student)studentListLoaded.get(n);

            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student ID:"+ (s.getStudentId()+""));

        }
        else if (selectedItemId == R.id.studentInfo) {

            Random rand = new Random();
            int  n = rand.nextInt(studentListLoaded.size());
            Student s = (Student)studentListLoaded.get(n);
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Student ID: " + s.getStudentId() + "\n" + "Student Name : " + s.getStudentName() + "\n");

        }

        return true;
    }



    public class GetAllStudents extends AsyncTask<String, String, List<Student>> {

        @Override
        protected void onPreExecute() {


            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("\n" +"Data Starting to Load...");
        }

        @Override
        protected List<Student> doInBackground(String... strings) {
            List<Student> studentList = new ArrayList();

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
           studentListLoaded= new ArrayList();
            studentListLoaded =s;
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Data has been Loaded");



        }


    }

}
