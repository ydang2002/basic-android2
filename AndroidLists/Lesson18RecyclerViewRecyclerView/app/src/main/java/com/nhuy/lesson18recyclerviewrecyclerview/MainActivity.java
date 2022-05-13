package com.nhuy.lesson18recyclerviewrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.nhuy.lesson18recyclerviewrecyclerview.adapter.ListDataAdapter;
import com.nhuy.lesson18recyclerviewrecyclerview.model.Category;
import com.nhuy.lesson18recyclerviewrecyclerview.model.ListData;
import com.nhuy.lesson18recyclerviewrecyclerview.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvData = findViewById(R.id.rcv_data);
        listDataAdapter = new ListDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        listDataAdapter.setData(this, getListData());
        rcvData.setAdapter(listDataAdapter);
    }

    private List<ListData> getListData() {
        List<ListData> listData = new ArrayList<>();

        List<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category(R.drawable.img_avatar_2));
        listCategory.add(new Category(R.drawable.img_avatar_3));
        listCategory.add(new Category(R.drawable.img_avatar_2));
        listCategory.add(new Category(R.drawable.img_avatar_3));
        listCategory.add(new Category(R.drawable.img_avatar_2));
        listCategory.add(new Category(R.drawable.img_avatar_3));

        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Username 1"));
        listUser.add(new User("Username 2"));
        listUser.add(new User("Username 3"));
        listUser.add(new User("Username 4"));

        listData.add(new ListData(ListDataAdapter.TYPE_CATEGORY, listCategory, null));
        listData.add(new ListData(ListDataAdapter.TYPE_USER, null, listUser));
        listData.add(new ListData(ListDataAdapter.TYPE_CATEGORY, listCategory, null));
        listData.add(new ListData(ListDataAdapter.TYPE_USER, null, listUser));
        listData.add(new ListData(ListDataAdapter.TYPE_CATEGORY, listCategory, null));
        listData.add(new ListData(ListDataAdapter.TYPE_USER, null, listUser));
        return listData;
    }
}