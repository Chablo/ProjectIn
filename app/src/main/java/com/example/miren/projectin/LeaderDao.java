package com.example.miren.projectin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface LeaderDao {
    @Query("SELECT * FROM Leader")
    public Leader[] loadAllLeaders();

    @Query("DELETE FROM Leader")
    public void deleteAllLeaders();

    @Insert
    public void insertLeader(Leader leader);

    @Query("SELECT * FROM Leader WHERE email = :leaderEmail")
    public Leader loadLeader(String leaderEmail);

}
