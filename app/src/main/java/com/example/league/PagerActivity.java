package com.example.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class PagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        viewPager = findViewById(R.id.pager);
        images = getIntent().getStringArrayListExtra("images");
        PagerImageAdapter pagerImageAdapter = new PagerImageAdapter(getApplicationContext(),images);
        viewPager.setAdapter(pagerImageAdapter);
    }
}