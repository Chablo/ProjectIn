package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface UtilisateurDao {
    @Query("SELECT * FROM Utilisateur")
    public Utilisateur[] loadAllUtilisateurs();

    @Insert
    public void insertUtilisateur(Utilisateur utilisateur);
}
