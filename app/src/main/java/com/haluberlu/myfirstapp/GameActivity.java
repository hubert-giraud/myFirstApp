package com.haluberlu.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by haluberlu on 18/07/2015.
 */
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

        Intent i = getIntent();
        String[] noms = i.getStringArrayExtra(createGame.NOMS);

        if(!"".equals(noms[0])) {
            nomGame.setText(noms[0]);
        }

        if(!"".equals(noms[1])) {
            nomJ1.setText(noms[1]);
        }

        if(!"".equals(noms[2])) {
            nomJ2.setText(noms[2]);
        }
    }

    private View.OnClickListener addListener = new View.OnClickListener() {

        String p;
        int pValue;

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.ajouter_j1:
                    p = ptsEditJ1.getText().toString();

                    pValue = Integer.parseInt(p); // pk valueOf?

                    nbPtsJ1 += pValue;

                    ptsJ1.setText(nbPtsJ1 + " points");

                    ptsEditJ1.getText().clear();
                    break;

                case R.id.ajouter_j2:
                    p = ptsEditJ2.getText().toString();

                    pValue = Integer.parseInt(p); // pk valueOf?

                    nbPtsJ2 += pValue;

                    ptsJ2.setText(nbPtsJ2 + " points");

                    ptsEditJ2.getText().clear();
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
                    pValue = Integer.parseInt(p);
                    nbPtsJ1 -= pValue;
                    ptsJ1.setText(nbPtsJ1 + " points");
                    ptsEditJ1.getText().clear();
                    break;

                case R.id.soustraire_j2 :
                    p = ptsEditJ2.getText().toString();
                    pValue = Integer.parseInt(p);
                    nbPtsJ2 -= pValue;
                    ptsJ2.setText(nbPtsJ2 + " points");
                    ptsEditJ2.getText().clear();
                    break;
            }
        }
    };

}
