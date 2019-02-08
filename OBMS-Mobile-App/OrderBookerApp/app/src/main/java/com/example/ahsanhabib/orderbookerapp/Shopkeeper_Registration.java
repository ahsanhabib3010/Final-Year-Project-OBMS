package com.example.ahsanhabib.orderbookerapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Shopkeeper_Registration extends AppCompatActivity {


    Button btnRegisterShopkeeper;

    BackgroundWorker backgroundWorker;
//    private static final String REGISTER_SHOPKEEPER_URL = "http://192.168.0.107:8080/FYP/obms/shopkeeper/addshopkeeper.php";

    EditText etName, etContact, etEmail, etshopName, etshopAddress, etshopRegion, etpassword, etconfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__registration);

        etName = (EditText)findViewById(R.id.et_Name);
        etContact = (EditText)findViewById(R.id.et_Contact);
        etEmail = (EditText)findViewById(R.id.et_Email);
        etshopName = (EditText)findViewById(R.id.et_shopName);
        etshopAddress = (EditText)findViewById(R.id.et_shopAddress);
        etshopRegion = (EditText)findViewById(R.id.et_shopRegion);
        etpassword = (EditText)findViewById(R.id.et_Password);
        etconfirmPassword = (EditText)findViewById(R.id.et_ConfirmPassword);


        btnRegisterShopkeeper = (Button)findViewById(R.id.btn_RegisterShopkeeper);

        btnRegisterShopkeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Name !", Toast.LENGTH_LONG).show();
                }
                else if (etContact.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Contact !", Toast.LENGTH_LONG).show();
                }
                else if (etEmail.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Email !", Toast.LENGTH_LONG).show();
                }
                else if (etshopName.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Shop Name !", Toast.LENGTH_LONG).show();
                }
                else if (etshopAddress.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Shop Address !", Toast.LENGTH_LONG).show();
                }
                else if (etshopRegion.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Shop Region !", Toast.LENGTH_LONG).show();
                }
                else if (etpassword.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Password !", Toast.LENGTH_LONG).show();
                }
                else if (etconfirmPassword.getText().toString().equals(""))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Please Enter Confirm Password !", Toast.LENGTH_LONG).show();
                }
                else if (etpassword.equals(etconfirmPassword))
                {
                    Toast.makeText(Shopkeeper_Registration.this, "Password Not match !", Toast.LENGTH_LONG).show();
                }
                else {

                    registerShopkeeper();
                }
            }
        });


    }

    private void registerShopkeeper() {

        String name = etName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String shopName = etshopName.getText().toString().trim();
        String shopAddress = etshopAddress.getText().toString().trim();
        String shopRegion = etshopRegion.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

        String type = "register_Shopkeeper";

        backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, name, contact, email, shopName, shopAddress, shopRegion, password);

    }
}
