package com.example.sandmovie;


import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



public class Runner extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_article);
        listView = listView.findViewById(R.id.linear_cd);

    }


}