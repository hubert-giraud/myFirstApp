package com.haluberlu.myfirstapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * Created by haluberlu on 05/08/2015.
 */
public class PartiesBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "parties.db";

    private static final String PARTIE_TABLE_NAME = "table_parties";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "Nom";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_NB_JOUEURS= "Nb_joueurs";
    private static final int NUM_COL_NB_JOUEURS = 2;
    private static final String COL_NOM_J1 = "Nom_J1";
    private static final int NUM_COL_NOM_J1 = 3;
    private static final String COL_NB_PTS_J1 = "Nb_pts_J1";
    private static final int NUM_COL_NB_PTS_J1 = 4;
    private static final String COL_NOM_J2 = "Nom_J2";
    private static final int NUM_COL_NOM_J2 = 5;
    private static final String COL_NB_PTS_J2 = "Nb_pts_J2";
    private static final int NUM_COL_NB_PTS_J2 = 6;
    private static final String COL_NOM_J3 = "Nom_J3";
    private static final int NUM_COL_NOM_J3 = 7;
    private static final String COL_NB_PTS_J3 = "Nb_pts_J3";
    private static final int NUM_COL_NB_PTS_J3 = 8;
    private static final String COL_NOM_J4 = "Nom_J4";
    private static final int NUM_COL_NOM_J4 = 9;
    private static final String COL_NB_PTS_J4 = "Nb_pts_J4";
    private static final int NUM_COL_NB_PTS_J4 = 10;

    private SQLiteDatabase bdd;

    private PartieBddHandler partieBddHandler;

    public PartiesBDD(Context context) {
        partieBddHandler = new PartieBddHandler(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        bdd = partieBddHandler.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getPartiesBDD() {
        return bdd;
    }

    public long insertPartie(Partie partie) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM, partie.getNomPartie());
        values.put(COL_NB_JOUEURS, partie.getNbJoueurs());
        values.put(COL_NOM_J1, partie.getNomJ1());
        values.put(COL_NOM_J2, partie.getNomJ2());
        values.put(COL_NOM_J3, partie.getNomJ3());
        values.put(COL_NOM_J4, partie.getNomJ4());

        return bdd.insert(PARTIE_TABLE_NAME,null, values);
    }

    public Partie getPartie(String nom) {
        String[] colonnesTab = {COL_NOM, COL_NB_JOUEURS, COL_NOM_J1, COL_NB_PTS_J1, COL_NOM_J2, COL_NB_PTS_J2, COL_NOM_J3, COL_NB_PTS_J3, COL_NOM_J4, COL_NB_PTS_J4};
        Cursor c = bdd.query(PARTIE_TABLE_NAME, colonnesTab, COL_NOM + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToPartie(c);
    }

    private Partie cursorToPartie(Cursor c) {
        if(c.getCount() == 0) return null;

        c.moveToFirst();

        Partie partie = new Partie();
        partie.setId(c.getInt(NUM_COL_ID));
        partie.setNomPartie(c.getString(NUM_COL_NOM));
        partie.setNbJoueurs(c.getInt(NUM_COL_NB_JOUEURS));
        partie.setNomJ1(c.getString(NUM_COL_NOM_J1));
        partie.setNomJ2(c.getString(NUM_COL_NOM_J2));
        partie.setNomJ3(c.getString(NUM_COL_NOM_J3));
        partie.setNomJ4(c.getString(NUM_COL_NOM_J4));
        partie.setPtsJ1(c.getInt(NUM_COL_NB_PTS_J1));
        partie.setPtsJ2(c.getInt(NUM_COL_NB_PTS_J2));
        partie.setPtsJ3(c.getInt(NUM_COL_NB_PTS_J3));
        partie.setPtsJ4(c.getInt(NUM_COL_NB_PTS_J4));

        c.close();

        return partie;
    }
}
