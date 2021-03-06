package com.example.ahsanhabib.orderbookerapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
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

import Adapter.CompletedOrderAdapter;
import Adapter.ShopkeeperAdapter;
import Helper.Helper;
import Model.FinalList;
import Model.Shopkeeper;

public class Distributor_CompletedOrder extends AppCompatActivity {

    String value,value2;

    String type = "getShopkeeperList";

    Helper helper = new Helper();

    SessionManager sessionManager;

    ListView listView;

    ArrayList<FinalList> listItems = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor__completed_order);

        listView = (ListView) findViewById(R.id.completedOrderList);

        sessionManager = new SessionManager(this);
        value = sessionManager.sharedpreferences.getString("ID","ID");
        value2 = sessionManager.sharedpreferences.getString("NAME", "NAME");

        Background background = new Background();
        background.execute(type, value);
    }

    public void onStart(){
        super.onStart();


    }

    public class Background extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            type = params[0];

            if (type.equals("getShopkeeperList")) {
                try {
                    String id = params[1];

                    URL url = new URL(helper.Shopkeeper_List_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data =
                            URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    bufferedWriter.write(post_data);
                    Log.d("Shopkeeper past order", post_data);
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
                    Log.d("Response pastorder", result + "");
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



            try {
                //result = "[{\"id\":\"1\",\"name\":\"Ali Distributor\"},{\"id\":\"2\",\"name\":\"Aziz Distributor\"}]";
                JSONArray jsonArray = new JSONArray(result);
                Log.i("LENGTH",jsonArray.length()+"");
                if(jsonArray.length()>0){
                    //{\"id\":\"8\",\"name\":\"Aliasghar\",\"email\":\"ali@gmail.com\",\"region\":\"North\",\"shop_name\":\"Ali cabin\"}
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        FinalList shopkeeper = new FinalList();
                        shopkeeper.setId(jsonObject.getString("id"));
                        shopkeeper.setName(jsonObject.getString("name"));
                        shopkeeper.setContact(jsonObject.getString("contact"));
                        shopkeeper.setEmail(jsonObject.getString("email"));
                        shopkeeper.setShopName(jsonObject.getString("shopname"));
                        shopkeeper.setShopAddress(jsonObject.getString("shopaddress"));
                        shopkeeper.setRegion(jsonObject.getString("region"));

                        listItems.add(shopkeeper);
                    }

                    CompletedOrderAdapter adapter= new CompletedOrderAdapter(Distributor_CompletedOrder.this,listItems);
                    listView.setAdapter(adapter);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
