package com.nhuy.lesson18recyclerviewrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhuy.lesson18recyclerviewrecyclerview.R;
import com.nhuy.lesson18recyclerviewrecyclerview.model.ListData;

import java.util.List;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder> {
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_USER = 2;
    private List<ListData> mListData;
    private Context mContext;
    public void setData(Context context, List<ListData> listData){
        this.mContext = context;
        this.mListData = listData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mListData.get(position).getType();
    }

    @NonNull
    @Override
    public ListDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_data, parent, false);
        return new ListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDataViewHolder holder, int position) {
        ListData listData = mListData.get(position);
        if(TYPE_CATEGORY == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            holder.revItem.setLayoutManager(linearLayoutManager);
            holder.revItem.setFocusable(false);

            CategoryAdapter categoryAdapter = new CategoryAdapter();
            categoryAdapter.setData(listData.getListCategory());

            holder.revItem.setAdapter(categoryAdapter);
        } else if (TYPE_USER == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
            holder.revItem.setLayoutManager(linearLayoutManager);
            holder.revItem.setFocusable(false);

            UserAdapter userAdapter = new UserAdapter();
            userAdapter.setData(listData.getListUser());

            holder.revItem.setAdapter(userAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if(mListData != null){
            return mListData.size();
        }
        return 0;
    }

    public class ListDataViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView revItem;
        public ListDataViewHolder(@NonNull View itemView) {
            super(itemView);
            revItem = itemView.findViewById(R.id.rv_item);
        }
    }
}
