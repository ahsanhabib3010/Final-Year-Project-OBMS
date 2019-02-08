package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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
import java.util.Objects;

import Adapter.DistributorAdapter;
import Adapter.ProductInventoryAdapter;
//import Adapter.ProductListAdapter;
import Helper.Helper;
import Model.Distributor;
import Model.ProductInventory;
import Model.Products;

public class Shopkeeper_Products extends AppCompatActivity {

    String type = "getProductItems";
    //String[] distributorName;

    Helper helper = new Helper();

    ListView listView;

    ArrayList<Products> listItems = new ArrayList<>();

    String distributorId, distributorName;

    Button btn_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__products);

        listView = (ListView) findViewById(R.id.productListView);

        Intent getDistributorIdIntent = getIntent();
        Bundle bundle = getDistributorIdIntent.getExtras();

        if (bundle != null) {
            distributorId = (String) bundle.get("id");
            distributorName = (String) bundle.get("name");
            Toast.makeText(Shopkeeper_Products.this, "id = " + distributorId + "Name = " +distributorName, Toast.LENGTH_SHORT).show();

        }

        btn_checkout = (Button)findViewById(R.id.btn_go_to_next);

        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnyOneSelected = false;
                double grandTotal = 0.0;
                for(int i=0;i<Helper.SELECTED_PRODUCTS.size();i++){
                    Products products = Helper.SELECTED_PRODUCTS.get(i);
                    if(products.getChecked()){
                        if(products.getOrderQuantity()>0){
                            isAnyOneSelected = true;
                            double total = Double.parseDouble(products.getProduct_perunitprize())*products.getOrderQuantity();
                            grandTotal+=total;
                           // Log.i("Product * Qty",products.getProduct_perunitprize()+" * "+products.getOrderQuantity()+" = "+ total+"");
                        }
                    }

                }

                if(!isAnyOneSelected){
                    Toast.makeText(Shopkeeper_Products.this, "Please select atleast one product" ,Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.i("Grand Total = ",grandTotal+"");
                    Intent finalOrder = new Intent(Shopkeeper_Products.this, Shopkeeper_FinalOrder.class);
                    finalOrder.putExtra("id", distributorId);
                    finalOrder.putExtra("name", distributorName);
                    startActivity(finalOrder);
                }

             //   Toast.makeText(Shopkeeper_Products.this, distributorId +" - "+ distributorName ,Toast.LENGTH_SHORT).show();
            }
        });

        Background worker = new Background();
        worker.execute(type, distributorId);
    }

    public class Background extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            type = params[0];

            if (type.equals("getProductItems")) {
                try {
                    String id = params[1];

                    URL url = new URL(helper.Product_List_URL);
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
                Log.i("LENGTH", jsonArray.length() + "");
                if (jsonArray.length() > 0) {
                    //{\"id\":\"8\",\"name\":\"Aliasghar\",\"email\":\"ali@gmail.com\",\"region\":\"North\",\"shop_name\":\"Ali cabin\"}
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Products products = new Products();

                        products.setDistributor_id(jsonObject.getString("id"));
                        products.setProduct_id(jsonObject.getString("productId"));
                        products.setProduct_name(jsonObject.getString("productName"));
                        products.setProduct_perunitprize(jsonObject.getString("productUnitPrize"));
                        products.setQuantity(70);
                        //products.setQuantity(Integer.parseInt(jsonObject.getString("qty")));
                        products.setOrderQuantity(0);
                        products.setChecked(false);
                        listItems.add(products);
                        Log.i("Product Name", products.getProduct_name());

                    }

                    Helper.SELECTED_PRODUCTS = listItems;
                    ProductInventoryAdapter adapter = new ProductInventoryAdapter(Shopkeeper_Products.this, Helper.SELECTED_PRODUCTS);
                    listView.setAdapter(adapter);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
