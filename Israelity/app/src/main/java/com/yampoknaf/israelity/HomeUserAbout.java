package com.yampoknaf.israelity;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yampoknaf.israelity.HomeFragments.UserAbout;
import com.yampoknaf.israelity.HomeFragments.UserPicture;

/**
 * Created by Orleg on 06/05/2016.
 */
public class HomeUserAbout extends Fragment {
    private boolean doOnce = false;
    private Fragment mUserPicture;
    private Fragment mUserAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_about_layout, container , false);
    }

    private int allImageToDesplay[] = new int[]{R.drawable.profile1 , R.drawable.profile2 , R.drawable.profile3 , R.drawable.profile4 , R.drawable.profile5 , R.drawable.profile6 , R.drawable.profile7};

    @Override
    public void onStart(){
        super.onStart();
        if(!doOnce) {
            UserPicture userPicture = new UserPicture();
            mUserPicture = userPicture;
            userPicture.putPrefferPicSize(R.drawable.profilepic);
            UserAbout userAbout = new UserAbout();
            mUserAbout = userAbout;
            final FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.HomeAboutLayout, userAbout , "UserAbout");
            fragmentTransaction.add(R.id.HomeAboutLayout, userPicture, "UserPicture");
            for(int i = 0 ; i < allImageToDesplay.length ; i++) {
                userPicture = new UserPicture();
                userPicture.putPrefferPicSize(true, allImageToDesplay[i], 250, 250);
                fragmentTransaction.add(R.id.HomeLayoutFollower, userPicture, "UserFolowMe" + i);
                userPicture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("OnClickListener", "as been clicked");
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.remove(mUserPicture);
                        fragmentTransaction.remove(mUserAbout);
                        UserPicture userPicture = new UserPicture();
                        UserAbout userAbout = new UserAbout();
                        userPicture.putPrefferPicSize((int) ((ImageView) v).getTag());
                        fragmentTransaction.add(R.id.HomeAboutLayout, userPicture, "UserPicture");
                        fragmentTransaction.add(R.id.HomeAboutLayout, userAbout, "UserAbout");
                        fragmentTransaction.commit();
                        mUserPicture = userPicture;
                        mUserAbout = userAbout;
                    }
                });
            }
            fragmentTransaction.commit();

            doOnce = true;
        }
    }
}
