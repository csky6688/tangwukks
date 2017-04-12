package com.esunward.inspectSystem;

import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InspectRecordActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_record);
		//personface = (ImageView)findViewById(R.id.personface);
		
	}
	
	
	/**
	 * 巡检记录调用的方法
	 * @param view
	 */
	public void showInspectRecord(View view){
		Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 立即巡检,调用扫描二维码
	 */
	public void scanQrCode(View view){
		/*Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);*/
	}
	
	/**
	 * 巡检任务
	 * @param view
	 */
	public void inspectTask(View view){
		Intent intent = new Intent(this,InspectTaskActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 个人中心
	 * @param view
	 */
	public void centerInfo(View view){
		Intent intent = new Intent(this,CenterActivity.class);
		startActivity(intent);
	}
}
