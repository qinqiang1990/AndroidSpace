package com.qq.jh;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.thinkland.sdk.android.JuheSDKInitializer;

public class SDKApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        JuheSDKInitializer.initialize(getApplicationContext());
    }

}