package com.nhuy.lesson14folfingcellwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //b1: khai báo
    private RecyclerView rcvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b2: Thực hiện ánh xạ view
        rcvItems = findViewById(R.id.rcv_item);

        //b3: Xác định LinnearlayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItems.setLayoutManager(linearLayoutManager);

        //b4: khởi tạo itemAdapter
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setData(getListItems());
        rcvItems.setAdapter(itemAdapter);
    }

    //b5 Viết hàm getData
    private List<ItemObject> getListItems(){
        List<ItemObject> list = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list.add(new ItemObject("Title item" + i, "Content item" +i));
        }
        return list;
    }
}