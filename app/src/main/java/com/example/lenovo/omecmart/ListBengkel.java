package com.example.lenovo.omecmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/*import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;*/

public class ListBengkel extends AppCompatActivity {

    private RecyclerView lvhape;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;


   /* String[] menuItem = {"Bengkel Motorku....", "Bengkel Matahari", "Bengkel Astra"};
    String[] menuLagi = {"Jalan Mangga", "jalan Jambu", "Jalan Mastrip"};

    ListView listView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bengkel);

        String url = "http://192.168.43.192/Omecmart/v1/list_bengkel.php";

        lvhape = (RecyclerView) findViewById(R.id.lvhape);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvhape.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(ListBengkel.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("bengkel");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("kd_bengkel"));
                        map.put("nama_bengkel", json.getString("nama_bengkel"));
                        map.put("email_bengkel", json.getString("email_bengkel"));
                        map.put("alamat_bengkel", json.getString("alamat_bengkel"));
                        map.put("gambar", json.getString("gambar"));
                        map.put("no_telp", json.getString("no_telp"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(ListBengkel.this, list_data);
                        lvhape.setAdapter(adapter);
                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new  Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListBengkel.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }



}
