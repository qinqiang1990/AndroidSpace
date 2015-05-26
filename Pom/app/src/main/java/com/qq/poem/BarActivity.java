package com.qq.poem;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.qq.Log.Tag;
import com.qq.R;


public class BarActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Log.d(Tag.BAR, "onCreate");

        //向上
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(BarActivity.this,getString(R.string.settings),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.view:


                Toast.makeText(BarActivity.this,getString(R.string.view),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.search:
                Toast.makeText(BarActivity.this,getString(R.string.search),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.share:
                Toast.makeText(BarActivity.this,getString(R.string.share),Toast.LENGTH_SHORT).show();
                return true;

            case android.R.id.home:
                Toast.makeText(BarActivity.this,"home",Toast.LENGTH_SHORT).show();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bar, container, false);
            return rootView;
        }
    }

}
