package com.nhuy.lesson13expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Khai báo
    private ExpandableListView expandableListView;
    private List<GroupObject> mListGroup;
    private Map<GroupObject, List<ItemObject>> mListItem;
    private ExpandableListViewAdapter expandableListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thực hiện ánh xạ view
        expandableListView = findViewById(R.id.expandableListView);

        mListItem = getmListItems();
        mListGroup = new ArrayList<>(mListItem.keySet());
        //Khởi tạo adapter
        expandableListViewAdapter = new ExpandableListViewAdapter(mListGroup, mListItem);
        expandableListView.setAdapter(expandableListViewAdapter);

        // bắt sự kiện khi click vào các Group
        expandableListView.setOnChildClickListener(parent, v, groupPosition, id) -> {

        };

    }

    private  Map<GroupObject, List<ItemObject>> getmListItems(){
        Map<GroupObject, List<ItemObject>> listMap = new HashMap<>();

        GroupObject groupObject1 = new GroupObject(1,"Group 1");
        GroupObject groupObject2 = new GroupObject(2,"Group 2");
        GroupObject groupObject3 = new GroupObject(3,"Group 3");

        List<ItemObject> objects1 = new ArrayList<>();
        objects1.add(new ItemObject(1,"Item 1"));
        objects1.add(new ItemObject(2,"Item 2"));
        objects1.add(new ItemObject(3,"Item 3"));

        List<ItemObject> objects2 = new ArrayList<>();
        objects2.add(new ItemObject(4,"Item 4"));
        objects2.add(new ItemObject(5,"Item 5"));
        objects2.add(new ItemObject(6,"Item 6"));

        List<ItemObject> objects3 = new ArrayList<>();
        objects3.add(new ItemObject(7,"Item 7"));
        objects3.add(new ItemObject(8,"Item 8"));
        objects3.add(new ItemObject(9,"Item 9"));

        listMap.put(groupObject1, objects1);
        listMap.put(groupObject2, objects2);
        listMap.put(groupObject3, objects3);

        return listMap;
    }
}