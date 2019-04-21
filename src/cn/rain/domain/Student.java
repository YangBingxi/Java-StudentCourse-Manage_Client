package cn.rain.domain;

import java.util.Date;
import java.util.Map;

/**
 * 学生用户实体
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Student implements User {

	private String username;// 用户名
	private String password;// 密码
	private String permission = "学生";// 用户权限为“学生”

	private String sno;// 学号
	private String name;// 姓名
	private String gender;// 性别
	private Date birthday;// 出生日期
	private Map<String, Integer> scores;// 分数集合
	private String schoolClass;// 班级

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
