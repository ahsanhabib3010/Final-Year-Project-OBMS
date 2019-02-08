package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignInAsShopkeeper, btnSignInAsDistributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignInAsShopkeeper = (Button) findViewById(R.id.btn_shopkeeper);
        btnSignInAsDistributor = (Button) findViewById(R.id.btn_distributor);


        btnSignInAsShopkeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopkeeperLogin = new Intent(MainActivity.this, ShopkeeperLogin.class);
                startActivity(shopkeeperLogin);
            }
        });

        btnSignInAsDistributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent distributorLogin = new Intent(MainActivity.this, DistributorLogin.class);
                startActivity(distributorLogin);
            }
        });


    }

} // onCreate ends