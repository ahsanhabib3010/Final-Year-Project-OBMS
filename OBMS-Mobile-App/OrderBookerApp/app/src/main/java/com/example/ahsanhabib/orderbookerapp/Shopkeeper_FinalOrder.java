package com.example.ahsanhabib.orderbookerapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.FinalOrderAdapter;
import Model.Products;

import Helper.*;

public class Shopkeeper_FinalOrder extends AppCompatActivity {

    String distributorId, distributorName, sk_id;
    String productName, unitPrice, qty;
    TextView distributorid, distributorname, grand_total;
    ListView listView;
    Button order;
    double grandTotal = 0.0;

    ArrayList<Products> listItems = new ArrayList<>();

    String type = "finalOrder";

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__final_order);

        distributorid = (TextView) findViewById(R.id.distritubor_id);
        distributorname = (TextView) findViewById(R.id.distritubor_name);

        grand_total = (TextView) findViewById(R.id.grandTotal);

        listView = (ListView) findViewById(R.id.finalProductList);

        order = (Button) findViewById(R.id.btn_order);

        sessionManager = new SessionManager(this);
        sk_id = sessionManager.sharedpreferences.getString("ID", "ID");

        Intent getDistributorIdandNameIntent = getIntent();
        Bundle bundle = getDistributorIdandNameIntent.getExtras();

        if (bundle != null) {
            distributorId = (String) bundle.get("id");
            distributorName = (String) bundle.get("name");
        }

        distributorid.setText(distributorId);
        distributorname.setText(distributorName);


        boolean isAnyOneSelected = false;
        for (int i = 0; i < Helper.SELECTED_PRODUCTS.size(); i++) {
            Products products = Helper.SELECTED_PRODUCTS.get(i);
            if (products.getChecked()) {
                if (products.getOrderQuantity() > 0) {
                    isAnyOneSelected = true;
                    double total = Double.parseDouble(products.getProduct_perunitprize()) * products.getOrderQuantity();
                    grandTotal += total;
                    productName = products.getProduct_name();
                    unitPrice = products.getProduct_perunitprize();
                    qty = String.valueOf(products.getOrderQuantity());
                    Log.i("Product * Qty", products.getProduct_perunitprize() + " * " + products.getOrderQuantity() + " = " + total + "" + " Product name = " + products.getProduct_name());
                    listItems.add(products);
                    grand_total.setText(String.valueOf(grandTotal));
                }
            }
            FinalOrderAdapter adapter = new FinalOrderAdapter(Shopkeeper_FinalOrder.this, listItems);
            listView.setAdapter(adapter);
        }

        if (!isAnyOneSelected) {
            Toast.makeText(Shopkeeper_FinalOrder.this, "Please select atleast one product", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("Grand Total = ", grandTotal + "");

        }

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OrderProducts();
            }
        });
    }
    public String composeOrderJSON(List<Products> SELECTED_PRODUCTS) {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        Gson gson = new GsonBuilder().create();

        if (SELECTED_PRODUCTS.size()>0) {
            for(int i=0;i<SELECTED_PRODUCTS.size();i++){
                Products product = SELECTED_PRODUCTS.get(i);

                HashMap<String, String> map = new HashMap<String, String>();

                map.put("product_id", product.getProduct_id());
                map.put("product_name", product.getProduct_name());
                map.put("qty", String.valueOf(product.getOrderQuantity()));

                wordList.add(map);
            }

        }
        return gson.toJson(wordList);
    }
    private void OrderProducts() {
        String type = "orderPlacement";
        new OrderBackgroundWorker(this).execute(type, distributorId, sk_id, String.valueOf(grandTotal),composeOrderJSON(listItems));

        Toast.makeText(this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();

        Intent toHome = new Intent(this, Shopkeeper_Home.class);
        startActivity(toHome);

    }
}

class OrderBackgroundWorker extends AsyncTask<String, Void, String>{

    Context context;
    Helper helper = new Helper();
    OrderBackgroundWorker(Context context){
        this.context = context;

    }
    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        if (type.equalsIgnoreCase("orderPlacement")) {
            try {

                String distributor_id = params[1];
                String shopkeeper_id = params[2];
                String total = params[3];
                String orderedProducts = params[4];

                URL url = new URL(helper.FINAL_ORDER_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                       "did" + "=" + distributor_id + "&"
                               + "sid"+ "=" + shopkeeper_id + "&"
                                + "total"+ "=" + total + "&"
                                + "ordered_products"+ "=" + URLEncoder.encode(orderedProducts, "UTF-8");

                bufferedWriter.write(post_data);
                Log.d("data=", post_data);
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
                Log.d("Hello4", result);
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}