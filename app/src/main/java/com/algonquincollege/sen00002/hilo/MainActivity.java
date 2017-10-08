package com.algonquincollege.sen00002.hilo;

/**
 * The purpose of this app is to make guesses from numbers 1 to 1000 and you will be given 10 chances if
 * you take less then five chances you are a great player and if you take more than 5 chances then you are
 * a good player and if you lose then you obviously suck!!
 *
 * @author Rajat + Sen (sen00002@algonquinlive.com)
 * October 07,2017
 */

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView userGuessCount, userGuessCountRemain;
    EditText userGuess;
    Button guess, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userGuessCount = (TextView) findViewById(R.id.guesser);
        userGuessCountRemain = (TextView) findViewById(R.id.left_guesses);

        userGuess = (EditText) findViewById(R.id.Getter);

        guess = (Button) findViewById(R.id.Guess);
        reset = (Button) findViewById(R.id.Resetter);

        final hilo Game = new hilo();
        setDisplay("0", "0");

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userGuess.getText().toString().length() > 0) {
                    short ug = (short) Integer.parseInt(userGuess.getText().toString());
                    if (userGuessValidation(ug)) {
                        Game.gamePlay(ug);
                        if (Game.getUserGuessCount() < 11) {
                            userGuessCount.setText(String.valueOf(Game.getUserGuessCount()));
                            short remain = (short) (10 - Game.getUserGuessCount());
                            userGuessCountRemain.setText(String.valueOf(remain));
                            Toast.makeText(getApplicationContext(), Game.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), Game.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                } else {
                    userGuess.setError("Required");
                    userGuess.requestFocus();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.hilo_playagain();
                setDisplay("0", "0");
            }
        });

        reset.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "TheNumber : " + String.valueOf(Game.getTheNumber()), Toast.LENGTH_LONG).show();
                Game.hilo_playagain();
                setDisplay("0", "0");
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.themenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.About_Action:
                DialogFragment aboutDialog = new AboutDialog();
                aboutDialog.show(getFragmentManager(), "about");
                break;
        }
        return true;
    }

    public void setDisplay(String userGuessCount, String userGuessCountRemain) {
        this.userGuessCount.setText(userGuessCount);
        this.userGuessCountRemain.setText(userGuessCountRemain);
        userGuess.setText("");
    }

    public boolean userGuessValidation(short userGuess) {
        if ((userGuess >= 1) && (userGuess <= 1000)) {
            return true;
        }
        this.userGuess.setError("range should be between 1 to 1000");
        this.userGuess.requestFocus();
        return false;
    }
}
