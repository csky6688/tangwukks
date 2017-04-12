package com.esunward.inspectSystem;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.itheima.mobilesafe.R;

public class DetailActivity extends BaseActivity   {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tangwu_detail);

        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view
        tabHost.addTab(tabHost.newTabSpec("view1")
                .setIndicator("设备日志").setContent(R.id.myinclude1));
        tabHost.addTab(tabHost.newTabSpec("view2")
        		.setIndicator("设备信息").setContent(R.id.myinclude2));
        
    }


}
