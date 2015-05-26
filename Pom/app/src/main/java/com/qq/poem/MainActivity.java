package com.qq.poem;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

import com.qq.Provider.NotePadUtil;
import com.qq.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .add(R.id.head, new HeadFragment())
                    .add(R.id.footer, new FooterFragment())
                    .commit();
        }

        NotePadUtil.Add(getContentResolver());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main, container, false);
        Button next = (Button) rootView.findViewById(R.id.next);
        next.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this.getActivity(), "Hello", Toast.LENGTH_LONG).show();
       /* Intent intent = new Intent();
        intent.setClass(this.getActivity(), MainActivity2.class);
        startActivity(intent);*/

        //不回退，而退出
        //finish();
    }
}

class FooterFragment extends Fragment implements View.OnClickListener {

    public FooterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.footer, container, false);

        Button ie = (Button) rootView.findViewById(R.id.ie);
        ie.setOnClickListener(this);
        Button chrome = (Button) rootView.findViewById(R.id.chrome);
        chrome.setOnClickListener(this);
        Button firefox = (Button) rootView.findViewById(R.id.firefox);
        firefox.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {

        FragmentManager fragmentManager = this.getActivity().getSupportFragmentManager();

        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.ie:
                fragment = new IEFragment();
                break;
            case R.id.chrome:
                fragment = new ChromeFragment();
                break;
            case R.id.firefox:
                fragment = new FirefoxFragment();
                break;


        }
        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}


class HeadFragment extends Fragment {

    public HeadFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.head, container, false);
        return rootView;
    }
}