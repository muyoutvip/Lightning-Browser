package com.android.browser.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ChanelInfo {
    public static String getAppChanel(Context context){
        String channel = "";
        try{ ApplicationInfo appInfo = context.getPackageManager()
                .getApplicationInfo(context.getPackageName(),
                        PackageManager.GET_META_DATA);
            channel=appInfo.metaData.getString("MUYOU_CHANNEL");
        }catch (Exception e){

        }


        return channel;
    }
    public static int getAppVer(Context context){
        int appVer = 0;

        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            appVer =  pi.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }



        return appVer;
    }
}
