package cn.rain.Exceptions;

/**
 * 用户已存在时抛出此异常
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class UserExistedException extends Exception {

	private static final long serialVersionUID = 2958039873765717022L;

	public UserExistedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExistedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
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
