package cn.rain.domain;

import java.util.Date;
import java.util.Map;

public class Teacher implements User {
	
	/** 
	* ��ʦ�û�ʵ��
	* @author  rain 
	* @version 2014-09-10
	* @since   JDK1.6
	*/ 
	
	private String name;//����
	private String username;//�û���
	private String password;//����
	private String permission = "��ʦ";//�û�Ȩ��Ϊ����ʦ��

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String getSno() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSno(String sno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBirthday(Date birthday) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Integer> getScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScores(Map<String, Integer> scores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSchoolClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchoolClass(String schoolClass) {
		// TODO Auto-generated method stub
		
	}
}
