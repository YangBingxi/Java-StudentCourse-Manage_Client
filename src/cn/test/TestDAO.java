package cn.test;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import cn.rain.Exceptions.UserExistedException;
import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;
import cn.rain.domain.Teacher;

/** 
* ���Թ��ܵ���
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/

public class TestDAO {

	@Test
	public void testAdd() {
		UserDao dao = new UsersDaoImpl();
	
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("username", "rain");
		map.put("password", "rain");
		map.put("sno", "3113004681");
		map.put("name", "С��");
		map.put("gender", "��");
		map.put("birthday", new Date());
		map.put("schoolClass", "�Ź�һ��");

		
		Teacher teacher = new Teacher();
		teacher.setName("������");
		teacher.setUsername("001");
		teacher.setPassword("001");
		try {
			dao.addUser(map);
		} catch (UserExistedException e) {
			System.out.println("�û��Ѵ��ڣ�");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.findStudentBySno("3113004681").getUsername());
	}

	@Test
	public void testAddScores() {
		UserDao dao = new UsersDaoImpl();
		Map<String, Integer> scores = new LinkedHashMap<String, Integer>();
		scores.put("����", 80);
		scores.put("ְҵ�滮", 80);
		scores.put("ѡ��1", 85);
		try {
			dao.addScores("3113004677", scores, 2);
		} catch (UserNotFoundException e) {
			System.out.println("û�����ѧ����");
		}
	}

	@Test
	public void testFindScores() {
		UserDao dao = new UsersDaoImpl();
		try {
			Map<String, Integer> map = dao.findScores("3113004681", "term", 3);
			System.out.println(map);
		} catch (UserNotFoundException e) {
			System.out.println("û�����ѧ��");
		}
	}
	
	
	@Test
	public void testGetSbujects(){
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getSubjects("3113004681"));
	}
	
	@Test
	public void testUpdateScores(){
		UserDao dao = new UsersDaoImpl();
		dao.updateScore("3113004681", "����", 20);
	}
	
	@Test
	public void testGetAllsubByClass(){
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getAllsubjectsByClass("�Ź�һ��"));
	}
	
	@Test
	public void testGetUsernames(){
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getUsernames());
	}
	
	@Test
	public void testDeleteUser(){
		UserDao dao = new UsersDaoImpl();
		dao.deleteUser("cc");
	}
}
