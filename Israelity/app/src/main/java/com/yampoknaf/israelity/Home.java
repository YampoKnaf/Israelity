package com.yampoknaf.israelity;

        import android.support.v4.app.Fragment;
        import android.os.Bundle;
        import android.support.v4.app.FragmentTabHost;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.yampoknaf.israelity.HomeFragments.HomeUserAbout;
        import com.yampoknaf.israelity.HomeFragments.PrivateMessage;

public class Home extends Fragment {


    private static FragmentTabHost tabHost;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_home, container,
                false);

        tabHost = (FragmentTabHost) v.findViewById(R.id.testtabhost1);

        //tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontents);

        tabHost.addTab(tabHost.newTabSpec("tab_test1").setIndicator("Me"), HomeUserAbout.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_test2").setIndicator("Private Message"), PrivateMessage.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_test3").setIndicator("Score Update"), HomeUserAbout.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_test4").setIndicator("People i Follow") , HomeUserAbout.class , null);
        tabHost.addTab(tabHost.newTabSpec("tab_test5").setIndicator("Setting"), HomeUserAbout.class, null);
        tabHost.setCurrentTab(0);

        return v;
    }

    public static void goToMainTab(){
        tabHost.setCurrentTab(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabHost = null;
    }

}