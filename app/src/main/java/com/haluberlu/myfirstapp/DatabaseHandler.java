package com.haluberlu.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Paccueil on 20/07/2015.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String PARTIE_KEY = "id";
    public static final String NOM_PARTIE = "nom_partie";
    public static final String NOM_J1 = "nom_j1";
    public static final String NB_PTS_J1 = "nb_pts_j1";
    public static final String NOM_J2 = "nom_j2";
    public static final String NB_PTS_J2 = "nb_pts_j2";

    public static final String PARTIE_TABLE_NAME = "Parties";
    public static final String PARTIE_TABLE_CREATE =
            "CREATE TABLE " + PARTIE_TABLE_NAME + " (" +
                    PARTIE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM_PARTIE + " TEXT, " +
                    NOM_J1 + " TEXT, " +
                    NB_PTS_J1 + " INTEGER " +
                    NOM_J2 + " TEXT " +
                    NB_PTS_J2 + " INTEGER);";
    public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTIE_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PARTIE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PARTIE_TABLE_DROP);
        onCreate(db);
    }
}
