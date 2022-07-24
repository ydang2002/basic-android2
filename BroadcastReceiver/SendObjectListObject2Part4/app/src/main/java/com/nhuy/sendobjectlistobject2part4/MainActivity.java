package com.nhuy.sendobjectlistobject2part4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MY_ACTION = "com.nhuy.ACTION";
    private static final String MY_USER = "com.nhuy.USER";
    private TextView tvReceived;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(MY_ACTION.equals(intent.getAction())){
                String strJon = intent.getStringExtra(MY_USER);
                List<User> list = getListUser(strJon);
                String listUsername = "";
                for(int i =0; i < list.size(); i++){
                    listUsername = listUsername + list.get(i).getName() + "\n";
                }

                tvReceived.setText(listUsername);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvReceived = findViewById(R.id.tv_received);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    private List<User> getListUser(String strJson){
        List<User> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            JSONObject jsonObject;
            User user;
            Gson gson = new Gson();
            for(int i = 0; i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);
                user = gson.fromJson(jsonObject.toString(), User.class);
                list.add(user);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return  list;
    }

}