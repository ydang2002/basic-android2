package com.nhuy.realtimedatabasepart13;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText edtID, edtName;
    private Button btnAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int id = Integer.parseInt(edtID.getText().toString().trim());
//                String name = edtName.getText().toString().trim();
//                User user = new User(id, name);
//                onClickAddUser(user);
                clickAddAllUser();
            }
        });
    }

    private void initUi() {
        edtID = findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_name);
        btnAddUser = findViewById(R.id.btn_add_user);
    }

    private void onClickAddUser(User user) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_users");

        String pathObject = String.valueOf(user.getId());
        myRef.child(pathObject).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(MainActivity.this, "Add user success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clickAddAllUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_users");

        List<User> list = new ArrayList<>();
        list.add(new User(1, "User1"));
        list.add(new User(2, "User2"));
        list.add(new User(3, "User3"));

        myRef.setValue(list, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(MainActivity.this, "Add all user success", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private void onClickDeleteData() {
//        new AlertDialog.Builder(this)
//                .setTitle(getString(R.string.app_name))
//                .setMessage("Bạn có chắc chắn xóa không?")
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        FirebaseDatabase database = FirebaseDatabase.getInstance();
//                        DatabaseReference myRef = database.getReference("my_map");
//
//                        myRef.removeValue(new DatabaseReference.CompletionListener() {
//                            @Override
//                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                                Toast.makeText(MainActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                })
//                .setNegativeButton("Cancel", null)
//                .show();
//    }
}