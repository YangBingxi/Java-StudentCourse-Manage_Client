package cn.rain.utils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.rain.dao.UserDao;

/**
 * 连接服务器的工具类
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class ConnectUtil {
	/**
	 * 从rmi远程方法接口中获得一个UserDao类
	 * 
	 * @author rain
	 * @return UserDao
	 */
	public static UserDao getDao() {
		UserDao dao = null;
		try {
			String ip = AddressUtil.getIP();
			String port = AddressUtil.getPort();
			dao = (UserDao) Naming.lookup("rmi://" + ip + ":" + port + "/Dao");
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
