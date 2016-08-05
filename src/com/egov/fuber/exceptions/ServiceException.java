/**
 * 
 */
package com.egov.fuber.exceptions;

/**
 * @author Manoj Kulkarni
 *
 */
public class ServiceException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3871804935253842809L;

	/**
	 * 
	 */
	public ServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ServiceException(Throwable message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
