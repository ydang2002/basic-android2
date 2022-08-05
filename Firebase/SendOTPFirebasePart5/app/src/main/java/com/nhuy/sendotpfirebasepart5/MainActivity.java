package com.nhuy.sendotpfirebasepart5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTileToolbar();
    }

    private void setTileToolbar(){
        if(getSupportActionBar() != null) {
            getActionBar().setTitle("Main Activity");
        }
    }
}