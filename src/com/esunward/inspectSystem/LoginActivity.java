package com.esunward.inspectSystem;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.esunward.androidUtil.HttpUtil;
import com.esunward.androidUtil.JsonUtils;
import com.esunward.config.Global;
import com.esunward.javabean.User;
import com.itheima.mobilesafe.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("NewApi")
public class LoginActivity extends BaseActivity {
	
	protected TextView input_username = null;
	protected TextView input_password = null;
	
	private Context context;
	
	// 用来保存参数的接口    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_login);
		
		input_username = (TextView) findViewById(R.id.input_username);
		input_password = (TextView) findViewById(R.id.input_password);
	
		
		/*if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
		    // 详见StrictMode文档
		    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		            .detectDiskReads().detectDiskWrites().detectNetwork()
		            .penaltyLog().build());
		    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		            .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
		            .penaltyLog().penaltyDeath().build());
		}*/
	}

	public void loginToSystem(View view){
		final String username = input_username.getText().toString();
		final String password = input_password.getText().toString();
		
		//HttpUtil.androidHttpGetRequest("http://127.0.0.1:8080/jeeplus/mobille/phoneLogin?username=aaa&password=123456");   //,"{'username':'xxxxx','password':'233123'}");
		
		// Android 4.0 之后不能在主线程中请求HTTP请求            
		new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					/*String jsonStr = "{'username':'"+username+"','password':'"+password+"'}";
					
					String encodeJsonStr = URLEncoder.encode(jsonStr,"UTF-8");
					*/
					String responseJson = HttpUtil.androidHttpGetRequest("http://"+Global.connectionUrlLocation+"/jeeplus/mobille/phoneLogin?username="+username+"&password="+password);
					
					String userJson = new JSONObject(new JSONObject(responseJson).get("data").toString()).toString();
					
					User user = JsonUtils.jsonStringToEntity(userJson, User.class);
										
					Editor editor = getSharedPreferences("tangwukks", Context.MODE_PRIVATE).edit();
					editor.putString("loginUser", userJson);
					editor.commit();
					
					Intent intent = new Intent(LoginActivity.this,CenterActivity.class);
					intent.putExtra("loginUser", user);
					startActivity(intent);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
		
		//System.out.println("主线程中不能访问网络!");
	}
	
}
