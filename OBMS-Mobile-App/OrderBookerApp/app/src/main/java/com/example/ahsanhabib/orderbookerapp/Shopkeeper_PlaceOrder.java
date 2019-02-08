package com.example.ahsanhabib.orderbookerapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import Adapter.DistributorAdapter;
import Helper.Helper;
import Model.Distributor;
import Model.Shopkeeper;

public class Shopkeeper_PlaceOrder extends AppCompatActivity {

    String value,value2;
    public static final String Id = "id";
    String type = "getDistributorListSpinner";
    //String[] distributorName;

    Helper helper = new Helper();

//    String Distributor_List_URL = "http://192.168.0.104:8080/FYP/obms/script/getDistributorList.php";

    SessionManager sessionManager;

    ListView listView;

    ArrayList<Distributor> listItems = new ArrayList<>();
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__place_order);
        listView = (ListView) findViewById(R.id.listview);

        sessionManager = new SessionManager(this);
        value = sessionManager.sharedpreferences.getString("ID","ID");
        value2 = sessionManager.sharedpreferences.getString("NAME", "NAME");

    }

    public void onStart(){
        super.onStart();
        Background background = new Background();
        background.execute(type, value, value2);

    }



public class Background extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... params) {

        type = params[0];

        if (type.equals("getDistributorListSpinner")) {
            try {
                String id = params[1];

                URL url = new URL(helper.Distributor_List_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        Log.i("RESPONSE", result + "");

        try {
            //result = "[{\"id\":\"1\",\"name\":\"Ali Distributor\"},{\"id\":\"2\",\"name\":\"Aziz Distributor\"}]";
            JSONArray jsonArray = new JSONArray(result);
            Log.i("LENGTH",jsonArray.length()+"");
            if(jsonArray.length()>0){
                //{\"id\":\"8\",\"name\":\"Aliasghar\",\"email\":\"ali@gmail.com\",\"region\":\"North\",\"shop_name\":\"Ali cabin\"}
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Distributor distributor = new Distributor();
                    distributor.setId(jsonObject.getString("id"));
                    distributor.setName(jsonObject.getString("name"));
                    distributor.setContact(jsonObject.getString("contact"));
                    distributor.setEmail(jsonObject.getString("email"));
                    distributor.setAddress(jsonObject.getString("address"));
                    distributor.setRegion(jsonObject.getString("region"));

                    listItems.add(distributor);
                }

                DistributorAdapter adapter= new DistributorAdapter(Shopkeeper_PlaceOrder.this,listItems);
                listView.setAdapter(adapter);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }
}