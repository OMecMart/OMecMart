package com.example.lenovo.omecmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle; import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
        PopupMenu.OnMenuItemClickListener{
    TextView teksMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teksMenu= (TextView)findViewById(R.id.teksMenu);
        Button btnPopUp = (Button)findViewById(R.id.btnPopUp);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menuPopUp = new PopupMenu(MainActivity.this, v);
                menuPopUp.setOnMenuItemClickListener(MainActivity.this);
                menuPopUp.inflate(R.menu.menu_main);
                menuPopUp.show();
            }         });     }
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.shareItem:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
//        share.putExtra(Intent.EXTRA_SUBJECT, "Ini Judul Share");
//                share.putExtra(Intent.EXTRA_TEXT, "http://www.imastudio.co.id");
                startActivity(Intent.createChooser(share, "Pesan"));


    }         return true;     } }

