package com.haluberlu.myfirstapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by haluberlu on 05/08/2015.
 */
public class PartieBddHandler extends SQLiteOpenHelper {

    public static final String COL_ID = "Id";
    public static final String COL_NOM_PARTIE = "nom_partie";
    public static final String COL_NB_JOUEURS = "nb_joueurs";

    public static final String COL_NOM_J1 = "nom_J1";
    public static final String COL_NB_PTS_J1 = "nb_pts_J1";
    public static final String COL_NOM_J2 = "nom_J2";
    public static final String COL_NB_PTS_J2 = "nb_pts_J2";
    public static final String COL_NOM_J3 = "nom_J3";
    public static final String COL_NB_PTS_J3 = "nb_pts_J3";
    public static final String COL_NOM_J4 = "nom_J4";
    public static final String COL_NB_PTS_J4 = "nb_pts_J4";

    public static final String COL_DATE_CREATION = "date_creation";

    public static final String PARTIES_TABLE_NAME = "table_parties";
    public static final String PARTIES_TABLE_CREATE =
            "CREATE TABLE " + PARTIES_TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOM_PARTIE + " TEXT, " +
            COL_NB_JOUEURS + " INTEGER NOT NULL, " +
            COL_NOM_J1 + " TEXT, " +
            COL_NB_PTS_J1 + " INTEGER DEFAULT 0, " +
            COL_NOM_J2 + " TEXT, " +
            COL_NB_PTS_J2 + " INTEGER DEFAULT 0, " +
            COL_NOM_J3 + " TEXT, " +
            COL_NB_PTS_J3 + " INTEGER DEFAULT 0, " +
            COL_NOM_J4 + " TEXT, " +
            COL_NB_PTS_J4 + " INTEGER DEFAULT 0, " +
            COL_DATE_CREATION + " TEXT";

    public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXIST " + PARTIES_TABLE_NAME + ";";

    public PartieBddHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PARTIES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PARTIE_TABLE_DROP);
        onCreate(db);
    }
}
