package com.esunward.inspectSystem;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

/**
 * 基类Activity
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//必须有这样一段代码，因为android4.0以后网络限制
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
		    // 详见StrictMode文档
		    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		            .detectDiskReads().detectDiskWrites().detectNetwork()
		            .penaltyLog().build());
		    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		            .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
		            .penaltyLog().penaltyDeath().build());
		}
	}
	
}
