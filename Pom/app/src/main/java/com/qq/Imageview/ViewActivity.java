package com.qq.Imageview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.qq.poem.R;

public class ViewActivity extends ActionBarActivity {

    ViewFlipper viewFlipper;
    float startX;
    LinearLayout Linear;
    //  ArrayList<ImageView> images = new ArrayList<ImageView>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);

        Linear = (LinearLayout) this.findViewById(R.id.Linear);
        Linear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;

                    case MotionEvent.ACTION_UP:

                        if (event.getX() > startX) {    //  >>>
                            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.in_leftright));
                            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.out_leftright));
                            viewFlipper.showNext();
                        } else if (event.getX() < startX) { // <<<
                            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.in_rightleft));
                            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.out_rightleft));
                            viewFlipper.showPrevious();
                        }
                        break;
                }
                return true;
            }
        });

    }
    /*    images.add((ImageView)this.findViewById(R.id.imageview1));
        images.add((ImageView)this.findViewById(R.id.imageview2));
        images.add((ImageView)this.findViewById(R.id.imageview3));
        images.add((ImageView)this.findViewById(R.id.imageview4));*/



/*

    protected void setImage(int i) {
        for (int j = 0; j < 4; j++) {
            if (j != i)
                images.get(j).setImageResource(R.drawable.pic1);
            else
                images.get(j).setImageResource(R.drawable.pic2);
        }
    }
*/
/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:

                if (event.getX() > startX) {    //  >>>
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.in_leftright));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.out_leftright));
                    viewFlipper.showNext();
                } else if (event.getX() < startX) { // <<<
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.in_rightleft));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(ViewActivity.this, R.anim.out_rightleft));
                    viewFlipper.showPrevious();
                }
                break;
        }

        return super.onTouchEvent(event);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_pager, menu);
        return true;
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


}
