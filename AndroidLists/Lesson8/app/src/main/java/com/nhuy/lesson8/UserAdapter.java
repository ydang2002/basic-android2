package com.nhuy.lesson8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class UserAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<String> mListUser;
    public void setData(List<String> list) {
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder  headerViewHolder;
        if (convertView == null){
            headerViewHolder = new HeaderViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header,parent,false);
            headerViewHolder.tvHeader = convertView.findViewById(R.id.tv_header);
            convertView.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        }

        headerViewHolder.tvHeader.setText(mListUser.get(position).substring(0,1));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return mListUser.get(position).subSequence(0,1).charAt(0);
    }

    @Override
    public int getCount() {
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return mListUser.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewHolder itemViewHolder;
        if (view == null){
            itemViewHolder = new ItemViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item,viewGroup,false);
            itemViewHolder.tvItem = view.findViewById(R.id.tv_item);
            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) view.getTag();
        }

        itemViewHolder.tvItem.setText(mListUser.get(i));

        return view;
    }

    public class HeaderViewHolder {
        private TextView tvHeader;
    }

    public class ItemViewHolder {
        private TextView tvItem;

    }
}
