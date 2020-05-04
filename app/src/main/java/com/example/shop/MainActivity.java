package com.example.shop;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private  Class[] fragmentList = new Class [] {
            MainFragment.class,
            AroundFragment.class,
            MineFragment.class,
            MoreFragment.class
    };
    private  int [] imgSelecotors = new int [] {
            R.drawable.home,
            R.drawable.recommend,
            R.drawable.video,
            R.drawable.my
//      R.drawable.home,
//      R.drawable.home1,
//      R.drawable.recommend,
//      R.drawable.recommend1,
//      R.drawable.video,
//      R.drawable.video1,
//      R.drawable.my,
//      R.drawable.my1
    };
    private  String [] tabTitle = new String [] {
      "首页",
      "周边",
            "我的",
            "更多"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab1"),  MainFragment.class,null);
//        tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab2"),  AroundFragment.class,null);
        for (int i = 0; i <fragmentList.length ; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_iv = (ImageView) inflate.findViewById(R.id.iv);
            TextView tab_tv = (TextView) inflate.findViewById(R.id.tv);
            tab_iv.setImageResource(imgSelecotors[i]);
            tab_tv.setText(tabTitle[i]);
            tabHost.addTab(tabHost.newTabSpec(""+i).setIndicator("tab" + i).setIndicator(inflate), fragmentList[i],null);
        }

    }
}
