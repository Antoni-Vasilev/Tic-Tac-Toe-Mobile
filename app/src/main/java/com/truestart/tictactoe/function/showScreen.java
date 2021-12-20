package com.truestart.tictactoe.function;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class showScreen {

    public showScreen(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    public showScreen(Context context, Class activity, boolean isSave) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
        if (isSave) {
            ((Activity) context).finish();
        }
    }
}
