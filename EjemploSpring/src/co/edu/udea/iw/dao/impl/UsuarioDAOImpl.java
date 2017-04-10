/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private SessionFactory sessionFactory;	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return un usuario dada su clave
	 */
	@Override
	public Usuario obtener(String login) throws MyException {
		Usuario usuario = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			usuario = (Usuario) session.get(Usuario.class, login);
		} catch(HibernateException e) {
			throw new MyException("Error consultando el usuario", e);
		}
		return usuario;
	}

}
