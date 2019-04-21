package cn.rain.Exceptions;

/**
 * 找不到相应用户时抛出此异常
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
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

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super();
		// TODO Auto-generated constructor stub
	}

}
