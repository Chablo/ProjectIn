package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface UtilisateurDao {
    @Query("SELECT * FROM Utilisateur")
    public Utilisateur[] loadAllUtilisateurs();

    @Query("DELETE FROM Utilisateur")
    public void deleteAllUtilisateurs();

    @Insert
    public void insertUtilisateur(Utilisateur utilisateur);

    @Query("SELECT * FROM Utilisateur WHERE email = :utilisateurEmail")
    public Utilisateur loadUtilisateur(String utilisateurEmail);

}
