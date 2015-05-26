package com.qq.Animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by qq on 15-5-19.
 */
public class Utils {
    public static Animation getAnimation(Context context, int anim) {
        return AnimationUtils.loadAnimation(context, anim);
    }
}
