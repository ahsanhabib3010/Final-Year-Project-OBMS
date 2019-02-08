package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Distributor_Home extends AppCompatActivity {
    ImageView distributor_current_order, distributor_past_order, distributor_update_profile, distributor_logout;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor__home);


        distributor_current_order = (ImageView)findViewById(R.id.distributorCurrentOrder);
        distributor_past_order = (ImageView)findViewById(R.id.distributorPastOrder);
        distributor_update_profile = (ImageView)findViewById(R.id.distributorUpdateProfile);
        distributor_logout = (ImageView)findViewById(R.id.distributorLogout);

        distributor_current_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentOrder = new Intent(Distributor_Home.this, Distributor_ViewOrder.class);
                startActivity(currentOrder);
            }
        });

        distributor_past_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent completedOrders = new Intent(Distributor_Home.this, Distributor_CompletedOrder.class);
                startActivity(completedOrders);
            }
        });

        distributor_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateProfile = new Intent(Distributor_Home.this, Distributor_UpdateProfile.class);
                startActivity(updateProfile);
            }
        });



        //Logout Session
        sessionManager = new SessionManager(this);
        distributor_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logout();
            }
        });
        sessionManager.checkLogin();
    }


}


