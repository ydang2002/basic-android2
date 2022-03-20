package com.nhuy.lesson10recyclerviewstickyheader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

public class AnimalAdapter extends  RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>
        implements StickyRecyclerHeadersAdapter<AnimalAdapter.HeaderViewHolder> {

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {

    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder{

        private TextView tvHeader;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_header);
        }
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder{

        private TextView tvAnimal;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAnimal = itemView.findViewById(R.id.tv_animal);
        }
    }
}
