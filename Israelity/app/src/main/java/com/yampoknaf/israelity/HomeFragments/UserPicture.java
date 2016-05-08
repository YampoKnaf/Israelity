package com.yampoknaf.israelity.HomeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yampoknaf.israelity.HelperFunction.BigHelper;
import com.yampoknaf.israelity.R;



/**
 * Created by Orleg on 07/05/2016.
 */
public class UserPicture extends Fragment {

    private boolean mOtherSize;
    private int mWhichPic;
    private int mXSize;
    private int mYSize;
    private ImageView profilePic;

    public void putPrefferPicSize(int whichPic){
        putPrefferPicSize(false , whichPic , -2 , -2);
    }
    public void putPrefferPicSize(boolean otherSize , int whichPic , int xSize , int ySize){
        mOtherSize = otherSize;
        mWhichPic = whichPic;
        mXSize = xSize;
        mYSize = ySize;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.user_picture, container, false);

        profilePic = (ImageView)v.findViewById(R.id.user_profile_pic);
        Glide.with(getActivity()).load(mWhichPic).override(!mOtherSize ? BigHelper.getWindowWidthSize() : mXSize, !mOtherSize ? BigHelper.getWindowHigthSize(): mYSize).fitCenter().into(profilePic);
        profilePic.setTag(mWhichPic);
        final TextView textViewName = (TextView)v.findViewById(R.id.userNameTitleUserPicture);
        final TextView textViewScore = (TextView)v.findViewById(R.id.scoreUserPicture);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //textView.setText("Ori Yampolsky");
                            if (!mOtherSize) {
                                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                params.addRule(RelativeLayout.ABOVE, R.id.emptyLayOutUser_Picture);
                                params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.user_profile_pic);
                                params.setMargins(20, 20, 20, 20);
                                textViewName.setLayoutParams(params);
                                textViewName.setText("Ori Yampolsky");
                                textViewScore.setText("your score is 5000!!");
                                textViewScore.setPadding(20, 20, 20, 20);
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return v;
    }

    public void setOnClickListener(final View.OnClickListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        profilePic.setOnClickListener(listener);
                    }
                });
            }
        }).start();
    }
}
