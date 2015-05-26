package com.qq.jh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.qq.R;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

public class MainActivity extends Activity {

    private Context mContext;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        Parameters params = new Parameters();
        params.add("lon", "121.538123");
        params.add("lat", "31.677132");
        params.add("key", "ee59bb10b042d8380ed7f052e04b308f");


        JuheData.executeWithAPI(mContext, 7, "http://apis.juhe.cn/oil/local",
                JuheData.GET, params, new DataCallBack() {

                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        tv.append(responseString + "\n");
                    }


                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(), "finish",
                                Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onFailure(int statusCode,
                                          String responseString, Throwable throwable) {
                        // TODO Auto-generated method stub
                        tv.append(throwable.getMessage() + "\n");
                    }
                });

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        JuheData.cancelRequests(mContext);
    }

}
