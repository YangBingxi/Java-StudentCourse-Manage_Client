package cn.rain.utils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.rain.dao.UserDao;

/** 
* ���ӷ������Ĺ�����
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/

public class ConnectUtil {
	/**
	 * ��rmiԶ�̷����ӿ��л��һ��UserDao��
	 * @author rain
	 * @return UserDao
	 */
	public static UserDao getDao(){
		UserDao dao = null ;
		try {
			String ip = AddressUtil.getIP();
			String port = AddressUtil.getPort();
			dao =(UserDao) Naming.lookup("rmi://"+ip+":"+port+"/Dao");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return dao;
	}
}
