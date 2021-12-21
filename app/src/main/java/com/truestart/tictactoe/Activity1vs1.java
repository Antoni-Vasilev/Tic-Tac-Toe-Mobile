package com.truestart.tictactoe;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.truestart.tictactoe.function.ChangeStatusBarColor;

public class Activity1vs1 extends AppCompatActivity {

    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, playerReady;

    int player = 1;

    int[][] map;

    private static final String TITLE = "1 vs 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1vs1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setTitle(TITLE);

        new ChangeStatusBarColor().defColor(getWindow(), this);

        map = new int[3][3];

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        playerReady = findViewById(R.id.playerReady);

        actionButton();
    }

    private void actionButton() {
        btn1.setOnClickListener(v -> buttonClick(btn1, 0, 0));
        btn2.setOnClickListener(v -> buttonClick(btn2, 1, 0));
        btn3.setOnClickListener(v -> buttonClick(btn3, 2, 0));
        btn4.setOnClickListener(v -> buttonClick(btn4, 0, 1));
        btn5.setOnClickListener(v -> buttonClick(btn5, 1, 1));
        btn6.setOnClickListener(v -> buttonClick(btn6, 2, 1));
        btn7.setOnClickListener(v -> buttonClick(btn7, 0, 2));
        btn8.setOnClickListener(v -> buttonClick(btn8, 1, 2));
        btn9.setOnClickListener(v -> buttonClick(btn9, 2, 2));
    }

    @SuppressLint("SetTextI18n")
    private void buttonClick(TextView textView, int x, int y) {
        String text = textView.getText().toString();
        if (!text.isEmpty() || player == 0) {
            return;
        }
        if (player == 1) {
            textView.setText("x");
            playerReady.setText("Player O is ready");
            map[y][x] = player;
            player++;
        } else if (player == 2) {
            textView.setText("o");
            playerReady.setText("Player X is ready");
            map[y][x] = player;
            player--;
        }

        viewForWinner();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void viewForWinner() {
        Drawable background = getDrawable(R.drawable.win_border);
        if (map[0][0] == map[0][1] && map[0][1] == map[0][2] && map[0][0] != 0) {
            btn1.setBackground(background);
            btn2.setBackground(background);
            btn3.setBackground(background);
            playerWinner();
        } else if (map[1][0] == map[1][1] && map[1][1] == map[1][2] && map[1][0] != 0) {
            btn4.setBackground(background);
            btn5.setBackground(background);
            btn6.setBackground(background);
            playerWinner();
        } else if (map[2][0] == map[2][1] && map[2][1] == map[2][2] && map[2][0] != 0) {
            btn7.setBackground(background);
            btn8.setBackground(background);
            btn9.setBackground(background);
            playerWinner();
        } else if (map[0][0] == map[1][0] && map[1][0] == map[2][0] && map[0][0] != 0) {
            btn1.setBackground(background);
            btn4.setBackground(background);
            btn7.setBackground(background);
            playerWinner();
        } else if (map[0][1] == map[1][1] && map[1][1] == map[2][1] && map[0][1] != 0) {
            btn2.setBackground(background);
            btn5.setBackground(background);
            btn8.setBackground(background);
            playerWinner();
        } else if (map[0][2] == map[1][2] && map[1][2] == map[2][2] && map[0][2] != 0) {
            btn3.setBackground(background);
            btn6.setBackground(background);
            btn9.setBackground(background);
            playerWinner();
        } else if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] != 0) {
            btn1.setBackground(background);
            btn5.setBackground(background);
            btn9.setBackground(background);
            playerWinner();
        } else if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] != 0) {
            btn3.setBackground(background);
            btn5.setBackground(background);
            btn7.setBackground(background);
            playerWinner();
        } else {
            boolean draw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 0) {
                        draw = false;
                        break;
                    }
                }
            }

            if (draw) {
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("Game end")
                        .setMessage("Draw")
                        .setCancelable(true)
                        .setPositiveButton("Restart", (dialog, which) -> {
                            map = new int[3][3];
                            btn1.setText(null);
                            btn2.setText(null);
                            btn3.setText(null);
                            btn4.setText(null);
                            btn5.setText(null);
                            btn6.setText(null);
                            btn7.setText(null);
                            btn8.setText(null);
                            btn9.setText(null);
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> super.onBackPressed())
                        .create();
                alertDialog.show();
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void playerWinner() {
        Drawable background = getDrawable(R.drawable.border);
        String winner = null;
        if (player == 1) {
            winner = "O";
        } else if (player == 2) {
            winner = "X";
        }
        player = 0;
        String finalWinner = winner;
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Game end")
                .setMessage(String.format("%s winner", winner))
                .setPositiveButton("Restart", (dialog, which) -> {
                    map = new int[3][3];
                    btn1.setText(null);
                    btn2.setText(null);
                    btn3.setText(null);
                    btn4.setText(null);
                    btn5.setText(null);
                    btn6.setText(null);
                    btn7.setText(null);
                    btn8.setText(null);
                    btn9.setText(null);
                    btn1.setBackground(background);
                    btn2.setBackground(background);
                    btn3.setBackground(background);
                    btn4.setBackground(background);
                    btn5.setBackground(background);
                    btn6.setBackground(background);
                    btn7.setBackground(background);
                    btn8.setBackground(background);
                    btn9.setBackground(background);
                    if (finalWinner.equals("X")) {
                        player = 2;
                    } else {
                        player = 1;
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> super.onBackPressed())
                .create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}