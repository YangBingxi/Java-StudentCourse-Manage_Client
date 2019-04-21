package cn.rain.dao.impl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;

import cn.rain.Exceptions.UserExistedException;
import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.domain.Teacher;
import cn.rain.domain.User;
import cn.rain.utils.ConnectUtil;

/**
 * 数据交互接口实现类
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */
public class UsersDaoImpl implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#find(java.lang.String, java.lang.String, boolean)
	 */

	UserDao dao = ConnectUtil.getDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.impl.UserDao#find(java.lang.String, java.lang.String,
	 * boolean)
	 */
	@Override
	public User find(String username, String password, String permission) {
		return dao.find(username, password, permission);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.impl.UserDao#findStudentBySno(java.lang.String)
	 */
	@Override
	public User findStudentBySno(String sno) {
		return dao.findStudentBySno(sno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.impl.UserDao#findStudentByName(java.lang.String)
	 */
	@Override
	public User findStudentByName(String name) {
		return dao.findStudentByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#findTeacher(java.lang.String)
	 */
	@Override
	public Teacher findTeacher(String username) {

		return dao.findTeacher(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#addUser(cn.rain.domain.User)
	 */
	@Override
	public void addUser(Map<String, Object> map) throws UserExistedException, RemoteException {

		dao.addUser(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#addScores(java.lang.String, java.util.Map, int)
	 */
	@Override
	public boolean addScores(String sno, Map<String, Integer> scores, int term) throws UserNotFoundException {
		return dao.addScores(sno, scores, term);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#findScores(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Map<String, Integer> findScores(String sno, String method, int num) throws UserNotFoundException {
		return dao.findScores(sno, method, num);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#findScore(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Integer> findScore(String sno, String subject) throws UserNotFoundException {

		return dao.findScore(sno, subject);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#sortTable(java.util.Map, boolean)
	 */
	@Override
	public Map<String, Integer> sortTable(Map<String, Integer> map, boolean sortMethod) {
		return dao.sortTable(map, sortMethod);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#getSubjects(java.lang.String)
	 */
	@Override
	public List<String> getSubjects(String sno) {

		return dao.getSubjects(sno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#getAllClass()
	 */
	@Override
	public List<String> getAllClass() {

		return dao.getAllClass();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#getAllsubjectsByClass(java.lang.String)
	 */
	@Override
	public List<String> getAllsubjectsByClass(String schoolClass) {
		return dao.getAllsubjectsByClass(schoolClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#updateScore(java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean updateScore(String sno, String subject, int score) {

		return dao.updateScore(sno, subject, score);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#getSubAttribute(java.lang.String, java.lang.String)
	 */
	@Override
	public Attribute getSubAttribute(String sno, String subject) {

		return dao.getSubAttribute(sno, subject);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#findSubscoresBynum(java.lang.String, int, boolean)
	 */
	@Override
	public Map<String, Integer> findSubscoresBynum(String subject, int num, boolean isHigh)
			throws UserNotFoundException {

		return dao.findSubscoresBynum(subject, num, isHigh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.impl.UserDao#getClassScoresBysub(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Integer> getClassScoresBysub(String schoolClass, String subject) throws UserNotFoundException {

		return dao.getClassScoresBysub(schoolClass, subject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#statistics(java.lang.String, java.lang.String)
	 */
	@Override
	public String[][] statistics(String schoolClass, String subject) throws UserNotFoundException {

		return dao.statistics(schoolClass, subject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#getUsernames()
	 */
	@Override
	public List<String> getUsernames() {

		return dao.getUsernames();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.rain.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String username) {

		dao.deleteUser(username);

	}

	@Override
	public Map<String, String> getAdmin() {
		return dao.getAdmin();
	}
}
