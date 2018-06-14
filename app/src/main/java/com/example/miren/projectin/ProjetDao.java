package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface ProjetDao {
    @Query("SELECT * FROM Projet")
    public Projet[] loadAllProjets();

    @Query("DELETE FROM Projet")
    public void deleteAllProjets();

    @Insert
    public void insertProjet(Projet projet);

    
}
