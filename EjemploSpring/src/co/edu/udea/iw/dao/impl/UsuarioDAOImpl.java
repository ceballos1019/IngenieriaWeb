/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de {@link UsuarioDAO}
 * @author Andrés Ceballos Sánchez - andres.ceballos@udea.edu.co
 * @see UsuarioDAO
 * @version 1.0
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
	 * Implementación del método obtener(String)
	 * Retorna un usuario dado su login o nombre de usuario
	 * @return Usuario
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

	/**
	 * Implementacion del metodo obtener()
	 * Retorna una lista de los usuarios disponibles en la base de datos
	 * @return Lista de usuarios 
	 */
	@Override
	public List<Usuario> obtener() throws MyException {
		List<Usuario> usuarios = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando usuarios", e);
		}
		return usuarios;
	}
	
	/**
	 * Implementación del metodo guardar(Usuario) 
	 * Guarda un usuario en la base de datos
	 * @param usuario - usuario a guardar
	 */
	@Override
	public void guardar(Usuario usuario) throws MyException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(usuario);			
			session.flush();  //Esta linea para poder que siempre me guardara en la base de datos
		} catch(HibernateException e) {
			throw new MyException("Error guardando el usuario", e);			
		} 
	}
	
	

}
