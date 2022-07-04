package com.nhuy.lesson7lottieandroidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLottieAnimationView = findViewById(R.id.animation_view);
        mLottieAnimationView.playAnimation();
        mLottieAnimationView.setAnimation("loading.json");
        mLottieAnimationView.setRepeatCount(ValueAnimator.INFINITE);
    }
}