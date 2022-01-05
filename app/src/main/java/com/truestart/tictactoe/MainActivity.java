package com.truestart.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.truestart.tictactoe.function.ChangeStatusBarColor;
import com.truestart.tictactoe.function.ShowScreen;

public class MainActivity extends AppCompatActivity {

    Button buttonOnePlayer, buttonTwoPlayers;

    private static final String TITLE = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setTitle(TITLE);

        buttonOnePlayer = findViewById(R.id.buttonOnePlayer);
        buttonTwoPlayers = findViewById(R.id.buttonTwoPlayers);
        buttonAction();
    }

    private void buttonAction() {
        buttonOnePlayer.setOnClickListener(v -> new ShowScreen(this, OnePlayerActivity.class, true));
        buttonTwoPlayers.setOnClickListener(v -> new ShowScreen(this, TwoPlayersActivity.class, true));
    }

    @Override
    protected void onStart() {
        new ChangeStatusBarColor().defColor(getWindow(), this);
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            new ShowScreen(this, SettingsActivity.class, true);
        }
        return super.onOptionsItemSelected(item);
    }
}