package cn.rain.Exceptions;

/** 
* �û��Ѵ���ʱ�׳����쳣 
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/ 

public class UserExistedException extends Exception {

	private static final long serialVersionUID = 2958039873765717022L;

	public UserExistedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExistedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExistedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
