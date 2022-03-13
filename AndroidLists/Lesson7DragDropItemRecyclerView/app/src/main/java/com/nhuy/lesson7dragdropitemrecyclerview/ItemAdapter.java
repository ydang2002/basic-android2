package com.nhuy.lesson7dragdropitemrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Kế thừa RecyclerView và truyền IteamViewHolder vào
//Và implement methods
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHodler> {

    //Khai báo danh sách list
    private List<String> mListItem;

    //Viết hàm setData cho Adapter, truyền vào tham số list các String
    public void setData(List<String> list) {
        //Gán mListItem bằng tham số truyền vào là list
        this.mListItem = list;
        //dùng để update lại data
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Khai báo view với ba tham số
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new ItemViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHodler holder, int position) {

        //Khai báo String và truyền position
        String stringItem = mListItem.get(position);
        holder.tvItem.setText(stringItem);
    }

    @Override
    public int getItemCount() {
        if(mListItem != null){
            return mListItem.size();
        }
        return 0;
    }

    public class ItemViewHodler extends RecyclerView.ViewHolder {

        //khai báo text view
        private TextView tvItem;

        public ItemViewHodler(@NonNull View itemView) {
            super(itemView);

            //thực hiện ánh xạ view thông qua phương thức findViewById
            tvItem = itemView.findViewById(R.id.tv_item);

        }
    }
}
