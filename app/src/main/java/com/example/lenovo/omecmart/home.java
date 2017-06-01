package com.example.lenovo.omecmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton btnsp = (ImageButton) findViewById(R.id.imageButton13);
                btnsp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent (home.this, ListBengkel.class);
                        startActivity(i);

                    }
                });

        ImageButton btnhelp = (ImageButton) findViewById(R.id.imageButtonHelp);
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (home.this, help2.class);
                startActivity(i);

            }
        });

        ImageButton btn = (ImageButton) findViewById(R.id.imageButtonProfil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (home.this, Profil.class);
                startActivity(i);

            }
        });

        ImageButton booking = (ImageButton) findViewById(R.id.buttonBookingService);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (home.this, ListBengkel.class);
                startActivity(i);

            }
        });

        ImageButton btnterdekat = (ImageButton) findViewById(R.id.imageButton15);
        btnterdekat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (home.this, Maps.class);
                startActivity(i);

            }
        });
        }
    }

