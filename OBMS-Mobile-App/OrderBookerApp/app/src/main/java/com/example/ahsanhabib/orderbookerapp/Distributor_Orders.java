package com.example.ahsanhabib.orderbookerapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import Adapter.DistributorOrdersAdapter;
import Adapter.ShopkeeperAdapter;
import Helper.Helper;
import Model.Orders;
import Model.Shopkeeper;

import static android.R.attr.order;

public class Distributor_Orders extends AppCompatActivity {

    String id, name;
    String type = "getOrders";
    String type1 = "reject-order";

    Helper helper = new Helper();

    Background worker;
    Background2 worker2;

    Orders orders;

    ListView listView;

    Button accept, reject;

    String totalprize, order_id;

    TextView total1;

    ArrayList<Orders> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor__orders);

        listView = (ListView) findViewById(R.id.listview);

        orders = new Orders();

        //total1 = (TextView) findViewById(R.id.total);

        accept = (Button) findViewById(R.id.btn_accept);
        reject = (Button) findViewById(R.id.btn_reject);

        order_id = orders.getOrder_id();
       // Log.i("order id======", order_id);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            id = (String) bundle.get("id");
            name = (String) bundle.get("name");
        }

       // totalprize = orders.getTotal_price();
    //    total1.setText(orders.getTotal_price());
//        //Log.i("totall", totalprize);


        //total.setText(order.getTotal_price());


        worker = new Background();
        worker.execute(type, id);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Order Accepeted" ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Distributor_Orders.this, Distributor_Home.class);
                startActivity(intent);

//                Intent orders = new Intent(context, Distributor_Orders.class);
//                orders.putExtra("id", shopkeeper.getId());
//                orders.putExtra("name", shopkeeper.getName());
//                Log.i("Shopkeeper ID = ", shopkeeper.getId());
//                Log.i("Shopkeeper Name = ", shopkeeper.getName());
//                startActivity(orders);

            }
        });


        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"reject" ,Toast.LENGTH_SHORT).show();
                worker2 = new Background2();
                worker2.execute(type1, order_id);


            }
        });


    }

    public class Background extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            type = params[0];

            if (type.equals("getOrders")) {
                try {
                    String id = params[1];

                    URL url = new URL(helper.Orders_List_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data =
                            URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    bufferedWriter.write(post_data);
                    Log.d("orders request", post_data);
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
                    Log.d("orders responce", result);

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
                JSONArray jsonArray = new JSONArray(result);

                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Orders orders = new Orders();

                        orders.setProduct_name(jsonObject.getString("pro_name"));
                        orders.setQuantity(jsonObject.getString("pro_qty"));
                        orders.setUnit_Price(jsonObject.getString("pro_unit_prize"));
                        orders.setTotal_price(jsonObject.getString("total_prize"));
                        orders.setProduct_id(jsonObject.getString("pro_id"));
                        orders.setOrder_id(jsonObject.getString("order_id"));

                        listItems.add(orders);
                    }

                    DistributorOrdersAdapter adapter = new DistributorOrdersAdapter(Distributor_Orders.this, listItems);
                    listView.setAdapter(adapter);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }






    public class Background2 extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(String... params) {

            type = params[0];

            if (type.equals("reject-order")) {
                try {
                    String id = params[1];
                    Log.d("id=====", id);
                    URL url = new URL(helper.Orders_Reject_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data =
                            URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    bufferedWriter.write(post_data);
                    Log.d("orders reject request", post_data);
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
                    Log.d("orders reject responce", result);

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
            if (result.equalsIgnoreCase("successfull"))
                Toast.makeText(getBaseContext(), "Rejected", Toast.LENGTH_SHORT).show();
        }
    }

}
