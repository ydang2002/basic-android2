package com.nhuy.lesson2linearlayoutmanagerverticalcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView revUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revUser = findViewById(R.id.rev_user);
        userAdapter = new UserAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        revUser.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        revUser.setAdapter(userAdapter);
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

        return list;
    }
}