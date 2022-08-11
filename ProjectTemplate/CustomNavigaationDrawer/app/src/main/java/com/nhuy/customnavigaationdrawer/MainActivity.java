package com.nhuy.customnavigaationdrawer;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nhuy.customnavigaationdrawer.Fragment.FavoriteFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HistoryFragment;
import com.nhuy.customnavigaationdrawer.Fragment.HomeFragment;
import com.nhuy.customnavigaationdrawer.Fragment.MyProfileFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final int MY_REQUEST_CODE = 10;
    private  static final int FRAGMENT_HOME = 0;
    private  static final int FRAGMENT_FAVORITE = 1;
    private  static final int FRAGMENT_HISTORY = 2;
    private  static final int FRAGMENT_MY_PROFILE = 3;

    private int mCurrentFragment = FRAGMENT_HOME;

    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private MyViewPagerAdapter mMyViewPagerAdapter;
    private ImageView imgAvatar;
    private TextView tvEmail, tvName;
    private NavigationView mNavigationView;
    final private MyProfileFragment myProfileFragment = new MyProfileFragment();

    final private ActivityResultLauncher <Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                if (intent == null) {
                    return;
                }
                Uri uri = intent.getData();
                myProfileFragment.setUri(uri);
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        myProfileFragment.setBitmapImage(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUi();


        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        mNavigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        mNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        showUserInformation();
    }

    private void initUi() {
        mNavigationView = findViewById(R.id.navigation_view);
        imgAvatar = mNavigationView.getHeaderView(0).findViewById(R.id.img_avatar);
        tvEmail = mNavigationView.getHeaderView(0).findViewById(R.id.tv_email);
        tvName = mNavigationView.getHeaderView(0).findViewById(R.id.tv_name);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.nav_home){
            if(mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                mCurrentFragment = FRAGMENT_HOME;
            }
        } else if(id== R.id.nav_favorite){
            if(mCurrentFragment != FRAGMENT_FAVORITE){
                replaceFragment(new FavoriteFragment());
                mCurrentFragment = FRAGMENT_FAVORITE;
            }
        } else if(id== R.id.nav_history){
            if(mCurrentFragment != FRAGMENT_HISTORY){
                replaceFragment(new HistoryFragment());
                mCurrentFragment = FRAGMENT_HISTORY;
            }
        } else if (id == R.id.nav_sign_out ) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_my_profile ) {
            if(mCurrentFragment != FRAGMENT_MY_PROFILE){
                replaceFragment(myProfileFragment);
                mCurrentFragment = FRAGMENT_MY_PROFILE;
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

    private  void replaceFragment(Fragment fragment){
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.content_frame, fragment);
    transaction.commit();
    }
    
    public void showUserInformation() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            return;
        }

        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        if(name == null) {
            tvName.setVisibility(View.GONE);
        } else {
            tvName.setVisibility(View.VISIBLE);
            tvName.setText(name);
        }

        tvEmail.setText(email);
        Glide.with(this).load(photoUrl).error(R.drawable.ic_avatar_defaul).into(imgAvatar);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
        }
    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent, "Select picture"));
    }
}//31:51