package com.esunward.inspectSystem;

import java.util.List;

import com.esunward.androidUtil.JsonUtils;
import com.esunward.javabean.Jinspecttask;
import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class InspectTaskActivity extends BaseActivity {
	
	private ListView tasklistView;
	private List<Jinspecttask>jinspecttaskList; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_task);
		
		tasklistView = (ListView) findViewById(R.id.taskListView);
		
		
		
		String jsonStr = (String) getIntent().getExtras().get("jinspecttaskList");
		
		try {
			jinspecttaskList = JsonUtils.jsonStringToList(jsonStr, Jinspecttask.class);
			
			
			//给listView设置一个适配器，主要用于让其初始化显示内容
			tasklistView.setAdapter(new BaseAdapter() {
				
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					View view = null;
					//布局不变
					
					//如果缓存为空，我们生成新的布局作为1个item
					if(convertView==null){
						Log.i("info:", "没有缓存，重新生成"+position);
	                    LayoutInflater inflater = InspectTaskActivity.this.getLayoutInflater();
	                    //因为getView()返回的对象，adapter会自动赋给ListView
	                    view = inflater.inflate(R.layout.list_view_jinspecttask, null);
					}else{
						Log.i("info", "有缓存，不需要重新生成!"+position);
						view = convertView;
					}
					
					
					Jinspecttask jinspecttask = jinspecttaskList.get(position);
					String taskId = jinspecttask.getId();
					
					System.out.println(taskId);
					
					TextView tv = (TextView) view.findViewById(R.id.taskId);
					tv.setHint(taskId);	////为单条item设置一个id值，方便接下来的点击单条item的查询
				
					return view;
				}
				
				@Override
				public long getItemId(int position) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public Object getItem(int position) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return jinspecttaskList.size();
				}
			});
			
			//给ListView的每一个item设置按钮的点击事件
			tasklistView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					TextView tv  = (TextView) view.findViewById(R.id.taskId);
					String taskId = (String) tv.getHint();
					System.out.println(taskId);
				}
				
			});
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
