package com.itheima.mobilesafe.service;

import java.io.IOException;
import java.io.InputStream;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class GPSService extends Service {
	// �õ�λ�÷���
	private LocationManager lm;
	private MyLocationListener listener;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		lm = (LocationManager) getSystemService(LOCATION_SERVICE);

		// List<String> provider = lm.getAllProviders();
		// for(String l: provider){
		// System.out.println(l);
		// }
		listener = new MyLocationListener();
		// ע�����λ�÷���
		// ��λ���ṩ����������
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);

		// ���ò���ϸ����
		// criteria.setAccuracy(Criteria.ACCURACY_FINE);//����Ϊ��󾫶�
		// criteria.setAltitudeRequired(false);//��Ҫ�󺣰���Ϣ
		// criteria.setBearingRequired(false);//��Ҫ��λ��Ϣ
		// criteria.setCostAllowed(true);//�Ƿ���������
		// criteria.setPowerRequirement(Criteria.POWER_LOW);//�Ե�����Ҫ��

		String proveder = lm.getBestProvider(criteria, true);
		lm.requestLocationUpdates(proveder, 0, 0, listener);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// ȡ������λ�÷���
		lm.removeUpdates(listener);
		listener = null;
	}

	class MyLocationListener implements LocationListener {

		/**
		 * ��λ�øı��ʱ��ص�
		 */

		@Override
		public void onLocationChanged(Location location) {
			String longitude = "j:" + location.getLongitude() + "\n";
			String latitude = "w:" + location.getLatitude() + "\n";
			String accuracy = "a" + location.getAccuracy() + "\n";
			// �����Ÿ���ȫ����

			// �ѱ�׼��GPS����ת���ɻ�������
//			InputStream is;
//			try {
//				is = getAssets().open("axisoffset.dat");
//				ModifyOffset offset = ModifyOffset.getInstance(is);
//				PointDouble double1 = offset.s2c(new PointDouble(location
//						.getLongitude(), location.getLatitude()));
//				longitude ="j:" + offset.X+ "\n";
//				latitude =  "w:" +offset.Y+ "\n";
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
			Editor editor = sp.edit();
			editor.putString("lastlocation", longitude + latitude + accuracy);
			editor.commit();

		}

		/**
		 * ��״̬�����ı��ʱ��ص� ����--�ر� ���ر�--����
		 */
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		/**
		 * ĳһ��λ���ṩ�߿���ʹ����
		 */
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		/**
		 * ĳһ��λ���ṩ�߲�����ʹ����
		 */
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

	}

}