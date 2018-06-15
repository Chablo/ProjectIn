package com.example.miren.projectin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ajouter_projet extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_projet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button ajouter_projet = (Button) findViewById(R.id.button3);

        ajouter_projet.setOnClickListener(new View.OnClickListener() {

            TextView nom = (TextView) findViewById(R.id.nom);
            TextView description = (TextView) findViewById(R.id.description);
            TextView competences = (TextView) findViewById(R.id.competences);

            public void onClick(View v) {
                Boolean isValid = true;

                if( TextUtils.isEmpty(nom.getText())){
                    nom.setError( "Le nom est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(description.getText())){
                    description.setError( "La description est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(competences.getText())){
                    competences.setError( "La compétence est obligatoire!" );
                    isValid = false;
                }

                if(isValid) {
                    database = AppDatabase.getDatabase(getApplicationContext());
                    Intent intent = getIntent();
                    final String mail = intent.getExtras().getString("mail");

                    Projet projet = new Projet(nom.getText().toString(), description.getText().toString(), competences.getText().toString(), mail);

                    database.projetDao().insertProjet(projet);

                    Intent appel_leader_home = new Intent(ajouter_projet.this, leader_home.class);
                    startActivity(appel_leader_home);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.ajouter_projet, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.profil) {
            Intent productIntent = new Intent(this,Leader_profil.class);
            startActivity(productIntent);
            return true;
        } else if(id == R.id.ajouter_projet) {
            Intent productIntent = new Intent(this, ajouter_projet.class);
            startActivity(productIntent);
        } else if(id == R.id.projets) {
            Intent productIntent = new Intent(this, leader_home.class);
            startActivity(productIntent);
        } else if(id == R.id.deconnexion) {
            Intent productIntent = new Intent(this, LoginActivity.class);
            startActivity(productIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
