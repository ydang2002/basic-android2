package com.nhuy.lesson17paginationrecyclerviewtype2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    //b2 Khai báo
    private UserAdapter userAdapter;
    private List<User> mListUser;

    //b5 khai báo
    private boolean isLoading;
    private boolean isLastPage;
    private int totalPage = 5; //khởi tạo 5 trang
    private int currentPage = 1;//xem page là bao nhieu



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

        setFirstData();
        //b9
        rcvUser.addOnScrollListener((new PaginationScrollListener(linearLayoutManager) {
            //b10 xử lí phân trnang
            @Override
            public void loadMoreItem() {
                isLoading = true;

                currentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLoadPage() {
                return isLastPage;
            }
        }));

    }

    //b6 Load data page 1
    private void setFirstData(){
        mListUser = getListUser();
        userAdapter.setData(mListUser);

        //b8 nếu chưa đến trang cuối cùng
        if(currentPage < totalPage){
            userAdapter.addFooterLoading();
        } else{
            isLastPage =true;
        }
    }

    //b11 viết hàm
    private void loadNextPage(){
        //b12 khoảng thời gian load trang
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //gọi hàmlấy 10 item
                List<User> list = getListUser();

                userAdapter.removeFooterLoading();
                mListUser.addAll(list);
                userAdapter.notifyDataSetChanged();

                //khi load xong
                isLoading = false;
                if(currentPage < totalPage){
                    userAdapter.addFooterLoading();
                } else{
                    isLastPage =true;
                }
            }
        }, 2000);

    }

    //b7 hàm get dữ liệu
    private  List<User> getListUser(){
        //b13 Hiển thị thông báo cho người dùng biết đang load trang nào
        Toast.makeText(this,"Load data page " + currentPage,Toast.LENGTH_SHORT).show();
        List<User> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            list.add(new User("User name "));
        }
        return list;
    }
}