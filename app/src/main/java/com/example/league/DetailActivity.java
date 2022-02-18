package com.example.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Competition> competitions = new ArrayList<>();
    CompAdapter compAdapter;
   static  String JSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        recyclerView = findViewById(R.id.recyclerView);
        JSON = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=";
        String pais ="";
        pais = getIntent().getStringExtra("pais");
        if (pais.equals("USA")){
            pais = "United%20States";
        }
        JSON = JSON +pais + "&s=Soccer";
        getComp();
    }
    private void getComp() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                JSON ,
                null,
                (Response.Listener<JSONObject>) response -> {

                    try {
                        JSONArray jsonArray =  response.getJSONArray("countrys");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject competitionObject = jsonArray.getJSONObject(i);
                            Competition competition = new Competition();
                            competition.setFlag(competitionObject.getString("strBadge"));
                            competition.setTextTitle(competitionObject.getString("strLeague"));
                            competition.setTextDescription(competitionObject.getString("strDescriptionEN"));
                            competition.setVisitWeb(competitionObject.getString("strWebsite"));
                            ArrayList<String> images = new ArrayList<>();
                            if(!competitionObject.getString("strFanart1").equals("null")){
                                images.add(competitionObject.getString("strFanart1"));
                                if(!competitionObject.getString("strFanart2").equals("null")){
                                    images.add(competitionObject.getString("strFanart2"));
                                    if(!competitionObject.getString("strFanart3").equals("null")){
                                        images.add(competitionObject.getString("strFanart3"));
                                        if(!competitionObject.getString("strFanart3").equals("null")){
                                            images.add(competitionObject.getString("strFanart4"));
                                        }

                                    }

                                }
                            }
                            competition.setImages(images);
                            competitions.add(competition);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    compAdapter = new CompAdapter(competitions,getApplicationContext());
                    recyclerView.setAdapter(compAdapter);
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag","onErrorResponse: " + error.getMessage());
                    }
                }

        );

        queue.add(jsonObjectRequest);

    }
}