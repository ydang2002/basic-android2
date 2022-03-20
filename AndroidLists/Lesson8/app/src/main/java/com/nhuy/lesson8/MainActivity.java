package com.nhuy.lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    private StickyListHeadersListView listUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        list.add("ABCDEFGH");
        list.add("ABCDFEGHI");
        list.add("ABCDEFGHIL");

        list.add("B");
        list.add("BB");
        list.add("BBC");
        list.add("BBCD");
        list.add("BBCDE");
        list.add("BBCDEF");
        list.add("BBCDEFG");
        list.add("BBCDEFGH");
        list.add("BBCDFEGHI");
        list.add("BBCDEFGHIL");

        list.add("C");
        list.add("CB");
        list.add("CBC");
        list.add("CBCD");
        list.add("CBCDE");
        list.add("CBCDEF");
        list.add("CBCDEFG");
        list.add("CBCDEFGH");
        list.add("CBCDFEGHI");
        list.add("CBCDEFGHIL");
        return list;
    }
}