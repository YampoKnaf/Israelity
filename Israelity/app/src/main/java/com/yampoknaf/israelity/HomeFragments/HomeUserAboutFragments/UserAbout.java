package com.yampoknaf.israelity.HomeFragments.HomeUserAboutFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yampoknaf.israelity.R;

/**
 * Created by Orleg on 07/05/2016.
 */
public class UserAbout extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_user_about , container , false);
        TextView politicsSide = (TextView)v.findViewById(R.id.userAboutPoliticsSide);
        TextView religion = (TextView)v.findViewById(R.id.userAboutReligion);
        TextView city = (TextView)v.findViewById(R.id.userAboutCity);
        TextView autorize = (TextView)v.findViewById(R.id.userAboutAutoriseInApp);
        TextView messgeToReader = (TextView)v.findViewById(R.id.userAboutMessageToReaders);

        politicsSide.setText("Plitices Side: Rightest");
        religion.setText("Religion: jewish");
        city.setText("City: rishone le zion");
        autorize.setText("Premmision:\ncan do whatever he want \ncan delete any post \ncan override any post \ngod like \ncan kick any user \ncan give other premmision \n can translate to english");
        messgeToReader.setText("Message To Reader:\ni like milk and choclate , i think that evryone need to live in armoney and to love each other no one need ever to be harmed expect black and red and yellow skine bastard!!!!");
        return v;
    }
}
