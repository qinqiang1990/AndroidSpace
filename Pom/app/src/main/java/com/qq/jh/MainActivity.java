package com.qq.jh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
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
        tv = (TextView) findViewById(R.id.tv);

        /**
         * �벻Ҫ���key����.
         */
        Parameters params = new Parameters();
        params.add("lon", "121.538123");
        params.add("lat", "31.677132");
        params.add("key", "ee59bb10b042d8380ed7f052e04b308f");

        /**
         * ����ķ��� ����: ��һ������ ��ǰ�����context;
         * 				  �ڶ������� �ӿ�id;
         * 				  ��������� �ӿ������url;
         * 				  ���ĸ����� �ӿ�����ķ�ʽ;
         * 				  ��������� �ӿ�����Ĳ���,��ֵ��com.thinkland.sdk.android.Parameters����;
         * 				  �������������Ļص�����,com.thinkland.sdk.android.DataCallBack;
         *
         */
        JuheData.executeWithAPI(mContext, 7, "http://apis.juhe.cn/oil/local",
                JuheData.GET, params, new DataCallBack() {
                    /**
                     * ����ɹ�ʱ���õķ��� statusCodeΪhttp״̬��,responseStringΪ���󷵻����.
                     */
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        tv.append(responseString + "\n");
                    }

                    /**
                     * �������ʱ���õķ���,���۳ɹ�����ʧ�ܶ������.
                     */
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(), "finish",
                                Toast.LENGTH_SHORT).show();
                    }

                    /**
                     * ����ʧ��ʱ���õķ���,statusCodeΪhttp״̬��,throwableΪ���񵽵��쳣
                     * statusCode:30002 û�м�⵽��ǰ����.
                     * 			  30003 û�н��г�ʼ��.
                     * 			  0 δ���쳣,����鿴Throwable��Ϣ.
                     * 			  �����쳣�����http״̬��.
                     */
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
        /**
         * �رյ�ǰҳ�����ڽ����е�����.
         */
        JuheData.cancelRequests(mContext);
    }

}
