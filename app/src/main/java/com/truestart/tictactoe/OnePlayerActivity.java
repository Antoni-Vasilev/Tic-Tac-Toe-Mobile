package com.truestart.tictactoe;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.truestart.tictactoe.function.ChangeStatusBarColor;

import java.util.Objects;
import java.util.Random;

public class OnePlayerActivity extends AppCompatActivity {

    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, playerReady;

    int player = 1;

    int[][] map;

    private static final String TITLE = "One Player     X:0   Y:0";

    private boolean isRobotTurn = false;

    int scoreX = 0, scoreY = 0;

    FloatingActionButton refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

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
        refreshButton = findViewById(R.id.refreshButton);

        actionButton();
    }

    private void actionButton() {
        btn1.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn1, 0, 0);
        });
        btn2.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn2, 0, 1);
        });
        btn3.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn3, 0, 2);
        });
        btn4.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn4, 1, 0);
        });
        btn5.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn5, 1, 1);
        });
        btn6.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn6, 1, 2);
        });
        btn7.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn7, 2, 0);
        });
        btn8.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn8, 2, 1);
        });
        btn9.setOnClickListener(v -> {
            isRobotTurn = true;
            buttonClick(btn9, 2, 2);
        });
        refreshButton.setOnClickListener(v -> restartGame());
    }

    @SuppressLint("SetTextI18n")
    private void buttonClick(TextView textView, int y, int x) {
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
        if (isRobotTurn) {
            RobotFunction();
        }
        isRobotTurn = false;

        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void RobotFunction() {
        isRobotTurn = false;

        if (map[0][0] == map[0][1] && map[0][0] != 0 && map[0][2] == 0) {
            buttonClick(btn3, 0, 2);
            return;
        } else if (map[0][0] == map[0][2] && map[0][0] != 0 && map[0][1] == 0) {
            buttonClick(btn2, 0, 1);
            return;
        } else if (map[0][1] == map[0][2] && map[0][1] != 0 && map[0][0] == 0) {
            buttonClick(btn1, 0, 0);
            return;
        } else if (map[1][0] == map[1][1] && map[1][0] != 0 && map[1][2] == 0) {
            buttonClick(btn6, 1, 2);
            return;
        } else if (map[1][0] == map[1][2] && map[1][0] != 0 && map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
            return;
        } else if (map[1][1] == map[1][2] && map[1][1] != 0 && map[1][0] == 0) {
            buttonClick(btn4, 1, 0);
            return;
        } else if (map[2][0] == map[2][1] && map[2][0] != 0 && map[2][2] == 0) {
            buttonClick(btn9, 2, 2);
            return;
        } else if (map[2][0] == map[2][2] && map[2][0] != 0 && map[2][1] == 0) {
            buttonClick(btn8, 2, 1);
            return;
        } else if (map[2][1] == map[2][2] && map[2][1] != 0 && map[2][0] == 0) {
            buttonClick(btn7, 2, 0);
            return;
        } else if (map[0][0] == map[1][0] && map[0][0] != 0 && map[2][0] == 0) {
            buttonClick(btn7, 2, 0);
            return;
        } else if (map[0][0] == map[2][0] && map[0][0] != 0 && map[1][0] == 0) {
            buttonClick(btn4, 1, 0);
            return;
        } else if (map[1][0] == map[2][0] && map[1][0] != 0 && map[0][0] == 0) {
            buttonClick(btn1, 0, 0);
            return;
        } else if (map[0][1] == map[1][1] && map[0][1] != 0 && map[2][1] == 0) {
            buttonClick(btn8, 2, 1);
            return;
        } else if (map[0][1] == map[2][1] && map[0][1] != 0 && map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
            return;
        } else if (map[1][1] == map[2][1] && map[1][1] != 0 && map[0][1] == 0) {
            buttonClick(btn2, 0, 1);
            return;
        } else if (map[0][2] == map[1][2] && map[0][2] != 0 && map[2][2] == 0) {
            buttonClick(btn9, 2, 2);
            return;
        } else if (map[0][2] == map[2][2] && map[0][2] != 0 && map[1][2] == 0) {
            buttonClick(btn6, 1, 2);
            return;
        } else if (map[1][2] == map[2][2] && map[1][2] != 0 && map[0][2] == 0) {
            buttonClick(btn3, 0, 2);
            return;
        } else if (map[0][0] == map[2][2] && map[0][0] != 0 && map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
            return;
        } else if (map[0][0] == map[1][1] && map[0][0] != 0 && map[2][2] == 0) {
            buttonClick(btn9, 2, 2);
            return;
        } else if (map[1][1] == map[2][2] && map[1][1] != 0 && map[0][0] == 0) {
            buttonClick(btn1, 0, 0);
            return;
        } else if (map[0][2] == map[1][1] && map[0][2] != 0 && map[2][0] == 0) {
            buttonClick(btn7, 2, 0);
            return;
        } else if (map[0][2] == map[2][0] && map[0][2] != 0 && map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
            return;
        } else if (map[2][0] == map[1][1] && map[2][0] != 0 && map[0][2] == 0) {
            buttonClick(btn3, 0, 2);
            return;
        }

        Random random = new Random();

        if (map[2][0] != 0 && map[0][2] != 0 && map[2][0] == map[0][2]) {
            if (map[0][1] == 0) {
                buttonClick(btn2, 0, 1);
                return;
            } else if (map[2][1] == 0) {
                buttonClick(btn8, 2, 1);
                return;
            } else if (map[1][0] == 0) {
                buttonClick(btn4, 1, 0);
                return;
            } else if (map[1][2] == 0) {
                buttonClick(btn6, 1, 2);
                return;
            }
        } else if (map[2][2] != 0 && map[0][0] != 0 && map[2][2] == map[0][0]) {
            if (map[0][1] == 0) {
                buttonClick(btn2, 0, 1);
                return;
            } else if (map[2][1] == 0) {
                buttonClick(btn8, 2, 1);
                return;
            } else if (map[1][0] == 0) {
                buttonClick(btn4, 1, 0);
                return;
            } else if (map[1][2] == 0) {
                buttonClick(btn6, 1, 2);
                return;
            }
        }

        if (map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
            return;
        } else if (map[2][0] == 0) {
            buttonClick(btn7, 2, 0);
            return;
        }

        int corner = random.nextInt(15);
        if (corner < 5 && map[0][0] == 0) {
            buttonClick(btn1, 0, 0);
            return;
        } else if (corner > 5 && corner <= 10 && map[0][2] == 0) {
            buttonClick(btn3, 0, 2);
            return;
        } else if (corner > 10 && map[2][2] == 0) {
            buttonClick(btn9, 2, 2);
            return;
        } else {
            if (map[0][0] == 0) {
                buttonClick(btn1, 0, 0);
                return;
            } else if (map[0][2] == 0) {
                buttonClick(btn3, 0, 2);
                return;
            } else if (map[2][2] == 0) {
                buttonClick(btn9, 2, 2);
                return;
            }
        }

        if (map[0][0] == 0) {
            buttonClick(btn1, 0, 0);
        } else if (map[0][2] == 0) {
            buttonClick(btn3, 0, 2);
        } else if (map[1][1] == 0) {
            buttonClick(btn5, 1, 1);
        } else if (map[2][0] == 0) {
            buttonClick(btn7, 2, 0);
        } else if (map[2][2] == 0) {
            buttonClick(btn9, 2, 2);
        } else if (map[0][1] == 0) {
            buttonClick(btn2, 0, 1);
        } else if (map[1][0] == 0) {
            buttonClick(btn4, 1, 0);
        } else if (map[1][2] == 0) {
            buttonClick(btn6, 1, 2);
        } else if (map[2][1] == 0) {
            buttonClick(btn8, 2, 1);
        }
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
                refreshButton.setVisibility(View.VISIBLE);
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("Game end")
                        .setMessage("Draw")
                        .setCancelable(true)
                        .setPositiveButton("Restart", (dialog, which) -> {
                            restartGame();
                            if (player == 2) {
                                RobotFunction();
                            }
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> super.onBackPressed())
                        .create();
                alertDialog.show();
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "DefaultLocale"})
    private void playerWinner() {
        String winner = null;
        if (player == 1) {
            winner = "O";
        } else if (player == 2) {
            winner = "X";
        }

        if (player == 2) {
            scoreX++;
        } else if (player == 1) {
            scoreY++;
        }

        Objects.requireNonNull(getSupportActionBar()).setTitle(String.format("One Player     X:%d   Y:%d", scoreX, scoreY));

        int savePlayer = player;
        refreshButton.setVisibility(View.VISIBLE);
        player = 0;
        isRobotTurn = false;
        String finalWinner = winner;
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Game end")
                .setMessage(String.format("%s win", winner))
                .setPositiveButton("Restart", (dialog, which) -> {
                    restartGame();
                    if (finalWinner.equals("X")) {
                        player = 2;
                    } else {
                        player = 1;
                    }

                    if (savePlayer == 2) {
                        RobotFunction();
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

    private void restartGame() {
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.border);
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
        refreshButton.setVisibility(View.GONE);
    }
}