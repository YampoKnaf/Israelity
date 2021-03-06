package com.yampoknaf.israelity.HelperFunction;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Orleg on 08/05/2016.
 */
public class BigHelper {

    private static Point windowSize;

    public static void Initialize(Activity activity){
        initScreenSize(activity);
    }

    private static void initScreenSize(Activity activity) {
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        windowSize = new Point();
        Display display = wm.getDefaultDisplay();
        display.getSize(windowSize);
        Log.i("just to know", windowSize.toString());
    }

    public static int getWindowWidthSize(){
        return windowSize.x;
    }

    public static int getWindowHigthSize(){
        return windowSize.y;
    }

    public static void setImage(Activity activity ,ImageView imageView, int imageNum , int sizeX , int sizeY){
        Glide.with(activity).load(imageNum).override(sizeX , sizeY).diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).fitCenter().into(imageView);
    }
}
