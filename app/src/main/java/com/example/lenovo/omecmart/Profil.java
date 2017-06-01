package com.example.lenovo.omecmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    private TextView textViewUsername, textViewEmail, textViewNomor, editTextViewNama, editTextViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, login.class));
        }

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewNomor = (TextView) findViewById(R.id.textViewNomor);

        editTextViewNama =(TextView) findViewById(R.id.TextViewNama);
        editTextViewEmail =(TextView) findViewById(R.id.TextViewEmail);

        textViewUsername.setText(SharedPrefManager.getInstance(this).getNama());
        textViewEmail.setText(SharedPrefManager.getInstance(this).getEmail());
        textViewNomor.setText(SharedPrefManager.getInstance(this).getHp());

        editTextViewNama.setText(SharedPrefManager.getInstance(this).getNama());
        editTextViewEmail.setText(SharedPrefManager.getInstance(this).getEmail());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menulogout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                Toast.makeText(this, "Anda Berhasil LOGOUT", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, login.class));
                break;
        }
        return true;
    }
}