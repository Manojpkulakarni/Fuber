/**
 * 
 */
package com.egov.fuber.exceptions;

/**
 * @author Manoj Kulkarni
 *
 */
public class FetchException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FetchException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FetchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FetchException(Throwable message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FetchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
