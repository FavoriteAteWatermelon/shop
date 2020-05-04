package com.example.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
//  获取图片资源
    int [] imgRes = new int []{
            R.mipmap.a,
            R.mipmap.b,
        R.mipmap.c,
        R.mipmap.d
};
    private  Button mBtnStart;
    private List<View> mViewList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        1. 初始化数据这个步骤必须在前面
        initPage();

        setContentView(R.layout.activity_guide);
        ViewPager viewPager = findViewById(R.id.viewPager);
//        添加适配器
        viewPager.setAdapter(new myPageAdapter());
        viewPager.setOnPageChangeListener( new MyLisener());
        mBtnStart = (Button)findViewById(R.id.btnStart);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

    }
//   1. 初始化数据
    private  void  initPage() {
        for (int i = 0; i < imgRes.length; i++) {
//         1.   inlflate加载数据,设置image的src
            View inflate = getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView ivGuide = (ImageView) inflate.findViewById(R.id.imageItem);
//            设置前景
//            ivGuide.setImageResource(imgRes[i]);
            ivGuide.setBackgroundResource(imgRes[i]);
//          2.   把每个设置好image的src的 inlfale加入mViewList
            mViewList.add(inflate);
      }
    }


//  2. 引导界面ViewPager适配器
    class myPageAdapter extends PagerAdapter {
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view= mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
//            返回容器的大小4个
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//            官方推荐写法
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViewList.get(position));
        }
    }
    class  MyLisener implements  ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
//        ViewPager滚动到第几张
        @Override
        public void onPageSelected(int position) {

//            假如滚动到最后一张
            if (position == imgRes.length - 1) {
                mBtnStart.setVisibility(View.VISIBLE);

                Animation btn_anim =  AnimationUtils.loadAnimation(GuideActivity.this,R.anim.anim_guide_btn);
                mBtnStart.startAnimation(btn_anim);
            }else  {
                mBtnStart.setVisibility(View.GONE);
//                Animation btn_anim =  AnimationUtils.loadAnimation(GuideActivity.this,R.anim.anim_guide_btn_fade);
//                mBtnStart.startAnimation(btn_anim);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
