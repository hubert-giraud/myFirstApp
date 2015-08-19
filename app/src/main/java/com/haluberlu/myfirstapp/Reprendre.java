package com.haluberlu.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haluberlu on 17/08/2015.
 */
public class Reprendre extends ListActivity {

    private String[] nomParties;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String nom = nomParties[position];
        Intent i = new Intent(Reprendre.this, GameActivity.class);
        i.putExtra("com.haluberlu.myfirstapp.Reprendre.NOM_PARTIE", nom);
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

        PartiesBDD partiesBDD = new PartiesBDD(this);
        partiesBDD.open();
        partiesBDD.insertPartie(partie1);
        partiesBDD.insertPartie(partie2);
        nomParties = partiesBDD.getPartiesName();

        partiesBDD.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomParties);

        //ListView liste = (ListView) findViewById(android.R.id.list);

        //liste.setAdapter(adapter);
        setListAdapter(adapter);

    }
}
