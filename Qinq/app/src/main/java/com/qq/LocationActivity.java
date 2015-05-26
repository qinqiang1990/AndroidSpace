package com.qq;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.BDGeofence;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.location.GeofenceClient;
import com.baidu.location.GeofenceClient.OnAddBDGeofencesResultListener;
import com.baidu.location.GeofenceClient.OnGeofenceTriggerListener;
import com.baidu.location.GeofenceClient.OnRemoveBDGeofencesResultListener;
import com.baidu.mapapi.map.MyLocationData;

public class LocationActivity extends ActionBarActivity {

    MapView mMapView = null;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    public BaiduMap baiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mMapView.getMap();

        mLocationClient = new LocationClient(getApplicationContext());     //����LocationClient��
        mLocationClient.registerLocationListener(myListener);    //ע���������

        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//���ö�λģʽ
        option.setCoorType("bd09ll");//���صĶ�λ����ǰٶȾ�γ��,Ĭ��ֵgcj02
        option.setScanSpan(5000);//���÷���λ����ļ��ʱ��Ϊ5000ms
        option.setIsNeedAddress(true);//���صĶ�λ���������ַ��Ϣ
        option.setNeedDeviceDirect(true);//���صĶ�λ��������ֻ���ͷ�ķ���
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mLocationClient.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
        mLocationClient.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }


    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null)
                return;
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
            }

            Toast.makeText(LocationActivity.this, sb.toString(), Toast.LENGTH_LONG).show();

            MyLocationData data = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    .direction(location.getDirection())
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            baiduMap.setMyLocationData(data);
        }
    }
}