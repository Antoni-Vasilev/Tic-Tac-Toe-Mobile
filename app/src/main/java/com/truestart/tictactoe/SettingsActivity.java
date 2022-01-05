package com.truestart.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.truestart.tictactoe.function.ChangeStatusBarColor;
import com.truestart.tictactoe.function.ShowScreen;

public class SettingsActivity extends AppCompatActivity {

    private static final String TITLE = "Settings";

    Button gameSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        new ChangeStatusBarColor().defColor(getWindow(), this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setTitle(TITLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        gameSize = findViewById(R.id.gameSize);
        addActionButton();
    }

    private void addActionButton() {
        gameSize.setOnClickListener(v -> new ShowScreen(this, GameSizeActivity.class, true));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}