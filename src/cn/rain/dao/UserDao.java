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
* 数据交互接口
* @author   rain 
* @version 2014-09-10
* @since    JDK1.6
*/ 
public interface UserDao {
	
	/**
	 * 查询用户
	 * @author rain
	 * @param  输入:用户名、密码、权限(String类型)
	 * @return 输出:一个用户(User类)
	 */
	
	User find(String username, String password, String permission);

	
	/**
	 * 查询用户
	 * @author rain
	 * @param 输入:学号(String类型)
	 * @return 输出:一个用户(User类)
	 */
	User findStudentBySno(String sno);
	
	
	/**
	 * 从配置文件中获取管理员信息
	 * @author rain
	 * @param 输入:无
	 * @return 输出:Map<String, String> 包含管理员的用户名和密码信息
	 */
	Map<String, String> getAdmin();

	
	/**
	 * 查询学生
	 * @author rain
	 * @param 输入:姓名(String类型)
	 * @return 输出:一个用户(User类)
	 */
	User findStudentByName(String name);

	/**
	 * 查询教师
	 * @author rain
	 * @param 输入:用户名(String类型)
	 * @return 输出:一个用户(Teacher类)
	 */
	Teacher findTeacher(String username);

	/**
	 * 添加用户
	 * @author rain 
	 * @param Map<String, Object> map 包含用户信息的Map
	 * @return 
	 */
	void addUser(Map<String, Object> map) throws UserExistedException, RemoteException;

	/**
	 * 添加分数集
	 * @author rain
	 * @param 学号(String) 课程和分数集(Map) 学期(int)
	 * @return boolean 是否添加成功
	 */
	boolean addScores(String sno, Map<String, Integer> scores, int term)
			throws UserNotFoundException;

	/**
	 * 查询分数集
	 * @author rain
	 * @param 学号(String)、查询方法，即按学期或者按学年查询(String)、 指定学期或学年(int)
	 * @return 课程与分数的集合Map<String, Integer>
	 */
	Map<String, Integer> findScores(String sno, String method, int num)
			throws UserNotFoundException;

	/**
	 * 查询指定学号与课程的分数
	 * @author rain
	 * @param 学号（String）、课程（String）
	 * @return 课程和对应的分数（Map<String, Integer>）
	 */
	Map<String, Integer> findScore(String sno, String subject)
			throws UserNotFoundException;

	/**
	 * 对列表内容进行排序
	 * @author rain
	 * @param 包含列表信息的Map（Map<String, Integer> map）排序方式，从高到低或者从低到高（boolean sortMethod）
	 * @return 包含排序后列表信息的Map<String, Integer>
	 */
	Map<String, Integer> sortTable(Map<String, Integer> map, boolean sortMethod);

	/**
	 * 获取所有课程
	 * @author rain
	 * @param 学号（String）
	 * @return 所有课程的名称列表（List<String>）
	 */
	List<String> getSubjects(String sno);

	/**
	 * 获取所有班级
	 * @author rain
	 * @param 
	 * @return 所有班级的列表（List<String>）
	 */
	List<String> getAllClass();

	/**
	 * 获取指定班级的所有课程
	 * @author rain
	 * @param 指定班级（String schoolClass）
	 * @return 指定班级的课程的列表（List<String>）
	 */
	List<String> getAllsubjectsByClass(String schoolClass);

	/**
	 * 修改指定学生指定课程的分数
	 * @author rain
	 * @param 学号（String sno）课程（String subject）分数（int score）
	 * @return 修改是否成功（boolean）
	 */
	boolean updateScore(String sno, String subject, int score);

	Attribute getSubAttribute(String sno, String subject);

	/**
	 * 查找指定课程高于（或低于）指定分数集合
	 * @author rain
	 * @param 课程名称（String subject）、指定分数（int num）、查询方式，即高于或低于指定分数（boolean isHigh）
	 * @return 查询结果集合，包含符合条件的学生学号和成绩（Map<String, Integer> ）
	 */
	Map<String, Integer> findSubscoresBynum(String subject, int num,
			boolean isHigh) throws UserNotFoundException;
	
	/**
	 * 查找指定班级所有学生的指定课程的成绩
	 * @author rain
	 * @param 班级名称（String schoolClass） 课程名称（String subject）
	 * @return 查询结果集合，包含符合条件的学生的成绩（List<Integer> ）
	 */
	List<Integer> getClassScoresBysub(String schoolClass, String subject)
			throws UserNotFoundException;

	/**
	 * 统计指定班级指定科目的成绩分布情况
	 * @author rain
	 * @param 
	 * @return 成绩分布情况集合（String[][]）
	 */
	String[][] statistics(String schoolClass, String subject)
			throws UserNotFoundException;

	/**
	 * 获取所有用户的用户名
	 * @author rain
	 * @param 
	 * @return 所有用户的用户名集合（List<String>）
	 */
	List<String> getUsernames();

	/**
	 * 通过用户名删除指定用户
	 * @author rain
	 * @param 用户名（String username）
	 * @return 
	 */
	void deleteUser(String username);
}