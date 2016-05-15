package com.yampoknaf.israelity.HomeFragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yampoknaf.israelity.HelperFunction.CleannerThread;
import com.yampoknaf.israelity.HelperFunction.OnBackPressedListener;
import com.yampoknaf.israelity.HomeFragments.HomeUserAboutFragments.UserAbout;
import com.yampoknaf.israelity.HomeFragments.HomeUserAboutFragments.UserPicture;
import com.yampoknaf.israelity.MainActivity;
import com.yampoknaf.israelity.R;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Orleg on 06/05/2016.
 */
public class HomeUserAbout extends Fragment implements OnBackPressedListener{
    private boolean doOnce = false;
    private Fragment mUserPicture;
    private Fragment mUserAbout;
    private Thread cleaning;
    private ArrayList<UserPicture> listUserPicture = new ArrayList<UserPicture>();
    public Stack<Integer> myBackStack = new Stack<Integer>();
    private FragmentManager fragmentManager;

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
            userPicture.putPrefferPicSize(R.drawable.profilepic, 0);
            listUserPicture.add(userPicture);
            UserAbout userAbout = new UserAbout();
            mUserAbout = userAbout;
            fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.userAboutHomeAboutLayOut, userAbout, "UserAbout");
            fragmentTransaction.add(R.id.userPhotoHomeAboutLayOut, userPicture, "UserPicture");
            for(int i = 1 ; i < allImageToDesplay.length + 1 ; i++) {
                userPicture = new UserPicture();
                userPicture.putPrefferPicSize(true, i, allImageToDesplay[i - 1], 250, 250);
                fragmentTransaction.add(R.id.HomeLayoutFollower, userPicture, "UserFolowMe" + i);
                userPicture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.i("OnClickListener", "as been clicked");
                        fragmentManager = getChildFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.remove(mUserPicture);
                        fragmentTransaction.remove(mUserAbout);
                        UserPicture userPicture = new UserPicture();
                        UserAbout userAbout = new UserAbout();
                        userPicture.putPrefferPicSize((int[]) ((ImageView) v).getTag());
                        fragmentTransaction.add(R.id.userPhotoHomeAboutLayOut, userPicture, "UserPicture");
                        fragmentTransaction.add(R.id.userAboutHomeAboutLayOut, userAbout, "UserAbout");
                        fragmentTransaction.commit();
                        mUserPicture = userPicture;
                        mUserAbout = userAbout;

                        if (!firstTimeToPressBack) {
                            firstTimeToPressBack = true;
                            if (myBackStack.size() <= 0) {
                                myBackStack.push(0);
                            }
                        }

                        //if (!goingBack)
                        myBackStack.push(((int[]) v.getTag())[1]);

                        goingBack = false;

                    }
                });

                listUserPicture.add(userPicture);
            }
            fragmentTransaction.commit();
            myBackStack.push(0);
            doOnce = true;
        }else{
            for(UserPicture userPicture : listUserPicture){
                userPicture.setOnClickListener();
            }
        }

        cleaning = new CleannerThread();
        MainActivity.onBackPressedListener = this;
    }

    @Override
    public void onStop(){
        super.onStop();
        CleannerThread.stopCleaning();
       /* final FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(mUserPicture);
        fragmentTransaction.remove(mUserAbout);
        fragmentTransaction.commit();
        listUserPicture = new ArrayList<>();
        myBackStack = new Stack<>();
        doOnce = false;*/
    }

    private boolean goingBack = false;
    private boolean firstTimeToPressBack = true;

    @Override
    public boolean OnBackPressed() {

        if(firstTimeToPressBack){
            myBackStack.pop();
            firstTimeToPressBack = false;
        }

        if(myBackStack.size() <= 0) {
                return false;
        }
        goingBack = true;
        int numberOfPic = myBackStack.pop();
        if(numberOfPic != 0)
            listUserPicture.get(numberOfPic).performClick();
        else{
            final FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(mUserPicture);
            fragmentTransaction.remove(mUserAbout);
            UserPicture userPicture = new UserPicture();
            UserAbout userAbout = new UserAbout();
            userPicture.putPrefferPicSize(R.drawable.profilepic , 0);
            fragmentTransaction.add(R.id.userPhotoHomeAboutLayOut, userPicture, "UserPicture");
            fragmentTransaction.add(R.id.userAboutHomeAboutLayOut, userAbout, "UserAbout");
            fragmentTransaction.commit();
            mUserPicture = userPicture;
            mUserAbout = userAbout;
        }
        //goingBack = false;
        return true;
    }
}
