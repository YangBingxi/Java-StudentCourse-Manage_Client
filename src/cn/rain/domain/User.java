package cn.rain.domain;

import java.util.Date;
import java.util.Map;

/** 
* 用户类接口
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/ 

public interface User {

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	String isPermission();

	void setPermission(String permission);

	String getSno();

	void setSno(String sno);

	String getName();

	void setName(String name);

	String getGender();

	void setGender(String gender);

	Date getBirthday();

	void setBirthday(Date birthday);

	Map<String, Integer> getScores();

	void setScores(Map<String, Integer> scores);

	String getSchoolClass();

	void setSchoolClass(String schoolClass);

}