package com.qq.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.qq.Density.DensityUtil;

public class CustomDialog extends Dialog {

    //定义回调事件，用于dialog的点击事件
    public interface OnCustomDialogListener {
        public void back(CustomDialog dialog);
    }

    private static int default_width = 160; // 默认宽度
    private static int default_height = 120;// 默认高度
    private OnCustomDialogListener customDialogListener;


    public CustomDialog(Context context, int layout, int style, OnCustomDialogListener customDialogListener) {
        this(context, default_width, default_height, layout, style, customDialogListener);

        //不关闭写法
        //setCancelable(false);

        //关闭写法
        //setCancelable(true);
    }

    public CustomDialog(Context context, int width, int height, int layout, int style, OnCustomDialogListener customDialogListener) {
        super(context, style);
        this.customDialogListener = customDialogListener;

        //设置标题
        setTitle("");
        // 设置内容
        setContentView(layout);
        // 设置窗口属性
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        // 设置宽度、高度、密度、对齐方式
        float density = DensityUtil.getDensity(context);
        params.width = (int) (width * density);
        params.height = (int) (height * density);
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);

        //调用回调函数
        customDialogListener.back(this);
    }


}
