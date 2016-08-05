/**
 * 
 */
package com.egov.fuber.exceptions;

/**
 * @author Manoj Kulkarni
 *
 */
public class PersistException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PersistException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public PersistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public PersistException(Throwable message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PersistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
