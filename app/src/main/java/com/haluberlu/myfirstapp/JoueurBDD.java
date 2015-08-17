package com.haluberlu.myfirstapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.util.Date;

/**
 * Created by haluberlu on 05/08/2015.
 */
public class JoueurBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "joueurs.db";

    private static final String TABLE_JOUEUR = "Joueurs";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "Nom";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_DATE_CREATION = "Date de création";
    private static final int NUM_COL_DATE_CREATION = 2;

    private SQLiteDatabase bdd;

    private JoueurBddHandler JoueurBddHandler;

    public JoueurBDD(Context context) {
        JoueurBddHandler = new JoueurBddHandler(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        bdd = JoueurBddHandler.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getJoueurBdd() {
        return bdd;
    }

    public long insertJoueur(Joueur joueur) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM, joueur.getNom());
        values.put(COL_DATE_CREATION, joueur.getDate_creation());
        return bdd.insert(TABLE_JOUEUR, null, values);
    }

    public Joueur getJoueur(String nom) {
        Cursor c = bdd.query(TABLE_JOUEUR, new String[] {COL_ID, COL_NOM, COL_DATE_CREATION}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
        return cursorToJoueur(c);
    }

    private Joueur cursorToJoueur(Cursor c) {
        if(c.getCount() == 0) return null;

        c.moveToFirst();

        Joueur joueur = new Joueur();
        joueur.setId(c.getInt(NUM_COL_ID));
        joueur.setNom(c.getString(NUM_COL_NOM))
        joueur.setDate_creation(c.getString(NUM_COL_DATE_CREATION));

        c.close();

        return joueur;
    }
}
