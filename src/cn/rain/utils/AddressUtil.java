package cn.rain.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 获取ip和端口的工具类
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class AddressUtil {
	private static String IP;// ip地址
	private static String PORT;// 端口号

	static {
		/**
		 * 获取当前jar包所在路径
		 */
		URL url = new AddressUtil().getClass().getProtectionDomain().getCodeSource().getLocation();
		String realPath = url.getPath();
		int i = realPath.lastIndexOf("/");
		realPath = realPath.substring(0, i + 1);

		/**
		 * 建立输入流
		 */
		InputStream in = null;
		try {
			in = new FileInputStream(realPath + "Address.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		/**
		 * 从配置文件中读取ip地址和端口号
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
	 * @return IP地址(String)
	 */
	public static String getIP() {
		return IP;
	}

	/**
	 * @author rain
	 * @return 端口号(String)
	 */
	public static String getPort() {
		return PORT;
	}

}
