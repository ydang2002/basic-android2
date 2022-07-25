package com.nhuy.explicitbroadcast2part5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast2 extends BroadcastReceiver {

    private static final String MY_TEXT = "com.Nhuy.MY_TEXT";

    @Override
    public void onReceive(Context context, Intent intent) {
        String myText = "MyBroadcast2" + intent.getStringExtra(MY_TEXT);
        Toast.makeText(context, myText, Toast.LENGTH_SHORT).show();
    }
}
