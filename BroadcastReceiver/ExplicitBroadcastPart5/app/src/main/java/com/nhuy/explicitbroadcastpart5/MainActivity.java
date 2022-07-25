package com.nhuy.explicitbroadcastpart5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String MY_TEXT = "com.Nhuy.MY_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendBroadcast = findViewById(R.id.btn_send_broadcast);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.nhuy.explicitbroadcast2part5", "com.nhuy.explicitbroadcast2part5.MyBroadcast2");
        intent.putExtra(MY_TEXT, "This is Như Y");
        sendBroadcast(intent);
    }
}