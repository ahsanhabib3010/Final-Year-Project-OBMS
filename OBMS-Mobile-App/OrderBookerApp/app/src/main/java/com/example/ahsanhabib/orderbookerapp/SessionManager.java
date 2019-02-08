package com.example.ahsanhabib.orderbookerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import Model.Distributor;
import Model.Shopkeeper;

/**
 * Created by Ahsan Habib on 10-Jul-18.
 */

public class SessionManager extends AsyncTask<String, Void, String> {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Id = "id";
    private static final String IS_LOGIN = "IsLoggedIn";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    Helper helper = new Helper();

//    String LOGIN_DISTRIBUTOR_URL = "http://192.168.0.104:8080/FYP/cms/scripts/loginDistributor.php";


    String[] data;

    AlertDialog alert;

    Context context;
    public SessionManager(Context ctx) {
        context = ctx;
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    @Override
    protected void onPreExecute() {
        alert = new AlertDialog.Builder(context).create();
        alert.setTitle("Status");
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        if (type.equals("login_shopkeeper")) {

            try {

                String email = params[1];
                String password = params[2];

                URL url = new URL(helper.LOGIN_SHOPKEEPER_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("d_email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                + URLEncoder.encode("d_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                Log.i("Shopkeeper Login data", post_data);
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
                Log.i("Shopkeeper Login result", result);
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (type.equals("login_distributor")){
            try{

                String distributor_Email = params[1];
                String distributor_Password = params[2];

                URL url = new URL(helper.LOGIN_DISTRIBUTOR_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data =
                        URLEncoder.encode("d_email", "UTF-8")+ "=" + URLEncoder.encode(distributor_Email, "UTF-8") + "&"
                                + URLEncoder.encode("d_password", "UTF-8")+ "=" + URLEncoder.encode(distributor_Password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }catch (ProtocolException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {


        String jsonStr = result; //turn object into string
        if (jsonStr != null) {
            try {

                JSONArray jsonArray = new JSONArray(jsonStr);

                if(jsonArray.length() > 0){

                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    Shopkeeper shopkeeper = new Shopkeeper();
                    shopkeeper.setId(jsonObject.getString("id"));
                    shopkeeper.setName(jsonObject.getString("name"));
                    shopkeeper.setContact(jsonObject.getString("contact"));
                    shopkeeper.setEmail(jsonObject.getString("email"));
                    shopkeeper.setShopName(jsonObject.getString("shop_name"));
                    shopkeeper.setShopAddress(jsonObject.getString("shop_address"));
                    shopkeeper.setRegion(jsonObject.getString("region"));
                    shopkeeper.setPassword(jsonObject.getString("password"));

                    Toast.makeText(context, "Sign In successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, Shopkeeper_Home.class);
                    context.startActivity(intent);


                    editor.putBoolean(IS_LOGIN, true);
                    editor.putString("ID", shopkeeper.getId());
                    editor.putString("NAME",shopkeeper.getName());
                    editor.putString("CONTACT",shopkeeper.getContact());
                    editor.putString("EMAIL",shopkeeper.getEmail());
                    editor.putString("SHOPNAME",shopkeeper.getShopName());
                    editor.putString("SHOPADDRESS",shopkeeper.getShopAddress());
                    editor.putString("REGION",shopkeeper.getRegion());
                    editor.putString("PASSWORD", shopkeeper.getPassword());
                    editor.commit();


                }
            } catch (JSONException e) {
                e.printStackTrace();
               // Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
            }
        }
         if (jsonStr != null) {
            try {

                JSONArray jsonArray = new JSONArray(jsonStr);

                if(jsonArray.length()==1)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    Distributor distributor = new Distributor();
                    distributor.setId(jsonObject.getString("id"));
                    distributor.setName(jsonObject.getString("name"));
                    distributor.setContact(jsonObject.getString("contact"));
                    distributor.setEmail(jsonObject.getString("email"));
                    distributor.setAddress(jsonObject.getString("address"));
                    distributor.setRegion(jsonObject.getString("region"));
                    distributor.setPassword(jsonObject.getString("password"));

                    Toast.makeText(context, "Sign In successful." +distributor.getId(), Toast.LENGTH_SHORT).show();

                    editor.putBoolean(IS_LOGIN, true);
                    editor.putString("ID", distributor.getId());
                    editor.putString("NAME", distributor.getName());
                    editor.putString("CONTACT",distributor.getContact());
                    editor.putString("EMAIL",distributor.getEmail());
                    editor.putString("ADDRESS",distributor.getAddress());
                    editor.putString("REGION",distributor.getRegion());
                    editor.putString("PASSWORD", distributor.getPassword());

                    editor.commit();

                    String value = sharedpreferences.getString("ID", distributor.getId());
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(context, Distributor_Home.class);
                    context.startActivity(intent);

                }

            } catch (JSONException e) {
                e.printStackTrace();
               // Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
            }
        }

        else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }

    }

    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent intent = new Intent(context, MainActivity.class);
            // Closing all the Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Staring Login Activity
            context.startActivity(intent);
        }
    }

    public boolean isLoggedIn(){
        return sharedpreferences.getBoolean(IS_LOGIN, false);
    }

    public  void logout(){

        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


}
