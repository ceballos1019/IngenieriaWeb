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
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementaci�n de {@link ClienteDAO}
 * @author Andr�s Ceballos S�nchez - andres.ceballos@udea.edu.co
 * @see UsuarioDAO
 * @version 1.0
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


	/**
	 * Implementacion del metodo obtener()
	 * Retorna una lista de los clientes disponibles en la base de datos
	 * @return Lista de clientes 
	 */
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
	
	/**
	 * Implementaci�n del m�todo obtener(String)
	 * Retorna un cliente dada su cedula
	 * @return Cliente
	 */
	@Override
	public Cliente obtener(String cedula) throws MyException {
		Cliente cliente = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			cliente = (Cliente) session.get(Cliente.class, cedula);
		} catch(HibernateException e) {
			throw new MyException("Error consultando el cliente", e);
		}
		return cliente;
	}
	
	/**
	 * Implementaci�n del metodo guardar(Cliente) 
	 * Guarda un cliente en la base de datos
	 * @param cliente - cliente a guardar
	 */
	@Override
	public void guardar(Cliente cliente) throws MyException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(cliente);			
			//session.flush();  //Esta linea para poder que siempre me guardara en la base de datos
		} catch(HibernateException e) {
			throw new MyException("Error guardando el cliente", e);			
		} 
	}	

}
