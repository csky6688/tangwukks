package com.esunward.inspectSystem;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;

import com.esunward.androidUtil.HttpUtil;
import com.esunward.androidUtil.JsonUtils;
import com.esunward.config.Global;
import com.esunward.javabean.Jinspecttask;
import com.esunward.javabean.User;
import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class CenterActivity extends BaseActivity {
private ImageView personface;  //��ͷ���ͼƬ
	
	private TextView loginUser_name_tv;
	private TextView loginUser_no;
	private TextView loginUser_phone;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		User user = (User) getIntent().getExtras().get("loginUser");
		
		setContentView(R.layout.activity_tangwu_ceter);
		personface = (ImageView)findViewById(R.id.personface);
		
		loginUser_name_tv = (TextView) findViewById(R.id.loginUser_name);
		loginUser_no = (TextView) findViewById(R.id.loginUser_no);
		loginUser_phone = (TextView) findViewById(R.id.loginUser_phone);
		
		loginUser_name_tv.setText(user.getName());
		loginUser_no.setText(user.getNo());
		loginUser_phone.setText(user.getPhone());
	}
	
	/**
	 * �޸��û���Ϣ�Ľ���
	 * @param view
	 */
	public void editInfo(View view){
		Intent intent = new Intent(CenterActivity.this,EditInfoActivity.class);
		startActivity(intent);
	}
	
	/**
	 * �޸��û�����Ľ���
	 * @param view
	 */
	public void modifyPassword(View view){
		Intent intent = new Intent(CenterActivity.this,ModifyPasswordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * �˳��ʺŵ��õķ���
	 * @param view
	 */
	public void logout(View view){
		Intent intent = new Intent(CenterActivity.this,ModifyPasswordActivity.class);
		startActivity(intent);
	}
	
	
	/**
	 * Ѳ���¼���õķ���
	 * @param view
	 */
	public void showInspectRecord(View view){
		Intent intent = new Intent(CenterActivity.this,InspectRecordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ����Ѳ��,����ɨ���ά��
	 */
	public void scanQrCode(View view){
		/*Intent intent = new Intent(CenterActivity.this,InspectRecordActivity.class);
		startActivity(intent);*/
	}
	
	/**
	 * Ѳ������
	 * @param view
	 */
	public void inspectTask(View view){
		new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					/*String jsonStr = "{'username':'"+username+"','password':'"+password+"'}";
					
					String encodeJsonStr = URLEncoder.encode(jsonStr,"UTF-8");
					*/
					SharedPreferences preference=getSharedPreferences("tangwukks", Context.MODE_PRIVATE);
					String userJson = preference.getString("loginUser", "");
					
					User user = JsonUtils.jsonStringToEntity(userJson, User.class);
							
					String responseJson = HttpUtil.androidHttpGetRequest("http://"+Global.connectionUrlLocation+"/jeeplus/mobille/showInspectorTask?userId="+user.getId());
					
					String responseJsonStr =  URLDecoder.decode(responseJson, "UTF-8");
					

					System.out.println(responseJsonStr);
					
					
					List<Jinspecttask> jinspecttaskList = JsonUtils.jsonStringToList(responseJsonStr, Jinspecttask.class);
					
					for(Jinspecttask jinspecttask:jinspecttaskList){
						System.out.println(jinspecttask.getInspectdescription()+"   "+jinspecttask.getInspectorname());
					}
					
					Intent intent = new Intent(CenterActivity.this,InspectTaskActivity.class);
					intent.putExtra("jinspecttaskList", responseJsonStr);
					startActivity(intent);
					
					/*
					String userJson = new JSONObject(new JSONObject(responseJson).get("data").toString()).toString();
					
					user = JsonUtils.jsonStringToEntity(userJson, User.class);
										
					Editor editor = sharedPreference.edit();
					editor.putString("loginUser", userJson);
					*/
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
		
		
	}
	
	/**
	 * ��������
	 * @param view
	 */
	/*public void centerInfo(View view){
		Intent intent = new Intent(CenterActivity.this,CenterActivity.class);
		startActivity(intent);
	}*/
	
}
