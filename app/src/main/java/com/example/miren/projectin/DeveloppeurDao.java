package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface DeveloppeurDao {
    @Query("SELECT * FROM Developpeur")
    public Developpeur[] loadAllUtilisateurs();

    @Query("DELETE FROM Developpeur")
    public void deleteAllUtilisateurs();

    @Insert
    public void insertUtilisateur(Developpeur developpeur);

    @Query("SELECT * FROM Developpeur WHERE email = :utilisateurEmail")
    public Developpeur loadUtilisateur(String utilisateurEmail);

}
