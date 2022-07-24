package com.nhuy.sendobjectlistobject1part4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MY_ACTION = "com.nhuy.ACTION";
    private static final String MY_USER = "com.nhuy.USER";

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
        Intent intent = new Intent(MY_ACTION);
        User user1 = new User(1, "nhu Y");
        User user2 = new User(2, "Đặng Huỳnh Như Y");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
        String strJson = jsonArray.toString();

        intent.putExtra(MY_USER, strJson);

        sendBroadcast(intent);
        Toast.makeText(this, "Send broadcast success", Toast.LENGTH_SHORT).show();
    }
}