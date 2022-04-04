package com.nhuy.lesson16paginationrecyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //b1 Khai báo
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    private List<User> mListUser;
    //khai báo progressBar
    private ProgressBar progressBar;
    //b9 khai báo
    private boolean isLoading;
    private boolean isLastPage;
    private int currentPage = 1;// xem page hiện tại là bao nhiêu
    private int totalPage = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b2 Thực hiện ánh xạ view
        rcvUser = findViewById(R.id.rcv_user);
        //b11 thực hiện ánh xạ view ProgressBar
        progressBar = findViewById(R.id.progress_bar);
        //b3 Khởi tạo
        userAdapter = new UserAdapter();
        //b4 Xác định layoutManager dử dụng
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setAdapter(userAdapter);

        //thiết kế đường phân cách giữa các item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);

        //b8 gọi PaginationScroollListtner
        rcvUser.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            //load dữ liệu phân trang
            public void loadMoreItem() {
                isLoading = true;
                //hiển thị đang load dữ liệu page nào
                progressBar.setVisibility(View.VISIBLE);
                //tăng page lên
                currentPage += 1;
                // load dữ liệu page tiếp theo
                loadNextPage();
            }

            @Override
            //kiểm tra có đang load hay không
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            //kiểm tra xem có ở trang cuối cùng chưa
            public boolean isLastPage() {
                return isLastPage;
            }
        });

        //b7 goi hàm
        setFirstData();
    }
    //b5 Load data page 1
    private void setFirstData(){
        mListUser = getListUser();
        userAdapter.setData(mListUser);
    }

    //b10 viết hàm load page tiếp theo
    private void loadNextPage(){
        //cài thời gian 2s là load xong
        Handler handler = new Handler();
        /*handler.postDelayed((new Runnable() {
            @Override
            public void run() {
                //khai báo listUser: là list page tiếp theo
                List<User> list = getListUser();//gọi 10 item tiếp theo
                //add vào list
                mListUser.addAll(list);
                userAdapter.notifyDataSetChanged();

                //sau khi load xong
                isLoading = false;
                //ẩn load dữ liệu page nào
                progressBar.setVisibility(View.GONE);
                if(currentPage == totalPage){
                    isLastPage = true;// không phân trang nữa
                }
            }
        }),2000);//2s*/
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //khai báo listUser: là list page tiếp theo
                List<User> list = getListUser();//gọi 10 item tiếp theo
                //add vào list
                mListUser.addAll(list);
                userAdapter.notifyDataSetChanged();

                //sau khi load xong
                isLoading = false;
                //ẩn load dữ liệu page nào
                progressBar.setVisibility(View.GONE);
                if(currentPage == totalPage){
                    isLastPage = true;// không phân trang nữa
                }
            }
        },2000);
    }

    //b6 hàm get  dữ liệu
    private List<User> getListUser(){
        //hiển thị dòng chữ thông báo đang load page nào
        Toast.makeText(this, "Load data page " + currentPage, Toast.LENGTH_SHORT).show();
        List<User> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            list.add(new User("User name"));
        }
        return list;
    }


}