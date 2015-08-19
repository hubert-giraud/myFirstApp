package com.haluberlu.myfirstapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends Activity {



    Button j1AddBtn;
    Button j1SubBtn;

    Button j2AddBtn;
    Button j2SubBtn;

    EditText ptsEditJ1;
    EditText ptsEditJ2;

    TextView ptsJ1;
    TextView ptsJ2;
    TextView nomJ1;
    TextView nomJ2;
    TextView nomGame;

    int nbPtsJ1;
    int nbPtsJ2;

    Partie partie;

    PartiesBDD partiesBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        j1AddBtn = (Button) findViewById(R.id.ajouter_j1);
        j2AddBtn = (Button) findViewById(R.id.ajouter_j2);

        j1SubBtn = (Button) findViewById(R.id.soustraire_j1);
        j2SubBtn = (Button) findViewById(R.id.soustraire_j2);

        ptsEditJ1 = (EditText) findViewById(R.id.pts_j1_ET);
        ptsEditJ2 = (EditText) findViewById(R.id.pts_j2_ET);

        ptsJ1 = (TextView) findViewById(R.id.pts_j1_TV);
        ptsJ2 = (TextView) findViewById(R.id.pts_j2_TV);
        nomJ1 = (TextView) findViewById(R.id.nomJ1);
        nomJ2 = (TextView) findViewById(R.id.nomJ2);
        nomGame = (TextView) findViewById(R.id.nomGame);

        nbPtsJ1 = 0;
        nbPtsJ2 = 0;

        j1AddBtn.setOnClickListener(addListener);
        j2AddBtn.setOnClickListener(addListener);
        j1SubBtn.setOnClickListener(subListener);
        j2SubBtn.setOnClickListener(subListener);

        partiesBDD = new PartiesBDD(this);

        partiesBDD.open();

        Intent i = getIntent();
        String originator = i.getStringExtra("originator");

        //Bundle extras = i.getExtras();

        //ne fonctionne pas, parcelable ou extra?
        if(originator.equals("createGame")) {
            partie = i.getParcelableExtra(createGame.NOM);
            partie.setPtsJ1(0);
            partie.setPtsJ2(0);
            partiesBDD.insertPartie(partie);
        } else {
            partie = partiesBDD.getPartie(i.getStringExtra(Reprendre.NOM_PARTIE));
            nbPtsJ1 = partie.getPtsJ1();
            nbPtsJ2 = partie.getPtsJ2();
        }

        nomGame.setText(partie.getNomPartie());
        nomJ1.setText(partie.getNomJ1());
        nomJ2.setText(partie.getNomJ2());
        ptsJ1.setText("" + nbPtsJ1);
        ptsJ2.setText("" + nbPtsJ2);
    }

    private View.OnClickListener addListener = new View.OnClickListener() {

        String p;
        int pValue;

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.ajouter_j1:
                    p = ptsEditJ1.getText().toString();

                    if(!"".equals(p)) {
                        pValue = Integer.parseInt(p); // pk valueOf?
                        nbPtsJ1 += pValue;
                        ptsJ1.setText(nbPtsJ1 + " points");
                        partie.setPtsJ1(nbPtsJ1);
                        ptsEditJ1.getText().clear();
                    }
                    break;

                case R.id.ajouter_j2:
                    p = ptsEditJ2.getText().toString();

                    if(!"".equals(p)) {
                        pValue = Integer.parseInt(p); // pk valueOf?
                        nbPtsJ2 += pValue;
                        ptsJ2.setText(nbPtsJ2 + " points");
                        partie.setPtsJ2(nbPtsJ2);
                        ptsEditJ2.getText().clear();
                    }
            }
        }
    };

    private View.OnClickListener subListener = new View.OnClickListener() {

        String p;
        int pValue;

        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.soustraire_j1 :
                    p = ptsEditJ1.getText().toString();
                    if(!"".equals(p)){
                        pValue = Integer.parseInt(p);
                        nbPtsJ1 -= pValue;
                        ptsJ1.setText(nbPtsJ1 + " points");
                        partie.setPtsJ1(nbPtsJ1);
                        ptsEditJ1.getText().clear();
                    }
                    break;

                case R.id.soustraire_j2 :
                    p = ptsEditJ2.getText().toString();
                    if(!"".equals(p)) {
                        pValue = Integer.parseInt(p);
                        nbPtsJ2 -= pValue;
                        ptsJ2.setText(nbPtsJ2 + " points");
                        partie.setPtsJ2(nbPtsJ2);
                        ptsEditJ2.getText().clear();
                    }
                    break;
            }
        }
    };

    protected void onStop() {
        PartiesBDD partiesBDD = new PartiesBDD(this);
        partiesBDD.open();
        partiesBDD.update(partie);
        partiesBDD.close();
        super.onStop();
    }

    @Override
    protected void onResume() {
        partiesBDD.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        partiesBDD.close();
        super.onPause();
    }
}
