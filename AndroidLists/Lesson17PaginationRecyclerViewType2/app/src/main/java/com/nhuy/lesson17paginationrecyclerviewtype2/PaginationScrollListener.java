package com.nhuy.lesson17paginationrecyclerviewtype2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    //b1 khai báo
    private LinearLayoutManager linearLayoutManager;

    public PaginationScrollListener (LinearLayoutManager linearLayoutManager){
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        //đếm số item
        int visibleItemCount = linearLayoutManager.getChildCount();
        //tổng item trong 1 page
        int totallItemCount = linearLayoutManager.getItemCount();
        //itemđầu tiên
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

        if(isLoading() || isLoadPage()){
            return;
        }

        //b3
        if(firstVisibleItemPosition >= 0 && visibleItemCount + firstVisibleItemPosition >= totallItemCount){
            //khi mà thõa hai dk trên ta gọi phân trang
            loadMoreItem();
        }
    }
    //b2 hàm loat dữ liệu
    public abstract void loadMoreItem();
    //kiểm tra page đang load hay load xong rồi
    public  abstract  boolean isLoading();
    //kiểm tra đền page cuối cùng chưa
    public abstract boolean isLoadPage();
}//22: 08
