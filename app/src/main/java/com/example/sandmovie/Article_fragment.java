package com.example.sandmovie;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Article_fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_article,container,false);
        CardView cardView = v.findViewById(R.id.cd1);
        CardView cardView1 = v.findViewById(R.id.cd2);
        CardView cardView2= v.findViewById(R.id.cd3);
        CardView cardView3 = v.findViewById(R.id.cd4);
        CardView cardView4 = v.findViewById(R.id.cd5);
        CardView cardView5 = v.findViewById(R.id.cd6);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_2.class);
                startActivity(i);
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_3.class);
                startActivity(i);
            }

        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_4.class);
                startActivity(i);
            }

        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_5.class);
                startActivity(i);
            }

        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_6.class);
                startActivity(i);
            }

        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity_7.class);
                startActivity(i);
            }

        });
return v;
    }
}