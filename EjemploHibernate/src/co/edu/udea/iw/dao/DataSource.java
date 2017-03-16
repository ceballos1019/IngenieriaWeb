/**
 * 
 */
package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * @version 1.0 Clase que entrega sesiones (conexiones) activas a la base de
 *          datos
 */
public class DataSource {

	private static DataSource dsInstance; //Singleton
	private SessionFactory factory = null; // Crear Sessions de Hibernate
	private Configuration config = new Configuration(); // Cargar la configuracion de Hibernate

	private DataSource() {
	}

	/**
	 * 
	 * @return the instance of the class
	 */
	public static DataSource getInstance() {
		if (dsInstance == null) {
			dsInstance = new DataSource();
		}

		return dsInstance;
	}
	
	/**
	 * 
	 * @return sesiones activas a la base de datos
	 * @throws MyException
	 */
	public Session getSession() throws MyException {
		try {
			/*Si es primera vez que se va a crear una sesión*/
			if (factory == null) {
				config.configure("co/edu/udea/iw/configuration/hibernate.cfg.xml");
				factory = config.buildSessionFactory();
			}
			return factory.openSession();
		} catch (HibernateException e) {
			throw new MyException("Error configurando la sesión", e);
		}
	}
}
