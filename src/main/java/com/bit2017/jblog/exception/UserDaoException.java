package com.bit2017.jblog.exception;

public class UserDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5744755677552207012L;

	public UserDaoException(String message) {
		super(message);
	}

	public UserDaoException() {
		super("UserDao Exception Occurs");
		
	}
}
