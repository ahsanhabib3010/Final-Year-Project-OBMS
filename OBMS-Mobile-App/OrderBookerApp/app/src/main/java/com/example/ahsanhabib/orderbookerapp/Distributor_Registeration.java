package com.example.ahsanhabib.orderbookerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Distributor_Registeration extends AppCompatActivity {


    EditText distributor_name, distributor_contact, distributor_email, distributor_address, distributor_region, distributor_password, distributor_confirmPassword;
    Button submit;

    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor__registeration);

        distributor_name = (EditText) findViewById(R.id.et_DistributorName);
        distributor_contact = (EditText) findViewById(R.id.et_DistributorContact);
        distributor_email = (EditText) findViewById(R.id.et_DistributorEmail);
        distributor_address = (EditText)findViewById(R.id.et_DistributorAddress);
        distributor_region = (EditText)findViewById(R.id.et_DistributorRegion);
        distributor_password = (EditText) findViewById(R.id.et_DistributorPassword);
        distributor_confirmPassword = (EditText) findViewById(R.id.et_DistributorConfirmPassword);


        //Buttons IDS


        submit = (Button)findViewById(R.id.btnSubmit);

        //ImageView ID

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (distributor_name.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the FullName", Toast.LENGTH_SHORT).show();
                }
                else   if (distributor_contact.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the Contact Number", Toast.LENGTH_SHORT).show();
                }
                else   if (distributor_email.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the Email Address", Toast.LENGTH_SHORT).show();
                }
                else   if (distributor_address.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the Address", Toast.LENGTH_SHORT).show();
                }
                else   if (distributor_region.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the Region", Toast.LENGTH_SHORT).show();
                }
                else   if (distributor_password.getText().toString().isEmpty()){
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                }
                else if (distributor_confirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(Distributor_Registeration.this, "Please Enter the again Password to Confirm Password", Toast.LENGTH_SHORT).show();
                }

                else
                {
                   registerDistributor();
                }
            }


        });


    }

    private void registerDistributor() {

        String distributorName = distributor_name.getText().toString();
        String distributorContact = distributor_contact.getText().toString();
        String distributorEmail = distributor_email.getText().toString();
        String distributorAddress = distributor_address.getText().toString();
        String distributorRegion = distributor_region.getText().toString();
        String distributorPassword = distributor_password.getText().toString();

        String type = "registeration_Distributor";

        backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, distributorName, distributorContact, distributorEmail, distributorAddress, distributorRegion, distributorPassword);

    }
}
