package com.haluberlu.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class createGame extends Activity {

    public static final String NOM = "com.haluberlu.myfirstapp..createGame.NOM";

    private EditText nomPartie;
    private EditText nomJ1ET;
    private EditText nomJ2ET;
    private Button createGameBtn;

    private String activityName = "createGame";

    @Override
    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_create_game);

        nomPartie = (EditText) findViewById(R.id.nomPartie);
        nomJ1ET = (EditText) findViewById(R.id.nomJoueur1);
        nomJ2ET = (EditText) findViewById(R.id.nomJoueur2);
        createGameBtn = (Button) findViewById(R.id.startGame);

        createGameBtn.setOnClickListener(startGameListener);

        //JoueurBDD joueurBDD = new JoueurBDD(this);



    }

    private View.OnClickListener startGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(createGame.this, GameActivity.class);
            //String[] noms = new String[] {nomPartie.getText().toString(), nomJ1ET.getText().toString(), nomJ2ET.getText().toString()};
            //intent.putExtra(NOMS, noms);
            Partie partie = new Partie();
            partie.setNomPartie(nomPartie.getText().toString());
            partie.setNomJ1(nomJ1ET.getText().toString());
            partie.setNomJ2(nomJ2ET.getText().toString());
            intent.putExtra("originator", activityName);
            intent.putExtra(NOM, partie);
            startActivity(intent);
        }
    };
}
