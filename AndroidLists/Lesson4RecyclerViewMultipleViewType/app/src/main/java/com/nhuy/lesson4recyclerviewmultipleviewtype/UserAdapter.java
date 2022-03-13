package com.nhuy.lesson4recyclerviewmultipleviewtype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_USER_FEATURED = 1;
    private static int TYPE_USER_NORMAL = 2;

    //Kbáo thuộc tính list
    private List<User> mListUser;

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(TYPE_USER_FEATURED == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_featured,parent,false);
            return new UserFeaturedViewHolder(view);
        } else if(TYPE_USER_NORMAL == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_nomal,parent,false);
            return new UserFeaturedViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = mListUser.get(position);
        if(user == null){
            return;
        }

        if(TYPE_USER_FEATURED == holder.getItemViewType()) {
            // Khai báo UserFeaturedViewHolder
            //ép kiệu UserFeaturedViewHolder cho holder
            UserFeaturedViewHolder userFeaturedViewHolder = (UserFeaturedViewHolder) holder;
            //setData
            userFeaturedViewHolder.imgUserFeatured.setImageResource(user.getResourcedId());
            userFeaturedViewHolder.tvUserNameFeatured.setText(user.getName());
        } else if(TYPE_USER_NORMAL == holder.getItemViewType()) {
            UserNormalViewHolder userNormalViewHolder = (UserNormalViewHolder) holder;
            userNormalViewHolder.imgUserNormal.setImageResource(user.getResourcedId());
            userNormalViewHolder.tvUserNameNormal.setText(user.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        User user = mListUser.get(position);
        if (user.isFeatured()){
            return TYPE_USER_FEATURED;
        } else{
            return TYPE_USER_NORMAL;
        }
    }

    //tạo ra hai cái viewHolder

    //tạo cái class UserFeaturedViewHolder trước
    public class UserFeaturedViewHolder extends RecyclerView.ViewHolder{

        //khai báo các view có trong item_user_featured
        private ImageView imgUserFeatured;
        private TextView tvUserNameFeatured;

        public UserFeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //thực hiện ánh xạ view
            imgUserFeatured = itemView.findViewById(R.id.img_user_featured);
            tvUserNameFeatured = itemView.findViewById(R.id.tv_name_featured);
        }
    }

    // tạo class thứ 2 là UserNormalViewHolder
    public class UserNormalViewHolder extends RecyclerView.ViewHolder{

        //khai báo các view có trong item_user_normal
        private ImageView imgUserNormal;
        private TextView tvUserNameNormal;

        public UserNormalViewHolder(@NonNull View itemView) {
            super(itemView);

            //Thực hiện ánh xạ view
            imgUserNormal = itemView.findViewById(R.id.img_user_nomal);
            tvUserNameNormal = itemView.findViewById(R.id.tv_user_name_nomal);
        }
    }

}
