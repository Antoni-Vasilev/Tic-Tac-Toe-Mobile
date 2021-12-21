package com.truestart.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.truestart.tictactoe.function.ChangeStatusBarColor;
import com.truestart.tictactoe.function.ShowScreen;

public class MainActivity extends AppCompatActivity {

    Button button1vs1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1vs1 = findViewById(R.id.button1vs1);
        buttonAction();
    }

    private void buttonAction() {
        button1vs1.setOnClickListener(v -> new ShowScreen(this, Activity1vs1.class));
    }

    @Override
    protected void onStart() {
        new ChangeStatusBarColor().defColor(getWindow(), this);
        super.onStart();
    }
}