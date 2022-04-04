package com.nhuy.lesson16paginationrecyclerviewtutorial;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    //b1 khai báo layoutmanager
    private LinearLayoutManager linearLayoutManager;

    public PaginationScrollListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        //b5 khai báo biến xử lí phân trang
        int visibleItemCount = linearLayoutManager.getItemCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

        //b6 nếu như đamg load hoặc trang cuối thì không phân trang
        if (isLoading() || isLastPage()){
            return;
        }

        //b7
        if(firstVisibleItemPosition >= 0 && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount){
            //gọi hàm phân trang
            loadMoreItem();
        }
    }
    //b2 methot gọi load dữ liệu trang tiếp theo
    public abstract void loadMoreItem();
    //b3 kiểm tra có đang load dữ liệu hay không
    public abstract  boolean isLoading();
    //b4 kiểm tra khi nào là trang cuối cùng
    public abstract  boolean isLastPage();
}
