package cn.rain.Exceptions;

/** 
* �Ҳ�����Ӧ�û�ʱ�׳����쳣
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/ 

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 5907455614219507774L;

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super();
		// TODO Auto-generated constructor stub
	}

}
