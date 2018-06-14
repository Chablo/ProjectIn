package com.example.miren.projectin;

// User and Book are classes annotated with @Entity.

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Utilisateur.class}, version = 2)
abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    abstract public UtilisateurDao utilisateurDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "projectInDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
