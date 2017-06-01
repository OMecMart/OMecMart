package com.example.lenovo.omecmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ServiceRutin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_rutin);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (ServiceRutin.this, ListBengkel.class);
                startActivity(i);

            }
        });

        Button btn2 = (Button) findViewById(R.id.button7);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (ServiceRutin.this, ListBengkel.class);
                startActivity(i);

            }
        });


        /*Button btnsp = (Button) findViewById(R.id.button2);
        btnsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (ServiceRutin.this, ServicePanggilan.class);
                startActivity(i);

            }
        });*/
    }
}
