package com.esunward.inspectSystem;

import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 扫描设备信息出来的界面
 * @author Administrator
 *
 */
public class ScanEquipInfoActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_scaninfo);
		
	}
	
	//设备正常
	public void equipmentNormal(View view){
		//Intent intent = new Intent(LoginActivity.this,CenterActivity.class);
		//startActivity(intent);
		//HttpUtil.androidHttpPostRequest();
		/*Toast.makeText(LoginActivity.this, "我想要登录系统", 0).show();
		Intent intent = new Intent(LoginActivity.this,CenterActivity.class);
		startActivity(intent);
		*/
	}
	
	
	//设备异常
	public void equipmentAbnormal(View view){
		Intent intent = new Intent(ScanEquipInfoActivity.this,AbnormalFormActivity.class);
		startActivity(intent);
	}
}
