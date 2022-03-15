package com.nhuy.lesson8stickylistheadersview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class UserAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    //Khai báo List dữ liệu
    private List<String> mListUser;

    public void setData(List<String> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        //Khai báo
        HeaderViewHolder headerViewHolder;
        if (convertView == null){
            //Khởi tạo
            headerViewHolder = new HeaderViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header,parent,false);
            headerViewHolder.tvHeader = convertView.findViewById(R.id.tv_header);
        } else {
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        }
        //Lấy kí tự đàu tiên làm header
        headerViewHolder.tvHeader.setText(mListUser.get(position).substring(0,1));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return mListUser.get(position).subSequence(0,1).charAt(0);
    }

    //return kích thước của mảng dữ liệu
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
        //Khai báo
        ItemViewHolder itemViewHolder;
        if(view == null){
            //Khởi tạo
            itemViewHolder = new ItemViewHolder();
            //Khai báo
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item,viewGroup,false);
            //ánh xạ view
            itemViewHolder.tvItem = view.findViewById(R.id.tv_item);
            view.setTag(itemViewHolder);
        } else {
            //ép kiểu
            itemViewHolder = (ItemViewHolder)  view.getTag();
        }

        itemViewHolder.tvItem.setText(mListUser.get(i));
        return view;
    }

    //Tạo hai cái ViewHolder
    public class HeaderViewHolder{
        //Khai báo textView hiển thị lên cái hearder
        private TextView tvHeader;
    }

    public class ItemViewHolder {
        private TextView tvItem;
    }
}
