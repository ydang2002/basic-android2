package com.nhuy.lesson4recyclerviewmultipleviewtype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //khai báo
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thực hiện ánh xạ View
        rcvUser = findViewById(R.id.rcv_user);
        //khởi tạo userAdapter
        userAdapter = new UserAdapter();

        // xác định cái định dạng LayOutmanager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //set layoutManager chob rcvUser
        rcvUser.setLayoutManager(linearLayoutManager);

        //setData
        userAdapter.setData(getListUser());
        //setAdapter
        rcvUser.setAdapter(userAdapter);
    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.img_avatar_1,"User 1", true));
        list.add(new User(R.drawable.img_avatar_2,"User 2", true));
        list.add(new User(R.drawable.img_avatar_3,"User 3", true));
        list.add(new User(R.drawable.img_avatar_4,"User 4", true));

        list.add(new User(R.drawable.img_avatar_1,"User 1", false));
        list.add(new User(R.drawable.img_avatar_2,"User 2", false));
        list.add(new User(R.drawable.img_avatar_3,"User 3", false));
        list.add(new User(R.drawable.img_avatar_4,"User 4", false));
        return list;
    }
}