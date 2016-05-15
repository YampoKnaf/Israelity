package com.yampoknaf.israelity.HomeFragments.HomeUserAboutFragments;

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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
    private int mPicNumber;
    private ImageView profilePic;

    /***
     * no need to index the Object
     * @param whichPic
     */

    public void putPrefferPicSize(int whichPic){
        putPrefferPicSize(whichPic , -2);
    }
    /***
     *
     * @param information [0] -> whichPic , [1] -> numberOfPic
     */
    public void putPrefferPicSize(int[] information){
        putPrefferPicSize(information[0] , information[1]);
    }
    public void putPrefferPicSize(int whichPic ,int number){
        putPrefferPicSize(false ,number , whichPic , -2 , -2);
    }
    public void putPrefferPicSize(boolean otherSize ,int number ,int whichPic , int xSize , int ySize){
        mOtherSize = otherSize;
        mWhichPic = whichPic;
        mXSize = xSize;
        mYSize = ySize;
        mPicNumber = number;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.user_picture, container, false);
        profilePic = (ImageView)v.findViewById(R.id.user_profile_pic);
        BigHelper.setImage(getActivity() ,profilePic, mWhichPic ,!mOtherSize ? BigHelper.getWindowWidthSize() : mXSize, !mOtherSize ? BigHelper.getWindowHigthSize() : mYSize );
        /*Glide.with(getActivity()).load(mWhichPic).override().diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).fitCenter().into(profilePic);*/
        profilePic.setTag(new int[]{mWhichPic,mPicNumber});
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

    private View.OnClickListener mListener;

    public void setOnClickListener(){
        setOnClickListener(mListener);
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
                /*getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {*/
                        mListener = listener;
                        profilePic.setOnClickListener(listener);
                /*    }
                });*/
            }
        }).start();
    }

    public void performClick(){
        profilePic.performClick();
    }
}
