package com.nhuy.lesson23mvcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private TextView tvMessage;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvMessage = findViewById(R.id.tv_message);
        btnLogin = findViewById(R.id.btn_login);

        //Bắt sự kiện
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi hàm clickLogin
                clickLogin();
            }
        });
    }

    //Hàm bắt sự kiện khi click LOGIN
    private void clickLogin() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        //Khởi tạo user
        User user = new User(strEmail, strPassword);
        //hiện thị text message
        tvMessage.setVisibility(View.VISIBLE);
        //xử lí nếu hợp lệ hoặc không hợp lệ sẽ thông báo
        if(user.isValidEmail() && user.isValidPassword()){
            tvMessage.setText("Login success");
            tvMessage.setTextColor(getResources().getColor(R.color.teal_700));
        } else {
            tvMessage.setText("Email or Password invalid");
            tvMessage.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

        }
    }
}