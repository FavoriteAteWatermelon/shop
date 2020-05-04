package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler = new Handler();
    private boolean isFirst = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp =  getPreferences(MODE_PRIVATE);
                boolean isFirst =  sp.getBoolean("isFirst", true);
                Intent intent = new Intent();
                if (isFirst) {
                    sp.edit().putBoolean("isFirst", false).commit();
                    intent.setClass(SplashActivity.this,GuideActivity.class);

                }else {
                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
//                设置界面之间的切换动画
                overridePendingTransition(R.anim.fade, R.anim.hold);
//                finish()的作用的销毁此页面
                finish();
            }
        }, 1500);
    }
}
