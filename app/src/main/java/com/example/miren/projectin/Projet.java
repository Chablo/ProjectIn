package com.example.miren.projectin;

import java.util.Date;

/**
 * Created by Miren on 13/06/2018.
 */

public class Projet {
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private Integer nbDev;
    private String competences;

    public Projet(String nom, String description, String dateDebut, String dateFin, Integer nbDev, String competences) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbDev = nbDev;
        this.competences = competences;
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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNbDev() {
        return nbDev;
    }

    public void setNbDev(Integer nbDev) {
        this.nbDev = nbDev;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }
}
