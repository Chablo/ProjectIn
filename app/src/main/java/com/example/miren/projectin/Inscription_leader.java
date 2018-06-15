package com.example.miren.projectin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inscription_leader extends AppCompatActivity {

    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_leader);

        //récupération des propriétés
        Button inscription_dev = (Button) findViewById(R.id.button3);

        inscription_dev.setOnClickListener(new View.OnClickListener() {
            //récupération des propriétés
            TextView nom = (TextView) findViewById(R.id.nom);
            TextView prenom = (TextView) findViewById(R.id.prenom);
            TextView motdepasse = (TextView) findViewById(R.id.motdepasse);
            TextView mail = (TextView) findViewById(R.id.mail);
            TextView experience = (TextView) findViewById(R.id.expertise);
            TextView telephone = (TextView) findViewById(R.id.telephone);
            TextView adresse = (TextView) findViewById(R.id.adresse);

            public void onClick(View v) {
                Boolean isValid = true;

                //vérification de la validité des champs
                if( TextUtils.isEmpty(nom.getText())){
                    nom.setError( "Le nom est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(prenom.getText())){
                    prenom.setError( "Le prénom est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(motdepasse.getText())){
                    motdepasse.setError( "Le mot de passe est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(mail.getText())){
                    mail.setError( "L'adresse mail est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(experience.getText())){
                    experience.setError( "Le domaine d'expertise est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(telephone.getText())){
                    telephone.setError( "Le téléphone est obligatoire!" );
                    isValid = false;
                }
                if( TextUtils.isEmpty(adresse.getText())){
                    adresse.setError( "L'adresse est obligatoire!" );
                    isValid = false;
                }

                if(isValid) {
                    database = AppDatabase.getDatabase(getApplicationContext());
                    Leader leader = new Leader(nom.getText().toString(), prenom.getText().toString(), motdepasse.getText().toString(), mail.getText().toString(), experience.getText().toString(), telephone.getText().toString(), adresse.getText().toString());

                    database.leaderDao().insertLeader(leader);

                    Intent appel_login = new Intent(Inscription_leader.this, LoginActivity.class);
                    startActivity(appel_login);
                }
            }
        });
    }
}
