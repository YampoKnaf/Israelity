package com.yampoknaf.israelity.HomeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.yampoknaf.israelity.R;

/**
 * Created by Orleg on 07/05/2016.
 */
public class UserPeopleThatFollowMe extends Fragment {

    private int allImageToDesplay[] = new int[]{R.drawable.profile1 , R.drawable.profile2 , R.drawable.profile3 , R.drawable.profile4 , R.drawable.profile5 , R.drawable.profile6 , R.drawable.profile7};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /*ScrollView v = (ScrollView)inflater.inflate(R.layout.home_about_layout , container,false).findViewById(R.id.HomeLayoutFollower);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        for(int i = 0 ; i < allImageToDesplay.length ; i++ ){
            ImageView imageView = new ImageView(getContext());
            Glide.with(getActivity()).load(allImageToDesplay[i]).override(250 , 250).fitCenter().into(imageView);
            linearLayout.addView(imageView);
        }
        v.addView(linearLayout);
        return v;*/
        return null;
    }

}
