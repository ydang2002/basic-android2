package com.nhuy.lesson13expandablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    // Khai báo 1 list group gồm giày mũ quần áo
    private List<GroupObject> mListGroup;
    // Khai báo kiểu map và list<Itemobject
    private Map<GroupObject, List<ItemObject>> mListItem;// mỗi thằng group tương ứng với một list các item: mũ son, mũ lưỡi trai

    //Sau khi khai báo xong tạo constructor
    public ExpandableListViewAdapter(List<GroupObject> mListGroup, Map<GroupObject, List<ItemObject>> mListItem) {
        this.mListGroup = mListGroup;
        this.mListItem = mListItem;
    }

    @Override
    public int getGroupCount() {
        if (mListGroup != null){
            return  mListGroup.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (mListGroup != null && mListItem != null){
            return  mListItem.get(mListGroup.get(groupPosition)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListItem.get(mListGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        GroupObject groupObject = mListGroup.get(groupPosition);
        return groupObject.getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
    ItemObject itemObject = mListItem.get(mListGroup.get(groupPosition)).get(childPosition);
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group,parent,false);
            //Khai báo các thành view trong layout_item_group
            TextView tvGroup = convertView.findViewById(R.id.tv_group);
            GroupObject groupObject = mListGroup.get(groupPosition);
            tvGroup.setText(groupObject.getName().toUpperCase());//toUpperCase()); viết chữ in hoa cho Group
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
            //Khai báo các thành view trong layout_item_group
            TextView tvItem = convertView.findViewById(R.id.tv_item);
            ItemObject itemObject = mListItem.get(mListGroup.get(groupPosition)).get(childPosition);
            tvItem.setText(itemObject.getName());
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
