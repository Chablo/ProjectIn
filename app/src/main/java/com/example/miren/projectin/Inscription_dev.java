package com.example.miren.projectin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Inscription_dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_dev);
        Button inscription_dev = (Button) findViewById(R.id.button3);

        inscription_dev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent appel_dev = new Intent(Inscription_dev.this, LoginActivity.class);
                startActivity(appel_dev);
            }
        });
    }
}
