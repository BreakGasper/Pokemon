package com.example.pokemon.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.pokemon.R;
import com.example.pokemon.databinding.ActivitySplashBinding;
import com.example.pokemon.databinding.ActivitySplashBindingImpl;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        try {
            getSupportActionBar().hide();
            getActionBar().hide();
        } catch (Exception e) {
            Log.e("SPLASH ", String.valueOf(e));
        }

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ivgirar);
        animation.setDuration(1500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(), IndexActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bi.logoPokeball.startAnimation(animation);

    }
}