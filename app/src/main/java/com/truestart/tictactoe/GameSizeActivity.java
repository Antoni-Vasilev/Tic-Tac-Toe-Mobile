package com.truestart.tictactoe;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.truestart.tictactoe.function.ChangeStatusBarColor;

import java.text.NumberFormat;
import java.util.Currency;

public class GameSizeActivity extends AppCompatActivity {

    Slider slider;
    Button save;

    float sizeGame = 1;

    LinearLayout linearLayout;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_size);

        new ChangeStatusBarColor().defColor(getWindow(), this);

        linearLayout = findViewById(R.id.gameView);
        slider = findViewById(R.id.slider);
        save = findViewById(R.id.save);

        slider.setLabelFormatter(value -> {
            sizeGame = value;
            linearLayout.animate().scaleY(value);
            linearLayout.animate().scaleX(value);
            return "x" + value;
        });

        loadSize();
        addActionButton();
    }

    private void addActionButton() {
        SharedPreferences.Editor editor = getSharedPreferences("AppSize", MODE_PRIVATE).edit();
        save.setOnClickListener(v -> {
            editor.putFloat("size", sizeGame);
            editor.apply();
            super.onBackPressed();
        });
    }

    private void loadSize() {
        SharedPreferences sharedPreferences = getSharedPreferences("AppSize", MODE_PRIVATE);
        sizeGame = sharedPreferences.getFloat("size", 1.0f);
        slider.setValue(sizeGame);
        linearLayout.animate().scaleY(sizeGame);
        linearLayout.animate().scaleX(sizeGame);
    }
}