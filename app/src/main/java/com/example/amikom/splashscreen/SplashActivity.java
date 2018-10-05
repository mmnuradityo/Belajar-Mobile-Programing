package com.example.amikom.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amikom.splashscreen.util.PreferencesHelper;

public class SplashActivity extends AppCompatActivity {

    PreferencesHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        instance = PreferencesHelper.getInstance(getApplicationContext());
        int splashInterval = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!instance.isLogin()){
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this, SplashActivity.class));
                }
            }
        }, splashInterval);
    }
}
