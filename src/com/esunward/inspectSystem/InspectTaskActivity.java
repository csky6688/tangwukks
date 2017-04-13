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
			
			
			//��listView����һ������������Ҫ���������ʼ����ʾ����
			tasklistView.setAdapter(new BaseAdapter() {
				
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					View view = null;
					//���ֲ���
					
					//�������Ϊ�գ����������µĲ�����Ϊ1��item
					if(convertView==null){
						Log.i("info:", "û�л��棬��������"+position);
	                    LayoutInflater inflater = InspectTaskActivity.this.getLayoutInflater();
	                    //��ΪgetView()���صĶ���adapter���Զ�����ListView
	                    view = inflater.inflate(R.layout.list_view_jinspecttask, null);
					}else{
						Log.i("info", "�л��棬����Ҫ��������!"+position);
						view = convertView;
					}
					
					
					Jinspecttask jinspecttask = jinspecttaskList.get(position);
					String taskId = jinspecttask.getId();
					
					System.out.println(taskId);
					
					TextView tv = (TextView) view.findViewById(R.id.taskId);
					tv.setHint(taskId);	////Ϊ����item����һ��idֵ������������ĵ������item�Ĳ�ѯ
				
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
			
			//��ListView��ÿһ��item���ð�ť�ĵ���¼�
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
	 * Ѳ���¼���õķ���
	 * @param view
	 */
	public void showInspectRecord(View view){
		Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ����Ѳ��,����ɨ���ά��
	 */
	public void scanQrCode(View view){
		/*Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);*/
	}
	
	/**
	 * Ѳ������
	 * @param view
	 */
	public void inspectTask(View view){
		Intent intent = new Intent(this,InspectTaskActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ��������
	 * @param view
	 */
	public void centerInfo(View view){
		Intent intent = new Intent(this,CenterActivity.class);
		startActivity(intent);
	}
}
