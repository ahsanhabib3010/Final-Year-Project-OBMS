package com.example.ahsanhabib.orderbookerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

import Helper.Helper;
import Model.Shopkeeper;

public class Shopkeeper_UpdateProfile extends AppCompatActivity {

    EditText shopkeeper_name, shopkeeper_contact, shopkeeper_email, shopkeeper_shopName, shopkeeper_shopAddress, shopkeeper_region, shopkeeper_password, shopkeeper_confirmPassword;
    Button btn_updateShopkeeper;

    String sk_id, sk_name, sk_contact, sk_email, sk_shopName, sk_shopAddress, sk_region, sk_password;

    SessionManager sessionManager;

    Background updateprofile;

    String type = "update-shopkeeper-profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__update_profile);

        shopkeeper_name = (EditText) findViewById(R.id.et_Name);
        shopkeeper_contact = (EditText) findViewById(R.id.et_Contact);
        shopkeeper_email = (EditText) findViewById(R.id.et_Email);
        shopkeeper_shopName = (EditText) findViewById(R.id.et_shopName);
        shopkeeper_shopAddress = (EditText) findViewById(R.id.et_shopAddress);
        shopkeeper_region = (EditText) findViewById(R.id.et_region);
        shopkeeper_password = (EditText) findViewById(R.id.et_Password);
//        shopkeeper_confirmPassword = (EditText) findViewById(R.id.et_ConfirmPassword);

        btn_updateShopkeeper = (Button) findViewById(R.id.btn_UpdateShopkeeper);

        sessionManager = new SessionManager(this);

        sk_id = sessionManager.sharedpreferences.getString("ID", "ID");
        sk_name = sessionManager.sharedpreferences.getString("NAME", "NAME");
        sk_contact = sessionManager.sharedpreferences.getString("CONTACT", "CONTACT");
        sk_email = sessionManager.sharedpreferences.getString("EMAIL", "EMAIL");
        sk_shopName = sessionManager.sharedpreferences.getString("SHOPNAME", "SHOPNAME");
        sk_shopAddress = sessionManager.sharedpreferences.getString("SHOPADDRESS", "SHOPADDRESS");
        sk_region = sessionManager.sharedpreferences.getString("REGION", "REGION");
        sk_password = sessionManager.sharedpreferences.getString("PASSWORD", "PASSWORD");


        btn_updateShopkeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateprofile = new Background();
                updateprofile.execute(type, sk_id , shopkeeper_name.getText().toString(), shopkeeper_contact.getText().toString(), shopkeeper_email.getText().toString(), shopkeeper_shopName.getText().toString(), shopkeeper_shopAddress.getText().toString(), shopkeeper_region.getText().toString(), shopkeeper_password.getText().toString());
            }
        });

    }
    public void onStart() {
        shopkeeper_name.setText(sk_name);
        shopkeeper_contact.setText(sk_contact);
        shopkeeper_email.setText(sk_email);
        shopkeeper_shopName.setText(sk_shopName);
        shopkeeper_shopAddress.setText(sk_shopAddress);
        shopkeeper_region.setText(sk_region);
        shopkeeper_password.setText(sk_password);
        super.onStart();
    }

    public class Background extends  AsyncTask<String,Void, String> {

        Helper helper = new Helper();


        protected String doInBackground(String... params) {
            String type = params[0];

            if (type.equals("update-shopkeeper-profile")) {
                try {
                    String id = params[1];
                    String name = params[2];
                    String contact = params[3];
                    String email = params[4];
                    String shopName = params[5];
                    String shopAddress = params[6];
                    String region = params[7];
                    String password = params[8];

                    URL url = new URL(helper.UPDATE_SHOPKEEPER_PROFILE_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data =
                            URLEncoder.encode("sk_id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                                    +URLEncoder.encode("s_name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                    + URLEncoder.encode("s_contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8") + "&"
                                    + URLEncoder.encode("s_email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                    + URLEncoder.encode("s_shopname", "UTF-8") + "=" + URLEncoder.encode(shopName, "UTF-8") + "&"
                                    + URLEncoder.encode("s_shopaddress", "UTF-8") + "=" + URLEncoder.encode(shopAddress, "UTF-8") + "&"
                                    + URLEncoder.encode("s_region", "UTF-8") + "=" + URLEncoder.encode(region, "UTF-8") + "&"
                                    + URLEncoder.encode("s_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    Log.i("Hello", post_data);
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
        protected void onPostExecute(String result) {

            if(result.equalsIgnoreCase("Shopkeeper successfully updated")) {
                Toast.makeText(Shopkeeper_UpdateProfile.this, "Shopkeeper successfully Updated.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Shopkeeper_UpdateProfile.this, Shopkeeper_Home.class);
                startActivity(intent);
            }
        }
    }
}