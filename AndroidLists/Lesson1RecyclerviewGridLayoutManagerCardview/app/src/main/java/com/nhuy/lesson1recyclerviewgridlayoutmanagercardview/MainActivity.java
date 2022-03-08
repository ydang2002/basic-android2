package com.nhuy.lesson1recyclerviewgridlayoutmanagercardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView revUser;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revUser = findViewById(R.id.rev_user);
        mUserAdapter = new UserAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        revUser.setLayoutManager(gridLayoutManager);

        mUserAdapter.setData(getListUser());
        revUser.setAdapter(mUserAdapter);
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