package com.nhuy.lesson6reclerviewnestedscrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private RecyclerView rcvUser;

    private CategoryAdapter categoryAdapter;
    private UserAdapter  userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ view
        rcvCategory = findViewById(R.id.rcv_category);
        rcvUser = findViewById(R.id.rcv_user);

        //Category
        categoryAdapter = new CategoryAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvCategory.setLayoutManager(gridLayoutManager);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(false);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter((categoryAdapter));

        //User
        userAdapter = new UserAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setFocusable(false);
        rcvUser.setNestedScrollingEnabled(false);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }

    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.img_avatar_1,"Category 1"));
        list.add(new Category(R.drawable.img_avatar_2,"Category 2"));
        list.add(new Category(R.drawable.img_avatar_3,"Category 3"));
        list.add(new Category(R.drawable.img_avatar_4,"Category 4"));

        list.add(new Category(R.drawable.img_avatar_1,"Category 1"));
        list.add(new Category(R.drawable.img_avatar_2,"Category 2"));
        list.add(new Category(R.drawable.img_avatar_3,"Category 3"));
        list.add(new Category(R.drawable.img_avatar_4,"Category 4"));

        return list;
    }

    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.img_avatar_1,"User 1"));
        list.add(new User(R.drawable.img_avatar_2,"User 2"));
        list.add(new User(R.drawable.img_avatar_3,"User 3"));
        list.add(new User(R.drawable.img_avatar_4,"User 4"));

        list.add(new User(R.drawable.img_avatar_1,"User 1"));
        list.add(new User(R.drawable.img_avatar_2,"User 2"));
        list.add(new User(R.drawable.img_avatar_3,"User 3"));
        list.add(new User(R.drawable.img_avatar_4,"User 4"));
        return list;
    }
}