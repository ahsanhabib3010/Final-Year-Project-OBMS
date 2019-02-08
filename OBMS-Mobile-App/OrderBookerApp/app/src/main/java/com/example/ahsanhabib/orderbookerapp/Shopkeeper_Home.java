package com.example.ahsanhabib.orderbookerapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Shopkeeper_Home extends AppCompatActivity {

    ImageView shopkeeper_place_order, shopkeeper_past_order, shopkeeper_update_profile, shopkeeper_logout;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper__home);

        shopkeeper_place_order = (ImageView)findViewById(R.id.shopkeeperPlaceOrder);
        shopkeeper_past_order = (ImageView)findViewById(R.id.shopkeeperPastOrder);
        shopkeeper_update_profile = (ImageView)findViewById(R.id.shopkeeperUpdateProfile);
        shopkeeper_logout = (ImageView)findViewById(R.id.shopkeeperLogout);

        shopkeeper_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent placeOrder = new Intent(Shopkeeper_Home.this, Shopkeeper_PlaceOrder.class);
                startActivity(placeOrder);
            }
        });

        shopkeeper_past_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pastOrder = new Intent(Shopkeeper_Home.this, Shopkeeper_PastOrders.class);
                startActivity(pastOrder);
            }
        });

        shopkeeper_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateProfile = new Intent(Shopkeeper_Home.this, Shopkeeper_UpdateProfile.class);
                startActivity(updateProfile);
            }
        });



        //Logout Session
        sessionManager = new SessionManager(this);
        shopkeeper_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logout();
            }
        });
        sessionManager.checkLogin();
    }
}
