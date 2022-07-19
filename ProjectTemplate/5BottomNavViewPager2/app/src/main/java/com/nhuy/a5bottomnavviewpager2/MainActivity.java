package com.nhuy.a5bottomnavviewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nhuy.a5bottomnavviewpager2.Tranformer.DepthPageTransformer;
import com.nhuy.a5bottomnavviewpager2.Tranformer.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager2 = findViewById(R.id.view_pager2);
        mBottomNavigation = findViewById(R.id.bottom_navigation);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager2.setAdapter(myViewPagerAdapter);

        mBottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.bottom_home){
                    mViewPager2.setCurrentItem(0);
                } else if(id == R.id.bottom_favorite){
                    mViewPager2.setCurrentItem(1);
                } else if(id == R.id.bottom_history){
                    mViewPager2.setCurrentItem(2);
                }
                return true;
            }
        });

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:{
                        mBottomNavigation.getMenu().findItem(R.id.bottom_home).setChecked(true);
                        break;
                    }
                    case 1:{
                        mBottomNavigation.getMenu().findItem(R.id.bottom_favorite).setChecked(true);
                        break;
                    }
                    case 2:{
                        mBottomNavigation.getMenu().findItem(R.id.bottom_history).setChecked(true);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_zoom){
            mViewPager2.setPageTransformer(new ZoomOutPageTransformer());
        } else {
            mViewPager2.setPageTransformer(new DepthPageTransformer());
        }
        return true;
    }
}