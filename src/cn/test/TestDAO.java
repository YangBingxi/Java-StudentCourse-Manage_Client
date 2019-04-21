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
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class TestDAO {

	@Test
	public void testAdd() {
		UserDao dao = new UsersDaoImpl();

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("username", "SwYoung");
		map.put("password", "2020");
		map.put("sno", "B16012321");
		map.put("name", "�����");
		map.put("gender", "��");
		map.put("birthday", new Date());
		map.put("schoolClass", "��Ϣ����23��");

		Teacher teacher = new Teacher();
		teacher.setName("����");
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
		System.out.println(dao.findStudentBySno("B16012321").getUsername());
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
			Map<String, Integer> map = dao.findScores("B16012321", "term", 3);
			System.out.println(map);
		} catch (UserNotFoundException e) {
			System.out.println("û�����ѧ��");
		}
	}

	@Test
	public void testGetSbujects() {
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getSubjects("B16012321"));
	}

	@Test
	public void testUpdateScores() {
		UserDao dao = new UsersDaoImpl();
		dao.updateScore("B16012321", "����", 20);
	}

	@Test
	public void testGetAllsubByClass() {
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getAllsubjectsByClass("��Ϣ����23��"));
	}

	@Test
	public void testGetUsernames() {
		UserDao dao = new UsersDaoImpl();
		System.out.println(dao.getUsernames());
	}

	@Test
	public void testDeleteUser() {
		UserDao dao = new UsersDaoImpl();
		dao.deleteUser("cc");
	}
}
