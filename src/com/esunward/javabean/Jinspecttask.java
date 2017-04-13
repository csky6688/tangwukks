package com.esunward.javabean;

import java.util.Date;

public class Jinspecttask {
	private String inspectname;		// 巡检名称
	private String inspectorname;		// 巡检员id
	private String inspectdescription;		// 巡检内容
	
	private Date inspectdate;  //巡检日期
	
	private Date beginWith;         //巡检日期的后一天
	private Date deadLine;         //巡检日期的后一天
	
	private String isFinish;		//这个字段用于显示巡检任务是否已经完成 1 完成  0未完成
	

	protected String remarks;	// 备注
	protected Date createDate;	// 创建日期
	protected Date updateDate;	// 更新日期
	
	protected String id;   //主键id

	
	
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
