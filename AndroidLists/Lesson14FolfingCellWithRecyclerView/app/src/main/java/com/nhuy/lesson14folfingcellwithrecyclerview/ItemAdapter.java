package com.nhuy.lesson14folfingcellwithrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

//b3: sau khi thực hiện ánh xạ view dùng viewHoder
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    //b4: khai báo danh sách list các item
    private List<ItemObject> mListItems;
    //b5: VIẾT HÀM SET DATA
    public void setData(List<ItemObject> list){
        this.mListItems = list;
        notifyDataSetChanged();
    }

    //b6: xử lí 3 hàm bên dưới
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final ItemObject itemObject = mListItems.get(position);
        if (itemObject == null){
            return;
        }
        holder.tvTitle.setText(itemObject.getTitle());
        holder.tvContent.setText(itemObject.getContent());
        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.foldingCell.toggle(false);
            }
        });

        //Bắt sự kiện title khi click vào
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thông báo cho người dùng
                Toast.makeText(view.getContext(),itemObject.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        //Bắt sự kiện content khi click vào
        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thông báo cho người dùng
                Toast.makeText(view.getContext(),itemObject.getContent(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListItems != null){
            return mListItems.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        //khai báo thành phần trong layout_item
        private FoldingCell foldingCell;
        private TextView tvTitle;
        private TextView tvContent;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //sau khi khai báo các thành phần trong layout_item, thực hiện ánh xạ view
            foldingCell = itemView.findViewById(R.id.folding_cell);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

}
