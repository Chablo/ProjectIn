package com.example.miren.projectin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Miren on 13/06/2018.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private String projet="create table projet ("
            + "id INTEGER AUTOINCREMENT PRIMARY KEY,"
            + "nom TEXT NOT NULL,"
            + "description TEXT NOT NULL,"
            + "dateDebut TEXT NOT NULL,"
            + "dateFin TEXT NOT NULL,"
            + "nbDev INTEGER NOT NULL,"
            + "competences TEXT NOT NULL);";

    private String developpeur="create table projet ("
            + "id INTEGER AUTOINCREMENT PRIMARY KEY,"
            + "nom TEXT NOT NULL,"
            + "prenom TEXT NOT NULL,"
            + "mdp TEXT NOT NULL,"
            + "email TEXT NOT NULL,"
            + "telephone TEXT NOT NULL,"
            + "expertise TEXT NOT NULL,"
            + "adresse TEXT NOT NULL);";

    private String leader="create table projet ("
            + "id INTEGER AUTOINCREMENT PRIMARY KEY,"
            + "nom TEXT NOT NULL,"
            + "prenom TEXT NOT NULL,"
            + "mdp TEXT NOT NULL,"
            + "email TEXT NOT NULL,"
            + "telephone TEXT NOT NULL,"
            + "expertise TEXT NOT NULL,"
            + "adresse TEXT NOT NULL);";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(projet);
        db.execSQL(developpeur);
        db.execSQL(leader);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
