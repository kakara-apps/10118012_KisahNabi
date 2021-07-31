package com.mrizkimn.kisahnabi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mrizkimn.kisahnabi.R;
import com.mrizkimn.kisahnabi.adapters.RecyclerViewAdapter;
import com.mrizkimn.kisahnabi.models.Nabi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://islamic-api-zhirrr.vercel.app/api/kisahnabi";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Nabi> listNabi;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNabi = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);

        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length() ; i++){

                    try {
                        jsonObject = response.getJSONObject(i);
                        Nabi nabi = new Nabi();
                        nabi.setName(jsonObject.getString("name"));
                        nabi.setThn_kelahiran(jsonObject.getString("thn_kelahiran"));
                        nabi.setUsia(jsonObject.getString("usia").toString());
                        nabi.setDecription(jsonObject.getString("description"));
                        nabi.setTempat(jsonObject.getString("tmp"));
                        nabi.setImg_url(jsonObject.getString("image_url"));
                        listNabi.add(nabi);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(listNabi);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Nabi> listNabi) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, listNabi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}