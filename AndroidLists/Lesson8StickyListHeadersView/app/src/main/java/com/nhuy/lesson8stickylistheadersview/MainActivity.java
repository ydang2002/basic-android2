package com.nhuy.lesson8stickylistheadersview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    //Khai báo
    private StickyListHeadersListView listUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thực hiện ánh xạ View
        listUser = findViewById(R.id.list_user);
        //khởi tạo
        userAdapter = new UserAdapter();

        userAdapter.setData(getListUser());
        listUser.setAdapter(userAdapter);
    }

    private List<String> getListUser(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("AB");
        list.add("ABC");
        list.add("ABCD");
        list.add("ABCDE");
        list.add("ABCDEF");
        list.add("ABCDEFG");
        list.add("B");
        list.add("BB");
        list.add("BBC");
        list.add("BBCD");
        list.add("BBCDE");
        list.add("BBCDEF");
        list.add("BBCDEFG");
        list.add("C");
        list.add("CB");
        list.add("CBC");
        list.add("CBCD");
        list.add("CBCDE");
        list.add("CBCDEF");
        list.add("CBCDEFG");
        return list;
    }
}