package com.book;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.qq.R;

import java.util.ArrayList;
import java.util.HashMap;

public class BookActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        final Button Monday = (Button) findViewById(R.id.Monday);
        final Button Tuesday = (Button) findViewById(R.id.Tuesday);
        final Button Wednesday = (Button) findViewById(R.id.Wednesday);
        final Button Thursday = (Button) findViewById(R.id.Thursday);
        final Button Friday = (Button) findViewById(R.id.Friday);

        final ListView lv = (ListView) findViewById(R.id.lv);


        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("work", "²Ë°ü");
            map.put("price", "5");
            listItem.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(BookActivity.this,
                listItem, R.layout.book_item, new String[]{"work", "price"},
                new int[]{R.id.work, R.id.price});

        lv.setAdapter(adapter);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Monday.setBackgroundColor(Color.argb(255,137,255,255));
                Tuesday.setBackgroundColor(Color.argb(255,137,255,255));
                Wednesday.setBackgroundColor(Color.argb(255,137,255,255));
                Thursday.setBackgroundColor(Color.argb(255,137,255,255));
                Friday.setBackgroundColor(Color.argb(255,137,255,255));

                v.setBackgroundColor(Color.WHITE);
                ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
                listItem.clear();
                switch (v.getId()) {
                    case R.id.Monday:

                        for (int i = 0; i < 6; i++) {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("work", "²Ë°ü");
                            map.put("price", "5");
                            listItem.add(map);
                        }

                        break;
                    case R.id.Tuesday:

                        for (int i = 0; i < 6; i++) {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("work", "·¹ÍÅ");
                            map.put("price", "5");
                            listItem.add(map);
                        }
                        break;
                    case R.id.Wednesday:

                        for (int i = 0; i < 6; i++) {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("work", "Êí±ý");
                            map.put("price", "5");
                            listItem.add(map);
                        }
                        break;
                    case R.id.Thursday:

                        for (int i = 0; i < 6; i++) {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("work", "Ð¡Áý°ü");
                            map.put("price", "5");
                            listItem.add(map);
                        }
                        break;
                    case R.id.Friday:

                        for (int i = 0; i < 6; i++) {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("work", "ºì¶¹¸â");
                            map.put("price", "5");
                            listItem.add(map);
                        }
                        break;

                }
                SimpleAdapter adapter = new SimpleAdapter(BookActivity.this,
                        listItem, R.layout.book_item, new String[]{"work", "price"},
                        new int[]{R.id.work, R.id.price});
                lv.setAdapter(adapter);
            }


        };

        Monday.setOnClickListener(listener);
        Tuesday.setOnClickListener(listener);
        Wednesday.setOnClickListener(listener);
        Thursday.setOnClickListener(listener);
        Friday.setOnClickListener(listener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book, menu);
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
