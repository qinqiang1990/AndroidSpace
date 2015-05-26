package com.qq.Circle;

import android.app.Activity;
import android.graphics.drawable.Drawable;

/**
 * Created by Yasenia on 15-5-22.
 */
public class Util {


    public void getDrawable(Activity activity, int resourceid, int width, int height) {

        //获得图片资源信息
        Drawable drawable = activity.getResources().getDrawable(resourceid);

        //将图片“贝贝”和“妮妮”压缩到原图片尺寸的80%
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() * 4 / 5, drawable.getIntrinsicHeight() * 4 / 5);

        //将图片“欢欢”放大到原图片尺寸的120%
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() * 5 / 4, drawable.getIntrinsicHeight() * 5 / 4);

        //其他福娃图片保持原图片尺寸
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());


    }

}


