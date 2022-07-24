package com.nhuy.broadcastreceiverpart1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.InputFilter;

public class MainActivity extends AppCompatActivity {

    private ExampleBroadcastReceiver exampleBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter inputFilter = new IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY);
        registerReceiver(exampleBroadcastReceiver, inputFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(exampleBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}