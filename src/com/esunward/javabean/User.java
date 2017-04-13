package com.esunward.javabean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class User implements Serializable{

	private static final long serialVersionUID = -1431796706884619158L;
	
	private String loginName;// ��¼��
/*	private String password;// ����
*/	private String no;		// ����
	private String name;	// ����
	private String email;	// ����
	private String wechatnum;   //΢���˺�
	private String qq;   //qq�˺�
	private String phone;	// �绰
	private String mobile;	// �ֻ�
	private String userType;// �û�����
	private String loginIp;	// ����½IP
	private Date loginDate;	// ����½����
	private String loginFlag;	// �Ƿ������½
	private String photo;	// ͷ��
	private String qrCode;	//��ά��
	private String oldLoginName;// ԭ��¼��
	private String newPassword;	// ������
	private String sign;//ǩ��
	
	private String oldLoginIp;	// �ϴε�½IP
	private Date oldLoginDate;	// �ϴε�½����
	
	private String flag;  //���״̬�������ж�Ѳ��Ա�Ƿ񱻷�����Ѳ������
	
	
	
	protected String id;   //��ǰ�û�id
	protected String remarks;	// ��ע
	protected Date createDate;	// ��������
	protected Date updateDate;	// ��������

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatnum() {
		return wechatnum;
	}

	public void setWechatnum(String wechatnum) {
		this.wechatnum = wechatnum;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOldLoginIp() {
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	public Date getOldLoginDate() {
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	
}

