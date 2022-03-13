package com.nhuy.lesson7dragdropitemrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Khai báo Recycler
    private RecyclerView rcvItem;
    //Khai báo ItemAdapter
    private ItemAdapter itemAdapter;
    //Khai báo list
    private List<String> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thực hiện ánh xạ view
        rcvItem = findViewById(R.id.rcv_item);
        //Khởi tạo item Adapter
        itemAdapter = new ItemAdapter();

        //Xác định linearLayoutmanager cho project activity mà muốn thực hiện
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //setLayoutmanager và truyền linearLayoutManager vào
        rcvItem.setLayoutManager(linearLayoutManager);

        getDataItem();
        //setData cho Adapter và truyền mListData vào
        itemAdapter.setData(mListData);
        rcvItem.setAdapter(itemAdapter);

        //dùng làm đường kẽ cho các item
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(divider);

        //drag một item
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
                int positionDragged = dragged.getAdapterPosition();
                int positionTaget = target.getAdapterPosition();

                Collections.swap(mListData,positionDragged,positionTaget);
                itemAdapter.notifyItemMoved(positionDragged, positionTaget);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper.attachToRecyclerView(rcvItem);
    }

    private  void getDataItem() {
        //Khai báo mListData
        mListData = new ArrayList<>();
        //set cho listData 20 item
        for (int i = 1; i <= 20; i++){
            mListData.add("Item " + i);
        }
    }

}