package cn.rain.domain;

import java.util.Date;
import java.util.Map;

/**
 * ѧ���û�ʵ��
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Student implements User {

	private String username;// �û���
	private String password;// ����
	private String permission = "ѧ��";// �û�Ȩ��Ϊ��ѧ����

	private String sno;// ѧ��
	private String name;// ����
	private String gender;// �Ա�
	private Date birthday;// ��������
	private Map<String, Integer> scores;// ��������
	private String schoolClass;// �༶

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setUsername(java.lang.String)
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#isPermission()
	 */
	@Override
	public String isPermission() {
		return permission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setPermission(boolean)
	 */
	@Override
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getSno()
	 */
	@Override
	public String getSno() {
		return sno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setSno(java.lang.String)
	 */
	@Override
	public void setSno(String sno) {
		this.sno = sno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getGender()
	 */
	@Override
	public String getGender() {
		return gender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setGender(java.lang.String)
	 */
	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getBirthday()
	 */
	@Override
	public Date getBirthday() {
		return birthday;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setBirthday(java.util.Date)
	 */
	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getScores()
	 */
	@Override
	public Map<String, Integer> getScores() {
		return scores;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setScores(java.util.Map)
	 */
	@Override
	public void setScores(Map<String, Integer> scores) {
		this.scores = scores;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#getSchoolClass()
	 */
	@Override
	public String getSchoolClass() {
		return schoolClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.domain.User#setSchoolClass(java.lang.String)
	 */
	@Override
	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

}
