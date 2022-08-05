package com.nhuy.sendotpfirebasepart5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VerifyPhoneNumberActivity extends AppCompatActivity {

    private EditText edtPhoneNumber;
    private Button btnVerifyPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);

        setTileToolbar();
        initUi();
        btnVerifyPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPhoneNumber = edtPhoneNumber.getText().toString().trim();
                onClickVerifyPhoneNumber(strPhoneNumber);
            }
        });
    }

    private void onClickVerifyPhoneNumber(String strPhoneNumber) {

    }

    private void setTileToolbar(){
        if(getSupportActionBar() != null) {
            getActionBar().setTitle("Verify Phone Number");
        }
    }

    private void initUi(){
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        btnVerifyPhoneNumber = findViewById(R.id.btn_verify_phone_number);
    }
}