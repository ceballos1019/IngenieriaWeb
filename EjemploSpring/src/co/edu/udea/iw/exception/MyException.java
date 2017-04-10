/**
 * 
 */
package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Clase para manejar nuestras propias excepciones
 * @author andres.ceballoss
 * @version 1.0
 */
public class MyException extends Exception{

	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 */
	public MyException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
		PropertyConfigurator.configure("log4j.properties");
		log.error(message, cause);

	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
	}
	
	
}
