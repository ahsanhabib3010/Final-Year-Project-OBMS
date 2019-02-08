package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopkeeperLogin extends AppCompatActivity {


    Button btnShopkeeperLogin, btnShopkeeperRegistration;

    EditText shopkeeperEmail, shopkeeperPassword;

   // BackgroundWorker backgroundWorker;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper_login);


        shopkeeperEmail = (EditText)findViewById(R.id.et_shopkeeperEmail);
        shopkeeperPassword = (EditText)findViewById(R.id.et_shopkeeperPassword);


        btnShopkeeperLogin = (Button)findViewById(R.id.btn_ShopkeeperLogin);
        btnShopkeeperRegistration = (Button)findViewById(R.id.btn_shopkeeperRegistration);

        sessionManager = new SessionManager(this);

        if (sessionManager.isLoggedIn()) {
            Intent shopkeeper_home = new Intent(ShopkeeperLogin.this, Shopkeeper_Home.class);
            startActivity(shopkeeper_home);
        }


        btnShopkeeperRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopkeeperRegistrationForm = new Intent(ShopkeeperLogin.this, Shopkeeper_Registration.class);
                startActivity(shopkeeperRegistrationForm);
            }
        });


        btnShopkeeperLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (shopkeeperEmail.getText().toString().isEmpty()){
                   Toast.makeText(ShopkeeperLogin.this, "Please Enter Email..!!", Toast.LENGTH_LONG).show();
               }
               else if (shopkeeperPassword.getText().toString().isEmpty()){
                   Toast.makeText(ShopkeeperLogin.this, "Please Enter Password..!!", Toast.LENGTH_LONG).show();
               }
               else {
                   login_shopkeeper();
               }
            }
        });

    }

    private void login_shopkeeper() {

        String shopkeeperLoginEmail = shopkeeperEmail.getText().toString().trim();
        String shopkeeperLoginPassword = shopkeeperPassword.getText().toString().trim();

        String type = "login_shopkeeper";


        sessionManager = new SessionManager(this);
        sessionManager.execute(type, shopkeeperLoginEmail, shopkeeperLoginPassword);

    }
}
