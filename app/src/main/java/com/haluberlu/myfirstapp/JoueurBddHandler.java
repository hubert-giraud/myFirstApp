package com.haluberlu.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Paccueil on 20/07/2015.
 */

public class JoueurBddHandler extends SQLiteOpenHelper {

    public static final String COL_ID = "ID";
    public static final String COL_NOM = "Nom";
    public static final String COL_DATE_CREATION = "Date de création";

    public static final String JOUEUR_TABLE_NAME = "table_joueurs";
    public static final String JOUEUR_TABLE_CREATE =
            "CREATE TABLE " + JOUEUR_TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOM + " TEXT, " +
                    COL_DATE_CREATION + " TEXT);";

    public static final String JOUEUR_TABLE_DROP = "DROP TABLE IF EXISTS " + JOUEUR_TABLE_NAME + ";";

    public JoueurBddHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(JOUEUR_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(JOUEUR_TABLE_DROP);
        onCreate(db);
    }
}
