package com.example.miren.projectin;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Miren on 13/06/2018.
 */
@Entity(foreignKeys = @ForeignKey(entity = Leader.class, parentColumns = "email", childColumns = "leaderEmail", onDelete = CASCADE))
public class Projet {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String description;
    private String competences;
    private String leaderEmail;
    private String[] developpeurEmails;

    public Projet(String nom, String description, String competences) {
        this.nom = nom;
        this.description = description;
        this.competences = competences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }
}
