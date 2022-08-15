package com.nhuy.customnavigaationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private LinearLayout layoutSignUp;
    private EditText edtEmail, edtPassword;
    private Button btnSignIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private LinearLayout layoutForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initUi();
        initListener();


    }

    private void initUi() {
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        layoutSignUp = findViewById(R.id.layout_sign_up);
        edtEmail = findViewById(R.id.edt_email_sign_in);
        edtPassword = findViewById(R.id.edt_password_sign_in);
        btnSignIn = findViewById(R.id.btn_sign_in);
        layoutForgotPassword = findViewById(R.id.layout_forgot_password);
    }

    private void initListener() {
        layoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onClickSign();
            }
        });

        layoutForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickForgetPassword();
            }
        });
    }

    private void onClickSign() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        auth.signInWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                           Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                           startActivity(intent);
                           finish();
                           finishAffinity();
                        } else {
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onClickForgetPassword() {

    }
}