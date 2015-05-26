package com.qq;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class AnimActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        Toast.makeText(AnimActivity.this, uri.getAuthority() + "|" + uri.getHost() + "|" + uri.getPath(), Toast.LENGTH_LONG).show();

        /*ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ((AnimationDrawable) imageView.getDrawable()).start();*/

        try {
            ActivityInfo info = this.getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Bundle bundle = info.metaData;
            String msg = bundle.getString("username") + "|" + bundle.getInt("age");
            Toast.makeText(AnimActivity.this, msg, Toast.LENGTH_LONG).show();


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
