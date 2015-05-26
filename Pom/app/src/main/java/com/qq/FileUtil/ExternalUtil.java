package com.qq.FileUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.qq.Log.Tag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by qq on 15-5-15.
 */
public class ExternalUtil {

    /**
     * 递归创建文件目录
     */
    public static void makeDir(File dir) {
        if (!dir.getParentFile().exists()) {
            makeDir(dir.getParentFile());
        }
        dir.mkdir();
    }

    /**
     * 在SDCard中创建与删除文件权限 -->
     * <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
     * 往SDCard写入数据权限
     * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
     */
    public static void writeFile(String filename, String charset, String content) throws IOException {

        File SDCard = Environment.getExternalStorageDirectory();
        if (!SDCard.exists()) {
            Log.d(Tag.EXTERNAL, "NO SDCard");
            return;
        }
        File file = new File(SDCard, filename);

        if (!file.exists()) {

            makeDir(file.getParentFile());

            if (!file.createNewFile()) {
                Log.d(Tag.EXTERNAL, "Create File FAIL");
                return;
            }
        }
        //"UTF-8"
        FileOutputStream fos = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
        osw.write(content);
        osw.flush();
        fos.flush();
        osw.close();
        fos.close();
        Log.d(Tag.EXTERNAL, "write   " + content);
    }

    /**
     * 往SDCard读取数据权限
     * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
     */
    public static String readFile(String filename, String charset) throws IOException {
        File SDCard = Environment.getExternalStorageDirectory();
        if (!SDCard.exists()) {
            Log.d(Tag.EXTERNAL, "NO SDCard");
            return "";
        }

        File file = new File(SDCard, filename);
        if (!file.exists()) {
            Log.d(Tag.EXTERNAL, "NO FILE");
            return "";
        }
        //"UTF-8"
        FileInputStream fis = new FileInputStream(file);
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

        Log.d(Tag.EXTERNAL, "read    " + builder.toString());
        return builder.toString();
    }
}
