package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface DeveloppeurDao {
    @Query("SELECT * FROM Developpeur")
    public Developpeur[] loadAllDeveloppeur();

    @Query("DELETE FROM Developpeur")
    public void deleteAllDeveloppeurs();

    @Insert
    public void insertDeveloppeur(Developpeur developpeur);

    @Query("SELECT * FROM Developpeur WHERE email = :developpeurEmail")
    public Developpeur loadDeveloppeur(String developpeurEmail);
}
