package com.example.miren.projectin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Leader_profil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //remplir les champs
        Intent intent = getIntent();
        final String nom = intent.getExtras().getString("nom");
        final String prenom = intent.getExtras().getString("prenom");
        final String mdp = intent.getExtras().getString("mdp");
        final String mail = intent.getExtras().getString("mail");
        final String expertise = intent.getExtras().getString("expertise");
        final String adresse = intent.getExtras().getString("adresse");
        final String tel = intent.getExtras().getString("tel");

        TextView nomT = (TextView) findViewById(R.id.nom);
        TextView prenomT = (TextView) findViewById(R.id.prenom);
        TextView mdpT = (TextView) findViewById(R.id.mdp);
        TextView mailT = (TextView) findViewById(R.id.mail);
        TextView expertiseT = (TextView) findViewById(R.id.expertise);
        TextView adresseT = (TextView) findViewById(R.id.adresse);
        TextView telT = (TextView) findViewById(R.id.telephone);

        nomT.setText(nom);
        prenomT.setText(prenom);
        mdpT.setText(mdp);
        mailT.setText(mail);
        expertiseT.setText(expertise);
        adresseT.setText(adresse);
        telT.setText(tel);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.leader_profil, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = getIntent();
        final String nom = intent.getExtras().getString("nom");
        final String prenom = intent.getExtras().getString("prenom");
        final String mdp = intent.getExtras().getString("mdp");
        final String mail = intent.getExtras().getString("mail");
        final String expertise = intent.getExtras().getString("expertise");
        final String adresse = intent.getExtras().getString("adresse");
        final String tel = intent.getExtras().getString("tel");
        //noinspection SimplifiableIfStatement
        if (id == R.id.profil) {
            Intent productIntent = new Intent(this, Leader_profil.class);
            productIntent.putExtra("nom", nom);
            productIntent.putExtra("prenom", prenom);
            productIntent.putExtra("mdp", mdp);
            productIntent.putExtra("mail", mail);
            productIntent.putExtra("expertise", expertise);
            productIntent.putExtra("adresse", adresse);
            productIntent.putExtra("tel", tel);

            startActivity(productIntent);
            return true;
        } else if(id == R.id.ajouter_projet) {
            Intent productIntent = new Intent(this, ajouter_projet.class);
            productIntent.putExtra("nom", nom);
            productIntent.putExtra("prenom", prenom);
            productIntent.putExtra("mdp", mdp);
            productIntent.putExtra("mail", mail);
            productIntent.putExtra("expertise", expertise);
            productIntent.putExtra("adresse", adresse);
            productIntent.putExtra("tel", tel);
            startActivity(productIntent);
        } else if(id == R.id.projets) {
            Intent productIntent = new Intent(this, leader_home.class);
            productIntent.putExtra("nom", nom);
            productIntent.putExtra("prenom", prenom);
            productIntent.putExtra("mdp", mdp);
            productIntent.putExtra("mail", mail);
            productIntent.putExtra("expertise", expertise);
            productIntent.putExtra("adresse", adresse);
            productIntent.putExtra("tel", tel);
            startActivity(productIntent);
        } else if(id == R.id.deconnexion) {
            Intent productIntent = new Intent(this, LoginActivity.class);
            productIntent.putExtra("nom", nom);
            productIntent.putExtra("prenom", prenom);
            productIntent.putExtra("mdp", mdp);
            productIntent.putExtra("mail", mail);
            productIntent.putExtra("expertise", expertise);
            productIntent.putExtra("adresse", adresse);
            productIntent.putExtra("tel", tel);
            startActivity(productIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
