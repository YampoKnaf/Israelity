package com.yampoknaf.israelity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

import com.yampoknaf.israelity.HelperFunction.BigHelper;

public class MainActivity extends FragmentActivity {
    // Fragment TabHost as mTabHost
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BigHelper.Initialize(this);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Tab1"),
                Home.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Tab2"),
                HomeUserAbout.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Tab3"),
                Home.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Tab4"),
                Home.class, null);
        mTabHost.setCurrentTab(0);
    }
}