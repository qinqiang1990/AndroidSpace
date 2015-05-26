package com.qq.FileUtil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.qq.Log.Tag;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by qq on 15-5-15.
 */
public class InternalUtil {


    public static void writeFile(Activity activity, String filename, String charset, String content) throws IOException {
        //"UTF-8"
        FileOutputStream fos = activity.openFileOutput(filename, Context.MODE_APPEND|Context.MODE_PRIVATE);

        OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
        osw.write(content);
        osw.flush();
        fos.flush();
        osw.close();
        fos.close();
        Log.d(Tag.INTERNAL,"write   "+content);
    }

    public static String readFile(Activity activity, String filename, String charset) throws IOException {
        //"UTF-8"
        FileInputStream fis = activity.openFileInput(filename);
        InputStreamReader isr = new InputStreamReader(fis, charset);
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuffer builder = new StringBuffer();
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        br.close();
        isr.close();
        fis.close();

        Log.d(Tag.INTERNAL,"read    "+builder.toString());
        return builder.toString();
    }
}
