package com.mphasis.ams.login.exception;
/**
 * @author Hamza.Khan
 *
 */
public class ServiceException extends BusinessException {

	public ServiceException()
	{
		super(DEFAULT_ERROR_CODE,DEFAULT_ERROR_MESSAGE);
	}

	public ServiceException(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1501964083736226899L;

	private static final String DEFAULT_ERROR_MESSAGE="Fatal Service failure in businsess layer due to unknown reasons";
	private static final int DEFAULT_ERROR_CODE=org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value();
	
	public ServiceException(String message)
	{
		super(message);
	}

	
	public ServiceException(int code,String message,final Throwable throwable) {
		super(code, message,throwable);
		// TODO Auto-generated constructor stub
	}
}
