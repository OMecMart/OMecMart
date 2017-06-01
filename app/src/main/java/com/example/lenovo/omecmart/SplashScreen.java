package com.example.lenovo.omecmart;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*handler untuk menahan activity sementara*/
        Handler handler = new Handler ();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Mulai activity ke MainActivity setelah 5 detik*/
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
            }
            /*durasi 5000ms*/
        },5000);

    }
}
