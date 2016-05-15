package com.yampoknaf.israelity.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yampoknaf.israelity.HelperFunction.BigHelper;
import com.yampoknaf.israelity.HelperFunction.CleannerThread;
import com.yampoknaf.israelity.HelperFunction.OnBackPressedListener;
import com.yampoknaf.israelity.Home;
import com.yampoknaf.israelity.MainActivity;
import com.yampoknaf.israelity.R;


/**
 * Created by Orleg on 10/05/2016.
 */
public class PrivateMessage extends Fragment implements OnBackPressedListener {
    private CleannerThread cleannerThread;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.private_message_layout ,container, false );
        ListView listView = (ListView)v.findViewById(R.id.privateMessageListView);

        String allString[] = new String[100];
        listView.setAdapter(new MyListAdapter(getContext() , allString));

        return v;
    }

    @Override
    public boolean OnBackPressed() {
        Home.goToMainTab();
        return true;
    }

    @Override
    public void onStart(){
        super.onStart();
        MainActivity.onBackPressedListener = this;
        cleannerThread = new CleannerThread();

    }

    @Override
    public void onStop(){
        super.onStop();
        CleannerThread.stopCleaning();
    }

    class MyListAdapter extends ArrayAdapter<String> {
        private Context context;

        public MyListAdapter(Context c, String name[]) {
            super(c, R.layout.private_message_row, name);
            context = c;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewItemToChange holder = null;
            if(row == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.private_message_row ,parent , false);
                holder = new ViewItemToChange(row);
                row.setTag(holder);
            }else{
                holder = (ViewItemToChange)row.getTag();
            }

            ImageView image = holder.getPhoto();
            TextView name = holder.getName();
            TextView title = holder.getTitle();
            ImageButton delete = holder.getDelete();

            BigHelper.setImage(getActivity(), image, R.drawable.profile2, 200, 200);
            name.setText("Ori Yampolsky");
            title.setText("you cannot belive what we found in lochness!!");
            BigHelper.setImage(getActivity(), delete, R.drawable.profile3, 120, 200);


            return row;
        }

        private class ViewItemToChange{
            private ImageView photo;
            private TextView name;
            private TextView title;
            private ImageButton delete;

            public ViewItemToChange(View view){
                photo = (ImageView)view.findViewById(R.id.privateMessageRowPhoto);
                name = (TextView)view.findViewById(R.id.privateMessageRowName);
                title = (TextView)view.findViewById(R.id.privateMessageRowTitle);
                delete = (ImageButton)view.findViewById(R.id.privateMessageRowDelete);
            }

            public ImageView getPhoto() {
                return photo;
            }

            public TextView getName() {
                return name;
            }

            public TextView getTitle() {
                return title;
            }

            public ImageButton getDelete() {
                return delete;
            }
        }
    }
}

