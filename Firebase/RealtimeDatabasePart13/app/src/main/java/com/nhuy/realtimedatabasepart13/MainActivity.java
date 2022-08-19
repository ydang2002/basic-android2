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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPushData = findViewById(R.id.btn_push_data);
        tvData = findViewById(R.id.tv_get_data);
        Button btnGetData = findViewById(R.id.btn_get_data);
        Button btnDelete = findViewById(R.id.btn_delete_data);
        Button btnUpdate = findViewById(R.id.btn_update_data);

        btnPushData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickPushData();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGetData();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDeleteData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickUpdateData();
            }
        });
    }

    private void onClickPushData() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("my_map");

        Map<String, Boolean> map = new HashMap<>();
        map.put("1", true);
        map.put("2", false);
        map.put("3", true);
        map.put("4", false);

        myRef.setValue(map, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(MainActivity.this, "Push data success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClickGetData() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("my_map");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               Map<String, Boolean> mapResult = new HashMap<>();
               for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                   String key = dataSnapshot1.getKey();
                   Boolean value = dataSnapshot1.getValue(Boolean.class);

                   mapResult.put(key, value);
               }
                tvData.setText(mapResult.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    private void onClickUpdateData() {

        // Cách 1
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("my_map");
//
//        Map<String, Boolean> mapUpdate = new HashMap<>();
//        mapUpdate.put("1", true);
//        mapUpdate.put("2", false);
//        mapUpdate.put("3", true);
//        mapUpdate.put("4", false);
//
//        myRef.setValue(mapUpdate, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                Toast.makeText(MainActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
//            }
//        });


//        // Cách 3
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("my_map");
//        Map<String, Object> mapUpdate = new HashMap<>();
//        mapUpdate.put("2", "true");
//        mapUpdate.put("4", "true");
//
//        myRef.updateChildren(mapUpdate, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                Toast.makeText(MainActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void onClickDeleteData() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage("Bạn có chắc chắn xóa không?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("user_info");

                        // Cách 1
//                        myRef.removeValue(new DatabaseReference.CompletionListener() {
//                            @Override
//                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                                Toast.makeText(MainActivity.this, "Delete data success", Toast.LENGTH_SHORT).show();
//                            }
//                        });

                        // Cách 2
//                        myRef.child("job").child("name").removeValue(new DatabaseReference.CompletionListener() {
//                            @Override
//                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                                Toast.makeText(MainActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
//                            }
//                        });

                        // Xóa Object user_info
                        myRef.removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Toast.makeText(MainActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}