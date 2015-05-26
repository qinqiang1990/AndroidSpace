package com.qq.FileUtil;

import android.app.Activity;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by qq on 15-5-15.
 */
public class AssetsUtil {


    public static String readFile(Activity activity, String filename,String charset) throws IOException {
        //"UTF-8"
        InputStream is=activity.getResources().getAssets().open(filename);
        InputStreamReader isr = new InputStreamReader(is, charset);
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuffer builder = new StringBuffer();
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        br.close();
        isr.close();
        is.close();
        return builder.toString();
    }
}
