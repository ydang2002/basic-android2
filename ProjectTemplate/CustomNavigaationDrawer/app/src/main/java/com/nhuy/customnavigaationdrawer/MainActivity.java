package com.nhuy.customnavigaationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nhuy.customnavigaationdrawer.Fragment.FavoriteFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HistoryFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  static final int FRAGMENT_HOME = 0;
    private  static final int FRAGMENT_FAVORITE = 1;
    private  static final int FRAGMENT_HISTORY = 2;

    private int mCurrentFragment = FRAGMENT_HOME;

    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private MyViewPagerAdapter mMyViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager2);
        mMyViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager2.setAdapter(mMyViewPagerAdapter);

        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(getString(R.string.nav_home));
                        break;
                    case 1:
                        tab.setText(getString(R.string.nav_favorite));
                        break;
                    case 2:
                        tab.setText(getString(R.string.nav_history));
                        break;
                }
            }
        }).attach();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

//        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mCurrentFragment = FRAGMENT_HOME;
                        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case 1:
                        mCurrentFragment = FRAGMENT_FAVORITE;
                        navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                        break;
                    case 2:
                        mCurrentFragment = FRAGMENT_HISTORY;
                        navigationView.getMenu().findItem(R.id.nav_history).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.nav_home){
            if(mCurrentFragment != FRAGMENT_HOME){
//                replaceFragment(new HomeFragment());
                mViewPager2.setCurrentItem(0);
                mCurrentFragment = FRAGMENT_HOME;
            }
        } else if(id== R.id.nav_favorite){
            if(mCurrentFragment != FRAGMENT_FAVORITE){
//                replaceFragment(new FavoriteFragment());
                mViewPager2.setCurrentItem(1);
                mCurrentFragment = FRAGMENT_FAVORITE;
            }
        } else if(id== R.id.nav_history){
            if(mCurrentFragment != FRAGMENT_HISTORY){
//                replaceFragment(new HistoryFragment());
                mViewPager2.setCurrentItem(2);
                mCurrentFragment = FRAGMENT_HISTORY;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);//32:23
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    private  void replaceFragment(Fragment fragment){
//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.replace(R.id.content_frame, fragment);
//    transaction.commit();
//    }
}