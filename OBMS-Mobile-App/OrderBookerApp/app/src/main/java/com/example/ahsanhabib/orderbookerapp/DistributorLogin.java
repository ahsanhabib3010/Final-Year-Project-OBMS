package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DistributorLogin extends AppCompatActivity {


    Button btnDistirbutorRegistration , btnDistributorLogin;

    EditText distributorEmail , distributorPassword;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_login);

        sessionManager = new SessionManager(this);

        if (sessionManager.isLoggedIn()) {
            Intent shopkeeper_home = new Intent(DistributorLogin.this, Distributor_Home.class);
            startActivity(shopkeeper_home);
        }


        btnDistirbutorRegistration = (Button)findViewById(R.id.btn_distributorRegistration);
        btnDistributorLogin = (Button)findViewById(R.id.btn_DistributorLogin);

        distributorEmail = (EditText)findViewById(R.id.et_distributorEmailLogin);
        distributorPassword = (EditText)findViewById(R.id.et_distributorPasswordLogin);

        btnDistirbutorRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent distributorRegistrationForm = new Intent(DistributorLogin.this, Distributor_Registeration.class);
                startActivity(distributorRegistrationForm);
            }
        });

        btnDistributorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (distributorEmail.getText().toString().isEmpty()){
                    Toast.makeText(DistributorLogin.this, "Please Enter Credentials..!!", Toast.LENGTH_LONG).show();
                }
                else if( distributorPassword.getText().toString().isEmpty()) {
                    Toast.makeText(DistributorLogin.this, "Please Enter Password..!!", Toast.LENGTH_LONG).show();
                }
                else {
                    distributor_login();
                    }
            }
        });

    }

    private void distributor_login() {

        String distributorLoginEmail = distributorEmail.getText().toString().trim();
        String distributorLoginPassword = distributorPassword.getText().toString().trim();

        String type = "login_distributor";

        sessionManager = new SessionManager(this);
        sessionManager.execute(type, distributorLoginEmail, distributorLoginPassword);

    }
}
