package com.esunward.javabean;

import java.util.Date;

public class Jinspecttask {
	private String inspectname;		// Ѳ������
	private String inspectorname;		// Ѳ��Աid
	private String inspectdescription;		// Ѳ������
	
	private Date inspectdate;  //Ѳ������
	
	private Date beginWith;         //Ѳ�����ڵĺ�һ��
	private Date deadLine;         //Ѳ�����ڵĺ�һ��
	
	private String isFinish;		//����ֶ�������ʾѲ�������Ƿ��Ѿ���� 1 ���  0δ���
	

	protected String remarks;	// ��ע
	protected Date createDate;	// ��������
	protected Date updateDate;	// ��������
	
	protected String id;   //����id

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInspectname() {
		return inspectname;
	}
	public void setInspectname(String inspectname) {
		this.inspectname = inspectname;
	}
	public String getInspectorname() {
		return inspectorname;
	}
	public void setInspectorname(String inspectorname) {
		this.inspectorname = inspectorname;
	}
	public String getInspectdescription() {
		return inspectdescription;
	}
	public void setInspectdescription(String inspectdescription) {
		this.inspectdescription = inspectdescription;
	}
	public Date getInspectdate() {
		return inspectdate;
	}
	public void setInspectdate(Date inspectdate) {
		this.inspectdate = inspectdate;
	}
	
	public Date getBeginWith() {
		return beginWith;
	}
	public void setBeginWith(Date beginWith) {
		this.beginWith = beginWith;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public String getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
