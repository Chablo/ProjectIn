package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface ProjetDao {
    @Query("SELECT * FROM Projet")
    public Projet[] loadAllProjets();

    @Query("DELETE FROM Projet")
    public void deleteAllProjets();

    @Query("SELECT * FROM Projet WHERE leaderEmail = :leaderEmail")
    public Projet[] loadLeaderProjets(String leaderEmail);

    @Insert
    public void insertProjet(Projet projet);

    @Update
    public void updateProjet(Projet projet);
}
