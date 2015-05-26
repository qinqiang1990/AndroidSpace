package com.qq.Util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitMapUtil {

    public static Bitmap clip(Resources resources, int drawable, int x, int y, int width, int height) {
        Bitmap resource = BitmapFactory.decodeResource(resources, drawable);
        return Bitmap.createBitmap(resource, x, y, width, height);
    }

}
