package com.yampoknaf.israelity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.ImageView;

import com.yampoknaf.israelity.HelperFunction.BigHelper;
import com.yampoknaf.israelity.HelperFunction.OnBackPressedListener;
import com.yampoknaf.israelity.HomeFragments.HomeUserAbout;

public class MainActivity extends FragmentActivity {
    // Fragment TabHost as mTabHost
    private FragmentTabHost mTabHost;
    public static OnBackPressedListener onBackPressedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BigHelper.Initialize(this);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("home"),
                Home.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Main Topic"),
                HomeUserAbout.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Hall Of Fame"),
                Home.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Asking"),
                Home.class, null);
        mTabHost.setCurrentTab(0);
    }


    @Override
    public void onBackPressed() {
        if(onBackPressedListener == null || !onBackPressedListener.OnBackPressed()) {
            super.onBackPressed();
        }
    }

}