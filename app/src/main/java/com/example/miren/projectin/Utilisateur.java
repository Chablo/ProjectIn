package com.example.miren.projectin;

/**
 * Created by Miren on 14/06/2018.
 */

public class Utilisateur {
    private String nom;
    private String prenom;
    private String mdp;
    private String email;
    private String expertise;
    private String telephone;
    private String adresse;
    private Boolean isLeader;

    public Utilisateur(String nom, String prenom, String mdp, String email, String expertise, String telephone, String adresse, Boolean isLeader) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
        this.expertise = expertise;
        this.telephone = telephone;
        this.adresse = adresse;
        this.isLeader = isLeader;
    }

    public Boolean getLeader() {
        return isLeader;
    }

    public void setLeader(Boolean leader) {
        isLeader = leader;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
