package com.nhuy.lesson17paginationrecyclerviewtype2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    //b2 Khai báo
    private UserAdapter userAdapter;
    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b1 THực hiện ánh xạ view
        rcvUser = findViewById(R.id.rcv_user);
        //b3 xác định layoutManager sự dụng
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        //b4 Khởi tạo userAdapter
        userAdapter = new UserAdapter();
        rcvUser.setAdapter(userAdapter);
        //b5 sử lí đường phân cách giữa các item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);
    }
}