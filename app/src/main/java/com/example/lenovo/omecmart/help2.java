package com.example.lenovo.omecmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class help2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help2);

        Button btn = (Button) findViewById(R.id.buttonServicePanggilan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (help2.this, help.class);
                startActivity(i);

            }
        });

        Button btn2 = (Button) findViewById(R.id.button6);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (help2.this, help3.class);
                startActivity(i);

            }
        });
//        setContentView(R.layout.com.example.lenovo.omecmart.verifikasipass.help2);
//        setContentView(R.layout.help3);
    }
}
