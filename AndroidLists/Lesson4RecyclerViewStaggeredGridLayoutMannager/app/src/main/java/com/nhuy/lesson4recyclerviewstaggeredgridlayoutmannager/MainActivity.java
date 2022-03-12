package com.nhuy.lesson4recyclerviewstaggeredgridlayoutmannager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //khai báo RecyclerView và UserAdapter
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ view
        rcvUser = findViewById(R.id.rcv_user);
        //khởi tạo adapter
        userAdapter = new UserAdapter();

        //khởi tạo StaggeredGridLayoutManager là kiểu xuất hiện các ảnh so le trong bài học này
        // StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); có hai tahm số: 2: là số cột còn lại là hướng
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvUser.setLayoutManager(staggeredGridLayoutManager);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
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

        return list;
    }
}