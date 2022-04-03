package com.nhuy.lesson15swipedeleteitemrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//b4 extends
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    //b5 khai báo list
    private List<ItemObject> mListItems;

    // b6 viết hàm setData
    public void setData(List<ItemObject> list){
        this.mListItems = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemObject itemObject = mListItems.get(position);
        if (itemObject == null) {
            return;
        }
        holder.tvName.setText(itemObject.getName());
    }

    //b7 xét nếu list khác null return size
    @Override
    public int getItemCount() {
        if (mListItems != null){
            return mListItems.size();
        }
        return 0;
    }

    //b1 Khai báo class
    public  class ItemViewHolder extends RecyclerView.ViewHolder{
        //b2 Khai báo view trong layout_item
        private TextView tvName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //b3 Thực hiện ánh xạ view
            tvName  = itemView.findViewById(R.id.tv_name);
        }
    }
}
