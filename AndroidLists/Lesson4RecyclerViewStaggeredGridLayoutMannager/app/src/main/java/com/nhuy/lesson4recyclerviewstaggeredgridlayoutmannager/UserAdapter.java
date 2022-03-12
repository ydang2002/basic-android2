package com.nhuy.lesson4recyclerviewstaggeredgridlayoutmannager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//sau khi thực hiện khai báo xong các view và thực hiện ánh xạ view ta extends RecyclerView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //khai báo danh sách list kiểu user
    private List<User> mListUser;
    //viết một hàm setData cho Adapter
    public void setData(List<User> list){
        //ta gán mListUser cho tham số list truyền vào
        this.mListUser = list;
        //loat dữ liệu chi thằng Adaptetr
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tạo view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if(user == null){
            return;
        }
        //xet dữ liệu
        holder.imageUser.setImageResource(user.getResourId());
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        //xét nếu như kích thước danh sách list khác null
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        // khai báo các view có trong item_user
        private ImageView imageUser;
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            //Thực hiện ánh xạ View
            imageUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
