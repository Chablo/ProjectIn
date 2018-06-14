package com.example.miren.projectin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Miren on 13/06/2018.
 */

public class AccesLocal {
    private String nomBase = "bdd.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBase;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBase = new MySQLiteOpenHelper(contexte, nomBase, null, versionBase);
    }

    public void ajouterProjet(Projet projet){
        bd = accesBase.getWritableDatabase();
        String requete = "insert into projet (nom, description, dateDebut, dateFin, nbDev, competences) values (\""+projet.getNom()+"\",\""+projet.getDescription()+"\",\""+projet.getDateDebut()+"\",\""+projet.getDateFin()+"\","+projet.getNbDev()+",\""+projet.getCompetences()+"\")";
        bd.execSQL(requete);
    }

    public Projet recupProjet(){
        bd = accesBase.getReadableDatabase();
        Projet projet = null;
        String requete = "select * from projet";
        Cursor curseur = bd.rawQuery(requete, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()) {
            String nom = curseur.getString(1);
            String description = curseur.getString(2);
            String dateDebut = curseur.getString(3);
            String dateFin = curseur.getString(4);
            Integer nbDev = curseur.getInt(5);
            String competences = curseur.getString(6);
            projet = new Projet(nom, description, dateDebut, dateFin, nbDev, competences);
        }
        curseur.close();
        return projet;
    }

    public void ajouterDev(Developpeur developpeur){
        bd = accesBase.getWritableDatabase();
        String requete = "insert into developpeur (nom, prenom, mdp, email, expertise, telephone, adresse) values (\""+developpeur.getNom()+"\",\""+developpeur.getPrenom()+"\",\""+developpeur.getMdp()+"\",\""+developpeur.getEmail()+"\","+developpeur.getExpertise()+",\""+developpeur.getTelephone()+",\""+developpeur.getAdresse()+"\")";
        bd.execSQL(requete);
    }

    public Developpeur recupDev(){
        bd = accesBase.getReadableDatabase();
        Developpeur developpeur = null;
        String requete = "select * from developpeur";
        Cursor curseur = bd.rawQuery(requete, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()) {
            String nom = curseur.getString(1);
            String prenom = curseur.getString(2);
            String mdp = curseur.getString(3);
            String email = curseur.getString(4);
            String expertise = curseur.getString(5);
            String telephone = curseur.getString(6);
            String adresse = curseur.getString(7);
            developpeur = new Developpeur(nom, prenom, mdp, email, expertise, telephone, adresse);
        }
        curseur.close();
        return developpeur;
    }

    public void ajouterLeader(Leader leader){
        bd = accesBase.getWritableDatabase();
        String requete = "insert into leader (nom, prenom, mdp, email, expertise, telephone, adresse) values (\""+leader.getNom()+"\",\""+leader.getPrenom()+"\",\""+leader.getMdp()+"\",\""+leader.getEmail()+"\","+leader.getExpertise()+",\""+leader.getTelephone()+",\""+leader.getAdresse()+"\")";
        bd.execSQL(requete);
    }

    public Leader recupLeader(){
        bd = accesBase.getReadableDatabase();
        Leader leader = null;
        String requete = "select * from leader";
        Cursor curseur = bd.rawQuery(requete, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()) {
            String nom = curseur.getString(1);
            String prenom = curseur.getString(2);
            String mdp = curseur.getString(3);
            String email = curseur.getString(4);
            String expertise = curseur.getString(5);
            String telephone = curseur.getString(6);
            String adresse = curseur.getString(7);
            leader = new Leader(nom, prenom, mdp, email, expertise, telephone, adresse);
        }
        curseur.close();
        return leader;
    }
}
