package com.example.valini.asyncrest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {

        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
        URL apiUrl;
        try {
            apiUrl = new URL("https://jsonplaceholder.typicode.com/todos/1");
            new FetchDataFromApi().execute(apiUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    //implementing async task
    public class FetchDataFromApi extends AsyncTask< URL, Void, String> {

        @Override
        protected void onPreExecute() {
            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Data Starting to Load...");
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL myURL = urls[0];
            String response = "";
            String title = "";
            try {
                response = NetworkUtility.getResponseFromHttpUrl(myURL);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onPostExecute(String s) {
            String title = "";
            int userId=0;
            String complete = "";
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(s);
                userId= (Integer) jsonObj.get("userId");
                title = (String) jsonObj.get("title");
                complete = (String) jsonObj.get("complete");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            TextView tvResults = findViewById(R.id.tvResults);
            tvResults.setText("Title:" + title + "\n");
            tvResults.append("User Id:" + userId + "\n");
            tvResults.append("Complete:" + complete + "\n");
        }


    }
}
