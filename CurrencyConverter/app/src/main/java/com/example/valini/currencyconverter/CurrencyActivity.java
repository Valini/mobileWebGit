package com.example.valini.currencyconverter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class CurrencyActivity extends AppCompatActivity {
    private EditText currency;
    private TextView gbp;
    private TextView euro;
    private Button btn;
    private double dollars;

     private  double euroRate=0;
    private static double gbpRate=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        currency=(EditText)findViewById(R.id.tfCurrency);
        gbp=(TextView)findViewById(R.id.lblGBP);
        euro=(TextView)findViewById(R.id.lblEuro);
        btn=(Button)findViewById(R.id.btConvert);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                gbp.setText("wait...");
                euro.setText("wait");

                if(currency.getText().length()>0 && !currency.getText().equals(".")) {
                    dollars = new Double(currency.getText().toString());
                    new Calculate().execute();
                }

            }
            });
        }


    public class Calculate extends AsyncTask<String, String, Double> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Double doInBackground(String... strings) {
            String uRl;
            try {
//https://openexchangerates.org/account...api cd39788f963f4e689c8f6a335e08450b
                uRl = getJson("https://openexchangerates.org/api/latest.json?app_id=cd39788f963f4e689c8f6a335e08450b&symbols=EUR,GBP");
                JSONObject USDtoObj;
                USDtoObj = new JSONObject(uRl);
                JSONObject rates = USDtoObj.getJSONObject("rates");

                euroRate = rates.getDouble("EUR");
                gbpRate = rates.getDouble("GBP");


            } catch (IOException e) {
                e.printStackTrace();

            } catch (JSONException e) {
                e.printStackTrace();

            }
            return euroRate;



        }

        protected void onPostExecute(Double strings) {

            double  usdToEuro, usdToGbp;

            //euroRate= Double.parseDouble(result1);
          // euroRate=(result1);
             //gbpRate= Double.parseDouble(result[1]);
           // gbpRate= (result2);

             usdToEuro=euroRate*dollars;
             euro.setText(""+usdToEuro);
            usdToGbp=gbpRate*dollars;
            gbp.setText(""+usdToGbp);


        }

        public String getJson(String url) throws ClientProtocolException, IOException {
            StringBuilder build = new StringBuilder();
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String con;
            while ((con = reader.readLine()) != null) {

                build.append(con);

            }
            return build.toString();
        }

    }


}
