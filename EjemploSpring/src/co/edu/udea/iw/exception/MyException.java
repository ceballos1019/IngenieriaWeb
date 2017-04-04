/**
 * 
 */
package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

/**
 * @author andres.ceballoss
 * @version 1.0
 * Clase para manejar nuestras propias excepciones
 */
public class MyException extends Exception{

	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 */
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);

	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
