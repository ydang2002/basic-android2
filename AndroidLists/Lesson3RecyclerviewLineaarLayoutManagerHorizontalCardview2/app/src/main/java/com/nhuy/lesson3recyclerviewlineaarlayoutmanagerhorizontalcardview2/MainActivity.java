package com.nhuy.lesson3recyclerviewlineaarlayoutmanagerhorizontalcardview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView revCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revCategory = findViewById(R.id.rev_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        revCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getCategory());
        revCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getCategory(){
        List<Category> listCategory = new ArrayList<>();

        List<Book> listBook = new ArrayList<>();
        listBook.add(new Book(R.drawable.img_avatar_1,"Book 1"));
        listBook.add(new Book(R.drawable.img_avatar_2,"Book 2"));
        listBook.add(new Book(R.drawable.img_avatar_3,"Book 3"));
        listBook.add(new Book(R.drawable.img_avatar_4,"Book 4"));

        listBook.add(new Book(R.drawable.img_avatar_1,"Book 1"));
        listBook.add(new Book(R.drawable.img_avatar_2,"Book 2"));
        listBook.add(new Book(R.drawable.img_avatar_3,"Book 3"));
        listBook.add(new Book(R.drawable.img_avatar_4,"Book 4"));

        listCategory.add(new Category("Category 1", listBook));
        listCategory.add(new Category("Category 2", listBook));
        listCategory.add(new Category("Category 3", listBook));
        listCategory.add(new Category("Category 4", listBook));
        return  listCategory ;
    }
}