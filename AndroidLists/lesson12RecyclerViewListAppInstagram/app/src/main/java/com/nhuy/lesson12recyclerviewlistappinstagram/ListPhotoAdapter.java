package com.nhuy.lesson12recyclerviewlistappinstagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListPhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //Khai báo hai loại type
    public static final int TYPE_GRID = 1;
    public static final int TYPE_LAGRE = 2;
    //Khai báo mảng dữ liệu kiểu ListPhoto
    private List<ListPhoto> mListPhoto;

    public void setData(List<ListPhoto> listPhotos){
        this.mListPhoto = listPhotos;
        notifyDataSetChanged();
    }

    //có hai hàm viewHodler nên cần get để biết viewholder nào
    //getItemViewType được thiết kế trong ListPhoto
    @Override
    public int getItemViewType(int position) {

        //Khai báo ListPhoto
        ListPhoto listPhoto = mListPhoto.get(position);
        return listPhoto.getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_GRID == viewType){
            //Khai báo view
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_grid,parent,false);
            return new PhotoGridViewHolder(view);
        } else if(TYPE_LAGRE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_large,parent,false);
            return new PhotoLagreViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListPhoto listPhoto = mListPhoto.get(position);
        if(TYPE_GRID == listPhoto.getType()){
            //Khai báo,ép kiểu viewHOLDER
            PhotoGridViewHolder photoGridViewHolder = (PhotoGridViewHolder) holder;
            //set dữ liệu
            photoGridViewHolder.img1.setImageResource(listPhoto.getPhotos().get(0).getResourceId());
            photoGridViewHolder.img2.setImageResource(listPhoto.getPhotos().get(1).getResourceId());
            photoGridViewHolder.img3.setImageResource(listPhoto.getPhotos().get(2).getResourceId());
        } else if(TYPE_LAGRE == listPhoto.getType()){
            PhotoLagreViewHolder photoLagreViewHolder = (PhotoLagreViewHolder) holder;
            photoLagreViewHolder.img1.setImageResource(listPhoto.getPhotos().get(0).getResourceId());
            photoLagreViewHolder.img2.setImageResource(listPhoto.getPhotos().get(1).getResourceId());
            photoLagreViewHolder.img3.setImageResource(listPhoto.getPhotos().get(2).getResourceId());
        }
    }

    @Override
    public int getItemCount() {
        if (mListPhoto != null){
            return mListPhoto.size();
        }
        return 0;
    }

    //thiết kế class kiểu Grid
    public class PhotoGridViewHolder extends RecyclerView.ViewHolder{

        //Khia báo các thành phần view
        private ImageView img1, img2, img3;

        public PhotoGridViewHolder(@NonNull View itemView) {
            super(itemView);

            //Thực hiện ánh xạ view
            img1 = itemView.findViewById(R.id.img_1);
            img2 = itemView.findViewById(R.id.img_2);
            img3 = itemView.findViewById(R.id.img_3);
        }
    }

    //thiết kế class thứ kiểu lagre
    public class PhotoLagreViewHolder extends RecyclerView.ViewHolder{

        //Khia báo các thành phần view
        private ImageView img1, img2, img3;

        public PhotoLagreViewHolder(@NonNull View itemView) {
            super(itemView);

            //Thực hiện ánh xạ view
            img1 = itemView.findViewById(R.id.img_1);
            img2 = itemView.findViewById(R.id.img_2);
            img3 = itemView.findViewById(R.id.img_3);
        }
    }
}
