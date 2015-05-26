package com.qq.Imageview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qq.Density.DensityUtil;
import com.qq.Progress.AnimActivity;
import com.qq.login.ItemListActivity;
import com.qq.login.LoginActivity;
import com.qq.R;

public class RgActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);
        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) RgActivity.this.findViewById(radioButtonId);
                Toast.makeText(RgActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        /*

        DisplayMetrics dm = DensityUtil.getDisplay(RgActivity.this);
        CustomDialog customDialog = new CustomDialog(this, R.layout.dialog_layout, R.style.DialogTheme, new CustomDialog.OnCustomDialogListener() {
            @Override
            public void back(CustomDialog dialog) {

            }
        });*/
        //customDialog.setCancelable(false);
        //customDialog.show();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics dm = DensityUtil.getDisplay(RgActivity.this);
                Toast.makeText(RgActivity.this, dm.heightPixels + "|" + dm.widthPixels, Toast.LENGTH_SHORT).show();
                Intent intent;
                switch (v.getId()) {
                    case R.id.bt1:
                        // Uri.parse("tel:10010")
                        intent = new Intent(Intent.ACTION_EDIT, null);
                        startActivity(intent);
                        break;
                    case R.id.bt2:
                        // Uri.parse("tel:10010")
                        intent = new Intent(RgActivity.this, AnimActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.bt3:
                        intent = new Intent(RgActivity.this, ItemListActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(listener);
        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(listener);
        Button bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(listener);
    }


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
