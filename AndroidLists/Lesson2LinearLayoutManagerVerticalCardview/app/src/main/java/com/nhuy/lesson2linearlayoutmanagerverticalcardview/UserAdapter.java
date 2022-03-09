package com.nhuy.lesson2linearlayoutmanagerverticalcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHodler>{

    private Context mContext;
    private List<User> mListUser;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHodler holder, int position) {
        User user = mListUser.get(position);
        if(user == null) {
            return;
        }

        holder.imgUser.setImageResource(user.getResourceId());
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHodler extends RecyclerView.ViewHolder{

        private ImageView imgUser;
        private TextView tvName;

        public UserViewHodler(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
