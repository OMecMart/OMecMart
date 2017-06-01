package com.example.lenovo.omecmart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private EditText editTextUsername;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;

    private String username;
    private String password;


    /*private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private ProgressDialog progressDialog;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, home.class));
            return;
        }

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        Button MASUK=(Button) findViewById(R.id.buttonLogin);
        Button Daftar=(Button) findViewById(R.id.button3);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Please wait...");


        Daftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View df){
                Intent reg=new Intent(login.this, Daftar1.class);
                startActivity(reg);
            }
        });

        MASUK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }

    private void userLogin() {
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.getBoolean("status")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                            jsonObject.getInt("id"),
                                            jsonObject.getString("nama"),
                                            jsonObject.getString("email"),
                                            jsonObject.getString("alamat"),
                                            jsonObject.getString("telephone")

                                );
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"),
                                        Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), home.class));
                                finish();
                            }else {
                                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"),
                                            Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e.toString(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}





        /*editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin =(Button) findViewById(R.id.buttonLogin);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        buttonLogin.setOnClickListener(this);

    }

    private void userLogin(){
        final String username = editTextUsername.getText().toString().trim();
        final  String password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("nama"),
                                                obj.getString("email")
                                        );
                                startActivity(new Intent(getApplicationContext(), home.class));
                                finish();
                            } else{
                                Toast.makeText(getApplicationContext(),obj.getString("message"),Toast.LENGTH_LONG).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogin){
            userLogin();
        }
    }
}*/

