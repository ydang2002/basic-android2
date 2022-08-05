package com.nhuy.sendotpfirebasepart5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterOTPActivity extends AppCompatActivity {

    private EditText edtOtp;
    private Button btnSendOtpCode;
    private TextView tvSendOtpAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otpactivity);

        setTileToolbar();
        initUi();
        btnSendOtpCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOtp = edtOtp.getText().toString().trim();
                onClickOtpCode(strOtp);
            }
        });

        tvSendOtpAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendOtpAgain();
            }
        });
    }

    private void setTileToolbar(){
        if(getSupportActionBar() != null) {
            getActionBar().setTitle("Enter OTP Code");
        }
    }

    private void initUi(){
        edtOtp = findViewById(R.id.edt_otp);
        btnSendOtpCode = findViewById(R.id.btn_send_otp_code);
        tvSendOtpAgain = findViewById(R.id.tv_send_otp_again);
    }

    private void onClickOtpCode(String strOtp) {
    }

    private void onClickSendOtpAgain() {
    }
}