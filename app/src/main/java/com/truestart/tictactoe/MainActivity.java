package com.truestart.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.truestart.tictactoe.function.ChangeStatusBarColor;
import com.truestart.tictactoe.function.ShowScreen;

public class MainActivity extends AppCompatActivity {

    Button buttonOnePlayer, buttonTwoPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOnePlayer = findViewById(R.id.buttonOnePlayer);
        buttonTwoPlayers = findViewById(R.id.buttonTwoPlayers);
        buttonAction();
    }

    private void buttonAction() {
        buttonOnePlayer.setOnClickListener(v -> new ShowScreen(this, OnePlayerActivity.class));
        buttonTwoPlayers.setOnClickListener(v -> new ShowScreen(this, TwoPlayersActivity.class));
    }

    @Override
    protected void onStart() {
        new ChangeStatusBarColor().defColor(getWindow(), this);
        super.onStart();
    }
}