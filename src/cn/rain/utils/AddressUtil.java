package cn.rain.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/** 
* ��ȡip�Ͷ˿ڵĹ�����
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/

public class AddressUtil {
	private static String IP;//ip��ַ
	private static String PORT;//�˿ں�
	
	static {
		/**
		 * ��ȡ��ǰjar������·��
		 */
		URL url = new AddressUtil().getClass().getProtectionDomain().getCodeSource().getLocation();
		String realPath = url.getPath();
		int i = realPath.lastIndexOf("/");
		realPath = realPath.substring(0,i+1);
		
		/**
		 * ����������
		 */
		InputStream in = null;
		try {
			in = new FileInputStream(realPath+"Address.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		/**
		 * �������ļ��ж�ȡip��ַ�Ͷ˿ں�
		 */
		Properties properties = new Properties();
		try {
			properties.load(in);
			IP = properties.getProperty("ip");
			PORT = properties.getProperty("port");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author rain
	 * @return IP��ַ(String)
	 */
	public static String getIP() {
		return IP;
	}

	/**
	 * @author rain
	 * @return �˿ں�(String)
	 */
	public static String getPort() {
		return PORT;
	}

}
