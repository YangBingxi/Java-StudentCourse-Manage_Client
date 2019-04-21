package cn.rain.dao;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;

import cn.rain.Exceptions.UserExistedException;
import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.domain.Teacher;
import cn.rain.domain.User;

/** 
* ���ݽ����ӿ�
* @author   rain 
* @version 2014-09-10
* @since    JDK1.6
*/ 
public interface UserDao {
	
	/**
	 * ��ѯ�û�
	 * @author rain
	 * @param  ����:�û��������롢Ȩ��(String����)
	 * @return ���:һ���û�(User��)
	 */
	
	User find(String username, String password, String permission);

	
	/**
	 * ��ѯ�û�
	 * @author rain
	 * @param ����:ѧ��(String����)
	 * @return ���:һ���û�(User��)
	 */
	User findStudentBySno(String sno);
	
	
	/**
	 * �������ļ��л�ȡ����Ա��Ϣ
	 * @author rain
	 * @param ����:��
	 * @return ���:Map<String, String> ��������Ա���û�����������Ϣ
	 */
	Map<String, String> getAdmin();

	
	/**
	 * ��ѯѧ��
	 * @author rain
	 * @param ����:����(String����)
	 * @return ���:һ���û�(User��)
	 */
	User findStudentByName(String name);

	/**
	 * ��ѯ��ʦ
	 * @author rain
	 * @param ����:�û���(String����)
	 * @return ���:һ���û�(Teacher��)
	 */
	Teacher findTeacher(String username);

	/**
	 * ����û�
	 * @author rain 
	 * @param Map<String, Object> map �����û���Ϣ��Map
	 * @return 
	 */
	void addUser(Map<String, Object> map) throws UserExistedException, RemoteException;

	/**
	 * ��ӷ�����
	 * @author rain
	 * @param ѧ��(String) �γ̺ͷ�����(Map) ѧ��(int)
	 * @return boolean �Ƿ���ӳɹ�
	 */
	boolean addScores(String sno, Map<String, Integer> scores, int term)
			throws UserNotFoundException;

	/**
	 * ��ѯ������
	 * @author rain
	 * @param ѧ��(String)����ѯ����������ѧ�ڻ��߰�ѧ���ѯ(String)�� ָ��ѧ�ڻ�ѧ��(int)
	 * @return �γ�������ļ���Map<String, Integer>
	 */
	Map<String, Integer> findScores(String sno, String method, int num)
			throws UserNotFoundException;

	/**
	 * ��ѯָ��ѧ����γ̵ķ���
	 * @author rain
	 * @param ѧ�ţ�String�����γ̣�String��
	 * @return �γ̺Ͷ�Ӧ�ķ�����Map<String, Integer>��
	 */
	Map<String, Integer> findScore(String sno, String subject)
			throws UserNotFoundException;

	/**
	 * ���б����ݽ�������
	 * @author rain
	 * @param �����б���Ϣ��Map��Map<String, Integer> map������ʽ���Ӹߵ��ͻ��ߴӵ͵��ߣ�boolean sortMethod��
	 * @return ����������б���Ϣ��Map<String, Integer>
	 */
	Map<String, Integer> sortTable(Map<String, Integer> map, boolean sortMethod);

	/**
	 * ��ȡ���пγ�
	 * @author rain
	 * @param ѧ�ţ�String��
	 * @return ���пγ̵������б�List<String>��
	 */
	List<String> getSubjects(String sno);

	/**
	 * ��ȡ���а༶
	 * @author rain
	 * @param 
	 * @return ���а༶���б�List<String>��
	 */
	List<String> getAllClass();

	/**
	 * ��ȡָ���༶�����пγ�
	 * @author rain
	 * @param ָ���༶��String schoolClass��
	 * @return ָ���༶�Ŀγ̵��б�List<String>��
	 */
	List<String> getAllsubjectsByClass(String schoolClass);

	/**
	 * �޸�ָ��ѧ��ָ���γ̵ķ���
	 * @author rain
	 * @param ѧ�ţ�String sno���γ̣�String subject��������int score��
	 * @return �޸��Ƿ�ɹ���boolean��
	 */
	boolean updateScore(String sno, String subject, int score);

	Attribute getSubAttribute(String sno, String subject);

	/**
	 * ����ָ���γ̸��ڣ�����ڣ�ָ����������
	 * @author rain
	 * @param �γ����ƣ�String subject����ָ��������int num������ѯ��ʽ�������ڻ����ָ��������boolean isHigh��
	 * @return ��ѯ������ϣ���������������ѧ��ѧ�źͳɼ���Map<String, Integer> ��
	 */
	Map<String, Integer> findSubscoresBynum(String subject, int num,
			boolean isHigh) throws UserNotFoundException;
	
	/**
	 * ����ָ���༶����ѧ����ָ���γ̵ĳɼ�
	 * @author rain
	 * @param �༶���ƣ�String schoolClass�� �γ����ƣ�String subject��
	 * @return ��ѯ������ϣ���������������ѧ���ĳɼ���List<Integer> ��
	 */
	List<Integer> getClassScoresBysub(String schoolClass, String subject)
			throws UserNotFoundException;

	/**
	 * ͳ��ָ���༶ָ����Ŀ�ĳɼ��ֲ����
	 * @author rain
	 * @param 
	 * @return �ɼ��ֲ�������ϣ�String[][]��
	 */
	String[][] statistics(String schoolClass, String subject)
			throws UserNotFoundException;

	/**
	 * ��ȡ�����û����û���
	 * @author rain
	 * @param 
	 * @return �����û����û������ϣ�List<String>��
	 */
	List<String> getUsernames();

	/**
	 * ͨ���û���ɾ��ָ���û�
	 * @author rain
	 * @param �û�����String username��
	 * @return 
	 */
	void deleteUser(String username);
}