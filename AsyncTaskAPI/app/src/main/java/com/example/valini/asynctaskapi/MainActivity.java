package com.example.valini.asynctaskapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<String> studentIDList = new ArrayList<String>();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemSelected=item.getItemId();

        if(itemSelected==R.id.mi_allStudents){
            URL apiUrl;
            try {
                apiUrl = new URL("https://jsonplaceholder.typicode.com/users");
                new FetchStudentList().execute(apiUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        else if (itemSelected==R.id.mi_randomID){
            URL apiUrl;
            try {
                apiUrl = new URL("https://jsonplaceholder.typicode.com/users");
                new FetchDataRandom().execute(apiUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }
        else if (itemSelected==R.id.mi_studentInfo){
            URL apiUrl;
            try {
                apiUrl = new URL("https://jsonplaceholder.typicode.com/users");
                new FetchDataRandomInfo().execute(apiUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }

        return true;

    }

    public class FetchStudentList extends AsyncTask< URL, Void, String> {

        @Override
        protected void onPreExecute() {
            TextView tvResults = findViewById(R.id.tv_Results);
            tvResults.setText("Data Starting to Load...");
        }


        @Override
        protected String doInBackground(URL... urls) {
            URL myURL = urls[0];
            String response="";

            try {
                response = NetWorkUtility.getResponseFromHttpUrl(myURL);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView tv = findViewById(R.id.tv_Results);
            tv.setText("Student Results:"+"\n");
            try {
            JSONArray jsonarray = new JSONArray(s);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String name = jsonobject.getString("name");

                    tv.append(name+"\n");
                }
            }

            catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }

    public class FetchDataRandom extends AsyncTask< URL, Void, String> {

        @Override
        protected void onPreExecute() {
            TextView tvResults = findViewById(R.id.tv_Results);
            tvResults.setText("Data Starting to Load...");
        }


        @Override
        protected String doInBackground(URL... urls) {
            URL myURL = urls[0];
            String response="";

            try {
                response = NetWorkUtility.getResponseFromHttpUrl(myURL);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView tv = findViewById(R.id.tv_Results);
            tv.setText("Random Student ID:"+"\n");
            try {
                JSONArray jsonarray = new JSONArray(s);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String id = jsonobject.getString("id");
                    studentIDList.add(id);

                }

                Random rand = new Random();
                int  n = rand.nextInt(studentIDList.size());
                String studentId = studentIDList.get(n);
                tv.append(studentId+"\n");
            }

            catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }

    public class FetchDataRandomInfo extends AsyncTask< URL, Void, String> {

        @Override
        protected void onPreExecute() {
            TextView tvResults = findViewById(R.id.tv_Results);
            tvResults.setText("Data Starting to Load...");
        }


        @Override
        protected String doInBackground(URL... urls) {
            URL myURL = urls[0];
            String response="";

            try {
                response = NetWorkUtility.getResponseFromHttpUrl(myURL);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView tv = findViewById(R.id.tv_Results);
            tv.setText("Random Student ID:"+"\n");
            try {

                JSONArray jsonarray = new JSONArray(s);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    Student student = new Student(); //FIX ME!
                    student.setStudentId(jsonobject.getString("id"));
                    student.setStudentName(jsonobject.getString("name"));
                    //jsonobject.getString("email");
                    studentList.add(student);
                }

                Random rand = new Random();
                int  n = rand.nextInt(studentList.size());
                Student student = (Student)studentList.get(n);
                TextView tvResults = findViewById(R.id.tv_Results);
                tvResults.setText("Student ID:" + student.getStudentId() + "\n" + "Student Name" + student.getStudentName() + "\n");

            }

            catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }

}
