package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity {

    ImageView player, fighter;
    ImageButton back, forward;
    Button punchButton, kickButton;

    RelativeLayout.LayoutParams playerParameters;
    RelativeLayout.LayoutParams fighterParameters;

    static class Match {

        int firstPlayerHealthPoints = 100;
        int secondPlayerHealthPoints = 100;
        int firstPlayerPosition = 400;
        int secondPlayerPosition = 1000;

    }

    static void punch(ImageView img) {

        img.setImageResource(R.drawable.fightertwo);
        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                () -> img.setImageResource(R.drawable.fighterone),800
        );

    }

    static void kick(ImageView img) {

        img.setImageResource(R.drawable.fighterthree);
        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                () -> img.setImageResource(R.drawable.fighterone),800
        );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Match match = new Match();

        playerParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        playerParameters.leftMargin = match.firstPlayerPosition;
        playerParameters.topMargin = 100;

        fighterParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        fighterParameters.leftMargin = match.secondPlayerPosition;
        fighterParameters.topMargin = 100;

        player = findViewById(R.id.imageView2);
        fighter = findViewById(R.id.imageView3);
        back = findViewById(R.id.imageButton);
        forward = findViewById(R.id.imageButton2);
        punchButton = findViewById(R.id.button6);
        kickButton = findViewById(R.id.button7);

        player.setLayoutParams(playerParameters);
        fighter.setLayoutParams(fighterParameters);

        back.setOnClickListener(view -> {

            if (match.firstPlayerPosition > 100) {

                match.firstPlayerPosition -= 100;
                playerParameters.leftMargin = match.firstPlayerPosition;
                player.setLayoutParams(playerParameters);

            }

        });

        forward.setOnClickListener(view -> {

            if (match.firstPlayerPosition < 1700) {

                match.firstPlayerPosition += 100;
                playerParameters.leftMargin = match.firstPlayerPosition;
                player.setLayoutParams(playerParameters);

            }

        });


        punchButton.setOnClickListener(view -> punch(player));

        kickButton.setOnClickListener(view -> kick(player));

    }
}