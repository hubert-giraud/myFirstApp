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

        partiesBDD = new PartiesBDD(this);
        partiesBDD.open();
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
