package com.nhuy.lesson15swipedeleteitemrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //b1 Khai báo
    private RecyclerView rcvItem;
    private ItemAdapter itemAdapter;
    private List<ItemObject> mListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b2 Thực hiện ánh xạ View
        rcvItem = findViewById(R.id.rcv_item);
        //b3 Xác định layoutManager mà chúng ta sử dụng
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);

        //b4 khởi tạo adapter
        itemAdapter = new ItemAdapter();
        mListItems = getListItem();
        itemAdapter.setData(mListItems);
        rcvItem.setAdapter(itemAdapter);

        //b6 Đường phân cách giữa các item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);

        // b7 xóa item
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mListItems.remove(position);
                itemAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(rcvItem);
    }

    // b5 viết hàm kiểu dữ liệu trả về
    private List<ItemObject> getListItem(){
        List<ItemObject> list = new ArrayList<>();
        for (int i = 0; i< 10; i++){
            list.add(new ItemObject("Item " + i));
        }
        return list;
    }
}