package com.nhuy.lesson26roomdatabasesqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhuy.lesson26roomdatabasesqlite.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int My_REQUEST_CODE = 10;
    private EditText editUsername;
    private EditText editAddress;
    private Button btnAddUser;
    private RecyclerView rcvUser;

    private UserAdapter userAdapter;
    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        userAdapter = new UserAdapter(new UserAdapter.IClickItemUser() {
            @Override
            public void updateUser(User user) {
                ClickUpdateUser(user);
            }
        });
        mListUser = new ArrayList<>();
        userAdapter.setData(mListUser);

        //Thiết kế recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        rcvUser.setAdapter(userAdapter);

        //bắt sự kiện button
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adduser();
            }
        });

        //Gọi hàm load data
        loadData();
    }

    //hàm thực hiện ánh xạ view
    private void initUI(){
        editUsername = findViewById(R.id.edit_username);
        editAddress = findViewById(R.id.edit_address);
        btnAddUser = findViewById(R.id.btn_add_user);
        rcvUser = findViewById(R.id.rcv_user);
    }

    //Hàm thêm user
    private void adduser() {
        //trim xóa kí tự trắng đầu và cuối
        String strUsername = editUsername.getText().toString().trim();
        String strAddress = editAddress.getText().toString().trim();
        //kiểm tra 1 trong hai user hoặc dress trống thì không add vào database
        if(TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strAddress)){
            return;
        }

        User user = new User(strUsername, strAddress);

        //gọi hàm checkUser
        if(isUserExit(user)){
            Toast.makeText(this, "User exit", Toast.LENGTH_SHORT).show();
            return;
        }

        //add user vào database
        UserDatabase.getInstance(this).userDAO().insertUser(user);
        //Thông báo add user thành công
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show();
        //reset 2 text view
        editUsername.setText("");
        editAddress.setText("");
        //gọi hàm ẩn bàn phím
        hideSoftKeyboard();

        //gọi hàm loadData
        loadData();
    }

    //Hàm ẩn bàn phím
    public void hideSoftKeyboard(){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    //hiển thị dữ liệu sau khi add thành công
    private void loadData(){
        mListUser = UserDatabase.getInstance(this).userDAO().getListUser();
        userAdapter.setData(mListUser);
    }

    //Hàm kiểm tra username có tồn tại không
    private boolean isUserExit(User user){
        List<User> list = UserDatabase.getInstance(this).userDAO().checkUser(user.getUsername());
        return list != null && !list.isEmpty();
    }

    //Hàm click update user
    private void ClickUpdateUser(User user){
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        startActivityForResult(intent, My_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == My_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            loadData();
        }
    }
}