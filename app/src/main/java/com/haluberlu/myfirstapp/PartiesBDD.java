package com.haluberlu.myfirstapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class PartiesBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "table_parties";

    private static final String PARTIE_TABLE_NAME = "table_parties";
    private static final String COL_ID = "_id";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "nom_partie";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_NOM_J1 = "nom_J1";
    private static final int NUM_COL_NOM_J1 = 2;
    private static final String COL_NB_PTS_J1 = "nb_pts_J1";
    private static final int NUM_COL_NB_PTS_J1 = 3;
    private static final String COL_NOM_J2 = "nom_J2";
    private static final int NUM_COL_NOM_J2 = 4;
    private static final String COL_NB_PTS_J2 = "nb_pts_J2";
    private static final int NUM_COL_NB_PTS_J2 = 5;

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
        values.put(COL_NOM_J1, partie.getNomJ1());
        values.put(COL_NOM_J2, partie.getNomJ2());

        return bdd.insert(PARTIE_TABLE_NAME,null, values);
    }

    public int update(Partie partie) {
        ContentValues values = new ContentValues();
        values.put(COL_NB_PTS_J1, partie.getPtsJ1());
        values.put(COL_NB_PTS_J2, partie.getPtsJ2());
        String nomPartie = partie.getNomPartie();

        return bdd.update(PARTIE_TABLE_NAME, values, COL_NOM + " =?", new String[] {nomPartie}); //il propose de simplifier en ne mettant que partie ds 3ème champs...

    }

    public Partie getPartie(String nom) {
        String[] colonnesTab = {COL_ID, COL_NOM, COL_NOM_J1, COL_NB_PTS_J1, COL_NOM_J2, COL_NB_PTS_J2};
        Cursor c = bdd.query(PARTIE_TABLE_NAME, colonnesTab, COL_NOM + " LIKE \"" + nom + "\"", null, null, null, null);
        return cursorToPartie(c);
    }

    private Partie cursorToPartie(Cursor c) {
        if(c.getCount() == 0) return null;

        c.moveToFirst();

        Partie partie = new Partie();
        partie.setId(c.getInt(NUM_COL_ID));
        partie.setNomPartie(c.getString(NUM_COL_NOM));
        partie.setNomJ1(c.getString(NUM_COL_NOM_J1));
        partie.setNomJ2(c.getString(NUM_COL_NOM_J2));
        partie.setPtsJ1(c.getInt(NUM_COL_NB_PTS_J1));
        partie.setPtsJ2(c.getInt(NUM_COL_NB_PTS_J2));

        c.close();

        return partie;
    }

    public String[] getPartiesName() {
        Cursor c = bdd.rawQuery("select " + COL_NOM + ", " + COL_ID + " from " + PARTIE_TABLE_NAME + " order by " + COL_ID + " desc;", null);
        String[] partiesName = new String[c.getCount()];

        while(c.moveToNext()) {
            partiesName[c.getPosition()] = c.getString(0);
        }
        c.close();
        return partiesName;
    }
}
