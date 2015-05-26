package com.qq;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.qq.Vo.VoUtil;


public class MainActivity extends ActionBarActivity {
    private String[] strs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);

     /*   VoUtil voUtil = new VoUtil();
        String url = "http://food.dcai100.com/sync/shop/booking/list?restname=null&begin=2015/04/20&end=2015/05/30&userid=wurongwei111&currentPage=1&pageSize=11";
        voUtil.GetJson(url, this);
        String imageURL = "http://sync.dcai100.com/uploads/1b8ffad5-5387-5971-b1f7-1abd5c2caa42/img/5609b09e-622e-40da-9213-76ac212c2ad6.jpg";
        voUtil.GetImage(imageURL, this, R.id.imageView);
        voUtil.GetNetworkImage(imageURL, this, R.id.networkImageView);
*/
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBar actionBar = MainActivity.this.getSupportActionBar();
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
