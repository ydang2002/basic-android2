package com.nhuy.lesson16paginationrecyclerviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//b3 extends RecylerView
public class UserAdapter extends RecyclerView.Adapter <UserAdapter.UserViewHolder>{
//b4 Khai báo list dữ liệu
    private List<User> mListUser;
    //b5 viết hàm setData
    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //b7 Tạo đối tượng view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //b8 Khai báo user
        User user = mListUser.get(position);
        if(user != null){
            return;
        }
        holder.tvName.setText(user.getName() +(position + 1));
    }

    //b6
    @Override
    public int getItemCount() {
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        //Khai báo các thành phần trong item
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            //b2 Thực hiện ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
