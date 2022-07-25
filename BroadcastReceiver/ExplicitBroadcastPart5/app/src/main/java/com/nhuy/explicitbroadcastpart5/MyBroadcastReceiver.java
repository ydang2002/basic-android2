package com.nhuy.explicitbroadcastpart5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String MY_TEXT = "com.Nhuy.MY_TEXT";

    @Override
    public void onReceive(Context context, Intent intent) {
        String myText = intent.getStringExtra(MY_TEXT);
        Toast.makeText(context, myText, Toast.LENGTH_SHORT).show();
    }
}
