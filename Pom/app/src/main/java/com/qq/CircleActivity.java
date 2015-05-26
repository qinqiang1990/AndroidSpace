package com.qq;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.qq.Vo.ImageUtil;


public class CircleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    public static class PlaceholderFragment extends Fragment {


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_circle, container, false);
            Drawable mIconPerson = getResources().getDrawable(R.mipmap.txt_person_icon);
            mIconPerson.setBounds(10, 0, 60, 50);
            Drawable mIconLock = getResources().getDrawable(R.mipmap.txt_lock_icon);
            mIconLock.setBounds(10, 0, 60, 50);

            EditText username = (EditText) rootView.findViewById(R.id.username);
            username.setCompoundDrawables(mIconPerson, null, null, null);
            EditText password = (EditText) rootView.findViewById(R.id.password);
            password.setCompoundDrawables(mIconLock, null, null, null);

            Button btn = (Button) rootView.findViewById(R.id.login);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            Drawable tup = getResources().getDrawable(R.mipmap.tup);
            Bitmap bitmap = ImageUtil.drawableToBitmap(tup);
            bitmap = ImageUtil.getRoundedCornerBitmap(bitmap);
            imageView.setImageBitmap(bitmap);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_EDIT);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse("qin://map"));
                    /*intent.setDataAndType(Uri.parse("qin://org.qq.com"), "image/jpg");*/
                    startActivity(intent);
                }
            });
            return rootView;
        }
    }
}