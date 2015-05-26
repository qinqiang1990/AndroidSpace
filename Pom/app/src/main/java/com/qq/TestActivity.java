package com.qq;

import android.graphics.Matrix;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.qq.Vo.DensityUtil;

import java.util.ArrayList;


public class TestActivity extends ActionBarActivity {

    private ViewPager pager;
    private ArrayList<View> views;
    private ArrayList<String> titleList;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        image = (ImageView) findViewById(R.id.imageView2);

        pager = (ViewPager) findViewById(R.id.pager);

        titleList = new ArrayList<String>();
        views = new ArrayList<View>();

        LayoutInflater mLi = LayoutInflater.from(this);

        View view1 = mLi.inflate(R.layout.view, null);
        ImageView imageView1 = (ImageView) view1.findViewById(R.id.image);
        imageView1.setBackgroundResource(R.mipmap.pic1);
        views.add(view1);
        titleList.add("pic1");

        View view2 = mLi.inflate(R.layout.view, null);
        ImageView imageView2 = (ImageView) view2.findViewById(R.id.image);
        imageView2.setBackgroundResource(R.mipmap.pic2);
        views.add(view2);
        titleList.add("pic2");

        View view3 = mLi.inflate(R.layout.view, null);
        ImageView imageView3 = (ImageView) view3.findViewById(R.id.image);
        imageView3.setBackgroundResource(R.mipmap.pic3);
        views.add(view3);
        titleList.add("pic3");


        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == views.get((int) Integer.parseInt(object.toString()));
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position % views.size()));
                return position % views.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        };
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new MyPageChangeListener());
    }


    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int cur = 0;
        private int width = 100;
        private int offset = 25;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int begin = (width + offset) * cur;
            int end = (width + offset) * position;
            TranslateAnimation animation = new TranslateAnimation(DensityUtil.dip2px(TestActivity.this, begin), DensityUtil.dip2px(TestActivity.this, end), 0, 0);
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            image.startAnimation(animation);
            cur = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
