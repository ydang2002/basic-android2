package com.nhuy.customnavigaationdrawer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nhuy.customnavigaationdrawer.Fragment.FavoriteFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HistoryFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HomeFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case  0:
                return new HomeFragment();
            case  1:
                return new FavoriteFragment();
            case  2:
                return new HistoryFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
