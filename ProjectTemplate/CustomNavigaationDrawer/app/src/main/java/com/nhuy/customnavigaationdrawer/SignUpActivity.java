package com.nhuy.customnavigaationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private Button btnSignUp;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        initUi();
        initListener();
    }

    private void initUi() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnSignUp = findViewById(R.id.btn_sign_up);

        progressDialog = new ProgressDialog(this);
    }

    private void initListener() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUp();
            }
        });
    }

    private void onClickSignUp() {
        String strEmail = edtEmail.getText().toString().trim();
        String srtPassword = edtPassword.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        auth.createUserWithEmailAndPassword(strEmail, srtPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                            //sau khi vào MainActivity, thực hiện đóng SignIn và SignUp
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}