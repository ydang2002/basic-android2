package com.nhuy.lesson19recyclerviewchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    //Khai báo dữ liệu
    private List<Message> mlistMessage;

    public void setData(List<Message> list) {
        this.mlistMessage = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_message,parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mlistMessage.get(position);
        if(message == null){
            return;
        }

        holder.tvMessage.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        if (mlistMessage != null){
            return mlistMessage.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        //Khai báo view
        private TextView tvMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            //Thực hiện ánh xạ view
            tvMessage = itemView.findViewById(R.id.tvmessage);
        }
    }
}
