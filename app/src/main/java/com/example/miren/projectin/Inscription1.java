package com.example.miren.projectin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inscription1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button leader = (Button) findViewById(R.id.leader);
        Button dev = (Button) findViewById(R.id.developpeur);

        setSupportActionBar(toolbar);

        leader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent appel = new Intent(Inscription1.this, Inscription_leader.class);
                startActivity(appel);
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent appel_dev = new Intent(Inscription1.this, Inscription_dev.class);
                startActivity(appel_dev);
            }
        });
    }
}