package com.qq.poem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qq.FileUtil.ExternalUtil;
import com.qq.FileUtil.InternalUtil;
import com.qq.FileUtil.RawUtil;
import com.qq.Log.Tag;
import com.qq.asynctask.RestTask;
import com.qq.rest.HttpRestful;

import java.io.IOException;

public class OneActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, View.OnClickListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private DrawerLayout drawerLayout;

    private FrameLayout drawer;

    private ImageView imageView;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                drawerLayout);

        imageView = (ImageView) findViewById(R.id.imageView);

        //imageView.setImageLevel(8);
       /* ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        drawable.setLevel(3000);*/
       /* try {
            ExternalUtil.writeFile("external/order.txt","UTF-8","Hello World 你好 世界");

            ExternalUtil.writeFile("order.txt","UTF-8","Hello World 你好 世界");

            ExternalUtil.readFile("external/order.txt", "UTF-8");

            ExternalUtil.readFile("order.txt", "UTF-8");

            InternalUtil.writeFile(this,"book.txt","UTF-8","Hello World 你好 世界");

            InternalUtil.readFile(this,"book.txt","UTF-8");
        } catch (IOException e) {
            Log.e(Tag.ERROR,e.toString());
        }*/
        //pager
        Button pager = (Button) findViewById(R.id.pager);
        pager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(OneActivity.this, "Hello", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(OneActivity.this, TabActivity.class);
                startActivity(intent);

                //不回退，而退出
                //finish();
            }
        });


        //自定义

        drawer = (FrameLayout) findViewById(R.id.right);

        Button right = (Button) findViewById(R.id.open);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(drawer)) {
                    drawerLayout.closeDrawer(drawer);
                } else {
                    drawerLayout.openDrawer(drawer);
                }
            }
        });


        Button close = (Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(drawer)) {
                    drawerLayout.closeDrawer(drawer);
                }
            }
        });

        //restful


        final TextView restful_text = (TextView) findViewById(R.id.restfultext);
        Button restful = (Button) findViewById(R.id.restful);
        restful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://food.dcai100.com/sync/shop/booking/f1e0623a-7b56-4767-8c4a-3ea0c06c10d7";
                RestTask restTask = new RestTask(restful_text);
                restTask.execute(url);

            }
        });


        Button bar = (Button) findViewById(R.id.bar);
        bar.setOnClickListener(this);

        Button turn_on = (Button) findViewById(R.id.turn_on);
        turn_on.setOnClickListener(this);

        Button turn_off = (Button) findViewById(R.id.turn_off);
        turn_off.setOnClickListener(this);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.one, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //TransitionDrawable drawable = (TransitionDrawable) imageView.getDrawable();
        switch (view.getId()) {
            case R.id.bar:
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("EditText", "EditText");
                intent.putExtras(bundle);
                intent.setClass(OneActivity.this, BarActivity.class);
                startActivity(intent);
                break;
            case R.id.turn_off:
                // imageView.setImageLevel(16);
                imageView.setScaleX((float) (imageView.getScaleX() * 1.2));
                imageView.setScaleY((float) (imageView.getScaleY() * 1.2));

                //drawable.reverseTransition(1000);
                break;
            case R.id.turn_on:
                // imageView.setImageLevel(8);

                imageView.setScaleX((float) (imageView.getScaleX() / 1.2));
                imageView.setScaleY((float) (imageView.getScaleY() / 1.2));

                //drawable.startTransition(1000);

                break;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_one, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((OneActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
