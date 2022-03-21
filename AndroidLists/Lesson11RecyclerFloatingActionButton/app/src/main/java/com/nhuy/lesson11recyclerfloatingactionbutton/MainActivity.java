package com.nhuy.lesson11recyclerfloatingactionbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private FloatingActionButton btnFloating;
    private  UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        btnFloating = findViewById(R.id.btn_floating);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);

        //xử lí button floating ẩn hoặc hiện
        rcvUser.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0){
                    //ẩn btn
                    btnFloating.hide();
                } else  {
                    btnFloating.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.img_avatar_1,"User name 1"));
        list.add(new User(R.drawable.img_avatar_2,"User name 2"));
        list.add(new User(R.drawable.img_avatar_3,"User name 3"));
        list.add(new User(R.drawable.img_avatar_4,"User name 4"));

        list.add(new User(R.drawable.img_avatar_1,"User name 1"));
        list.add(new User(R.drawable.img_avatar_2,"User name 2"));
        list.add(new User(R.drawable.img_avatar_3,"User name 3"));
        list.add(new User(R.drawable.img_avatar_4,"User name 4"));

        list.add(new User(R.drawable.img_avatar_1,"User name 1"));
        list.add(new User(R.drawable.img_avatar_2,"User name 2"));
        list.add(new User(R.drawable.img_avatar_3,"User name 3"));
        list.add(new User(R.drawable.img_avatar_4,"User name 4"));

        list.add(new User(R.drawable.img_avatar_1,"User name 1"));
        list.add(new User(R.drawable.img_avatar_2,"User name 2"));
        list.add(new User(R.drawable.img_avatar_3,"User name 3"));
        list.add(new User(R.drawable.img_avatar_4,"User name 4"));

        return list;
    }
}