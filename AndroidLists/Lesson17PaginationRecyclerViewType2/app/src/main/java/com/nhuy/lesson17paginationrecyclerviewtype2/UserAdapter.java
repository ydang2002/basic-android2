package com.nhuy.lesson17paginationrecyclerviewtype2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//b5 extends
public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //B7 khai báo
    private static final int TYPE_ITEM = 1;
    private static final  int TYPE_LOADING = 2;

    //b8 khai báo list
    private List<User> mListUser;
    //b10 khai báo để kiểm tra itemLoading đã add vào chưa
    private boolean isLoadingAdd;

    //viết hàm setdata
    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    //b6 Override method getItemViewType
    @Override
    public int getItemViewType(int position) {
        //b11 xử lí
        if(mListUser != null && position == mListUser.size() - 1 && isLoadingAdd){
            return TYPE_LOADING;
        }
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //b12
        if(TYPE_ITEM == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent,false);
            return  new UserViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent,false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //b13
        if(holder.getItemViewType() == TYPE_ITEM){
            User user = mListUser.get(position);
            //ép kiểu
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.tvName.setText(user.getName() + " " + (position + 1));
        }
    }

    @Override
    public int getItemCount() {
        //b9
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        //b1 khai báo
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            //b2 Thực hiện ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder{

        //b3 khai báo
        private ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            //b4 Thực hiện ánh xạ view
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
    //B14 viết hàm loading add item vào list dữ liệu
    public void addFooterLoading(){
        isLoadingAdd = true;
        mListUser.add(new User(""));
    }

    //b15 hàm xóa loading khi phân trang xong
    public void removeFooterLoading(){
        isLoadingAdd = false;

        int position = mListUser.size() -1;
        User user = mListUser.get(position);
        if(user != null){
            mListUser.remove(position);
            notifyItemRemoved(position);
        }
    }
}
