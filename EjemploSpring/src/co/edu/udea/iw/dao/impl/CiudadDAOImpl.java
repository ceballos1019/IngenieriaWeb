package co.edu.udea.iw.dao.impl;
/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementaci�n de {@link CiudadDAO}
 * @author Andr�s Ceballos S�nchez - andres.ceballos@udea.edu.co
 * @see UsuarioDAO
 * @version 1.0
 */
public class CiudadDAOImpl implements CiudadDAO {
	
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
	 * Implementacion del metodo obtener()
	 * Retorna una lista de las ciudades disponibles en la base de datos
	 * @return Lista de ciudades 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> ciudades = new ArrayList<>();
		Session session = null;
		try {
			/*No hay necesidad de cerrar la sesion, Spring se encarga de eso*/
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			ciudades = (List<Ciudad>) criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}
		return ciudades;
	}

	/**
	 * Implementaci�n del m�todo obtener(Long)
	 * Retorna una ciudad dado su codigo
	 * @return Ciudad
	 */
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		Ciudad ciudad = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();			
			/*No es la mejor forma
			Criteria criteria = session.createCriteria(Ciudad.class).add(Restrictions.eq("codigo", codigo));
			ciudad = (Ciudad) criteria.uniqueResult();*/				
			/*get retorna null cuando no encuentra los datos, load retorna una excepcion cuando no lo encuentra*/
			ciudad = (Ciudad) session.get(Ciudad.class, codigo);
			//ciudad = (Ciudad) session.load(Ciudad.class, codigo);
		} catch (HibernateException e) {
			throw new MyException("Error consultando la ciudad", e);
		}
		return ciudad;
	}
	
	/**
	 * Implementaci�n del metodo guardar(Ciudad) 
	 * Guarda una ciudad en la base de datos
	 * @param ciudad - ciudad a guardar
	 */
	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(ciudad);			
			//session.flush();   //Esta linea para poder que siempre me guardara en la base de datos
		} catch(HibernateException e) {
			throw new MyException("Error guardando la ciudad", e);			
		}
	}		

}
