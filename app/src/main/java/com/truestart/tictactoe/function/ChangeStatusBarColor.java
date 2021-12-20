package com.truestart.tictactoe.function;

import android.content.Context;
import android.view.Window;

import com.truestart.tictactoe.R;

public class ChangeStatusBarColor {

    public ChangeStatusBarColor() {}

    public void defColor(Window window, Context context) {
        window.setStatusBarColor(context.getColor(R.color.appColor));
    }
}
