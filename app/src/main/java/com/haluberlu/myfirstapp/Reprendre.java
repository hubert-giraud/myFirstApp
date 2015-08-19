package com.haluberlu.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reprendre extends ListActivity {

    private String[] nomParties;
    private PartiesBDD partiesBDD;

    public static final String NOM_PARTIE = "com.haluberlu.myfirstapp.Reprendre.NOM_PARTIE";

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String nom = nomParties[position];
        Intent i = new Intent(Reprendre.this, GameActivity.class);
        i.putExtra(NOM_PARTIE, nom);
        i.putExtra("originator", "Reprendre");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        Partie partie1 = new Partie();
        partie1.setNomPartie("partie1");
        partie1.setNomJ1("j1");
        partie1.setNomJ2("j2");

        Partie partie2 = new Partie();
        partie2.setNomPartie("partie2");
        partie2.setNomJ1("j3");
        partie2.setNomJ2("j4");

        partiesBDD = new PartiesBDD(this);
        partiesBDD.open();
        partiesBDD.insertPartie(partie1);
        partiesBDD.insertPartie(partie2);
        nomParties = partiesBDD.getPartiesName();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomParties);
        setListAdapter(adapter);
    }

    @Override
    protected void onPause() {
        partiesBDD.close();
        super.onPause();
    }

    @Override
    protected void onResume() {
        partiesBDD.open();
        super.onResume();
    }
}
