/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */
public class ClienteDAOImpl implements ClienteDAO {
	
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


	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes = null;
		Session session = null;
		Criteria criteria = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando la lista de clientes", e);
		}
		return clientes;
	}

	
	@Override
	public void guardar(Cliente cliente) throws MyException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(cliente);			
		} catch(HibernateException e) {
			throw new MyException("Error guardando el cliente", e);			
		} 
	}

}
