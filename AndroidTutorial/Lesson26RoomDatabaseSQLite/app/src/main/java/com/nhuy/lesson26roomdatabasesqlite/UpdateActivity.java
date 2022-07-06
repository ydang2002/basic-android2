package com.nhuy.lesson26roomdatabasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhuy.lesson26roomdatabasesqlite.database.UserDatabase;

public class UpdateActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editAddress;
    private Button btnUpdateUser;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editUsername = findViewById(R.id.edit_username);
        editAddress = findViewById(R.id.edit_address);
        btnUpdateUser = findViewById(R.id.btn_update_user);

        mUser = (User) getIntent().getExtras().get("object_user");
        if(mUser != null){
            editUsername.setText(mUser.getUsername());
            editAddress.setText(mUser.getAddress());
        }

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser();
            }
        });
    }

    private void updateUser() {
        //trim xóa kí tự trắng đầu và cuối
        String strUsername = editUsername.getText().toString().trim();
        String strAddress = editAddress.getText().toString().trim();
        //kiểm tra 1 trong hai user hoặc dress trống thì không add vào database
        if(TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strAddress)){
            return;
        }
        //update user trong database
        mUser.setUsername(strUsername);
        mUser.setAddress(strAddress);

        UserDatabase.getInstance(this).userDAO().updateUser(mUser);
        Toast.makeText(this,"Update user successfully", Toast.LENGTH_SHORT).show();

        Intent intentResult = new Intent();
        setResult(Activity.RESULT_OK, intentResult);
        finish();
    }
}