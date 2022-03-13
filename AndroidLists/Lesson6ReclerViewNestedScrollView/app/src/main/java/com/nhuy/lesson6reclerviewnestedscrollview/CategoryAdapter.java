package com.nhuy.lesson6reclerviewnestedscrollview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    //khai báo list
    private List<Category> mListCatagory;
    //settData
    public void setData (List<Category> list){
        this.mListCatagory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tạo view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCatagory.get(position);
        if(category == null){
            return;
        }
        holder.imgCategory.setImageResource(category.getResourceId());
        holder.tvTitle.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mListCatagory != null){
            return mListCatagory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        //khai báo các view trong item_category
        private ImageView imgCategory;
        private TextView tvTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            //ánh xạ view
            imgCategory = itemView.findViewById(R.id.img_category);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
