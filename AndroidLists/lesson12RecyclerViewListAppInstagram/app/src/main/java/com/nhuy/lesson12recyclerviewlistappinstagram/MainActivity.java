package com.nhuy.lesson12recyclerviewlistappinstagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ view
        rcvPhoto = findViewById(R.id.rcv_photo);
        //Xác định layoutManager mà sữ dụng trong bài
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPhoto.setLayoutManager(linearLayoutManager);

        //Khởi tạo ListPhotoAdapter
        ListPhotoAdapter listPhotoAdapter = new ListPhotoAdapter();
        //setData
        listPhotoAdapter.setData(getListPhoto());
        //setAdapter
        rcvPhoto.setAdapter(listPhotoAdapter);
    }

    private List<ListPhoto> getListPhoto(){
        List<ListPhoto> listPhotos = new ArrayList<>();

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.img_avatar_2));
        list.add(new Photo(R.drawable.img_avatar_3));
        list.add(new Photo(R.drawable.img_avatar_4));

        List<Photo> list2 = new ArrayList<>();
        list2.add(new Photo(R.drawable.img_avatar_4));
        list2.add(new Photo(R.drawable.img_avatar_4));
        list2.add(new Photo(R.drawable.img_avatar_2));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LAGRE,list));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LAGRE,list));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LAGRE,list));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID,list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LAGRE,list));

        return listPhotos;
    }
}