package com.example.ahsanhabib.orderbookerapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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

/**
 * Created by Ahsan Habib on 05-Apr-18.
 */

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alert;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    Helper helper = new Helper();

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

// Shopkeeper Registration

        if (type.equals("register_Shopkeeper")) {
            try {

                String name = params[1];
                String contact = params[2];
                String email = params[3];
                String shopName = params[4];
                String shopAddress = params[5];
                String shopRegion = params[6];
                String password = params[7];

                URL url = new URL(helper.REGISTER_SHOPKEEPER_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("s_name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                + URLEncoder.encode("s_contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8") + "&"
                                + URLEncoder.encode("s_email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                + URLEncoder.encode("s_shopname", "UTF-8") + "=" + URLEncoder.encode(shopName, "UTF-8") + "&"
                                + URLEncoder.encode("s_address", "UTF-8") + "=" + URLEncoder.encode(shopAddress, "UTF-8") + "&"
                                + URLEncoder.encode("s_region", "UTF-8") + "=" + URLEncoder.encode(shopRegion, "UTF-8") + "&"
                                + URLEncoder.encode("s_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                Log.i("Shopkeeper registration", post_data);
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
                Log.i("Shopkeeper result", result);
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

        // Distributor Registration

        else if(type.equals("registeration_Distributor")){

            try {

                String dist_name = params[1];
                String dist_contact = params[2];
                String dist_email = params[3];
                String dist_address = params[4];
                String dist_region = params[5];
                String dist_password = params[6];

                URL url = new URL(helper.REGISTER_DISTRIBUTOR_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("d_name", "UTF-8") + "=" + URLEncoder.encode(dist_name, "UTF-8") + "&"
                                + URLEncoder.encode("d_contact", "UTF-8") + "=" + URLEncoder.encode(dist_contact, "UTF-8") + "&"
                                + URLEncoder.encode("d_email", "UTF-8") + "=" + URLEncoder.encode(dist_email, "UTF-8") + "&"
                                + URLEncoder.encode("d_addresss", "UTF-8") + "=" + URLEncoder.encode(dist_address, "UTF-8") + "&"
                                + URLEncoder.encode("d_region", "UTF-8") + "=" + URLEncoder.encode(dist_region, "UTF-8") + "&"
                                + URLEncoder.encode("d_password", "UTF-8") + "=" + URLEncoder.encode(dist_password, "UTF-8");

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
                Log.d("Distributor Register:", result);
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
//        else if (type.equals("login_distributor")){
//            try{
//
//                String distributor_Email = params[1];
//                String distributor_Password = params[2];
//
//                URL url = new URL(LOGIN_DISTRIBUTOR_URL);
//                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                httpURLConnection.setDoInput(true);
//                OutputStream outputStream = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
//                String post_data =
//                        URLEncoder.encode("d_email", "UTF-8")+ "=" + URLEncoder.encode(distributor_Email, "UTF-8") + "&"
//                        + URLEncoder.encode("d_password", "UTF-8")+ "=" + URLEncoder.encode(distributor_Password, "UTF-8");
//
//                bufferedWriter.write(post_data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                outputStream.close();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
//                String result = "";
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null){
//                    result += line;
//                }
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//                return result;
//
//            }
//            catch (MalformedURLException e){
//                e.printStackTrace();
//            }catch (UnsupportedEncodingException e){
//                e.printStackTrace();
//            }catch (ProtocolException e){
//                e.printStackTrace();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//
//
//        }
        return null;
    }

        @Override
        protected void onPostExecute (String result){

            if(result.equalsIgnoreCase("Shopkeeper Registered successfully")) {
                Toast.makeText(context, "Shopkeeper Registered successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ShopkeeperLogin.class);
                context.startActivity(intent);
            }
            else if (result.equalsIgnoreCase("Distributor Registered successfully"))
            {
                Toast.makeText(context, "Distributor Registration Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DistributorLogin.class);
                context.startActivity(intent);
            }
            else if (result.equalsIgnoreCase("Distributor Login Successfull..!!")){
                Toast.makeText(context, "Distributor Login successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Distributor_Home.class);
                context.startActivity(intent);
            }
            else if (result.equalsIgnoreCase("Shopkeeper Successfully Login")){
                Toast.makeText(context, "Shopkeeper Login Successfull",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Shopkeeper_Home.class);
                context.startActivity(intent);
            }
            else {

                alert.setMessage(result);
                alert.show();
            }
        }

    @Override
    protected void onPreExecute () {
        alert = new AlertDialog.Builder(context).create();
        alert.setTitle("Status");

    }
        @Override
        protected void onProgressUpdate (Void...values){
            super.onProgressUpdate(values);
        }
    }


    // YA ALLAH YEH CODE AP K HAWALEY....