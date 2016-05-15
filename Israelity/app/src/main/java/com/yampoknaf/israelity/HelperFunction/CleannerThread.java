package com.yampoknaf.israelity.HelperFunction;

import com.bumptech.glide.Glide;

/**
 * Created by Orleg on 10/05/2016.
 */
public class CleannerThread extends Thread {

    private static  boolean needToKeepRunning = true;

    public CleannerThread(){
        super(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                needToKeepRunning = true;
                while(needToKeepRunning) {
                    System.gc();
                    Runtime.getRuntime().gc();
                    try{
                        Thread.sleep(1500);
                    }catch (Exception e){}
                }
            }
        });
        start();
    }

    public static void stopCleaning(){
        needToKeepRunning = false;
    }
}

