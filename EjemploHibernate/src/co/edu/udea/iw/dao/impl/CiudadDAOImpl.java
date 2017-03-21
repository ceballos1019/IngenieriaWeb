/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */
public class CiudadDAOImpl implements CiudadDAO {

	/**
	 * @return Lista de ciudades Implementación del método obtener
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> ciudades = new ArrayList<>();
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			ciudades = (List<Ciudad>) criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}
		return ciudades;
	}

	/**
	 * @return una ciudad dado su codigo
	 */
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		Ciudad ciudad = null;
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
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
	 * Guarda una ciudad en la base de datos
	 */
	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		Transaction tx = null;		
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
		} catch(HibernateException e) {
			throw new MyException("Error guardando la ciudad", e);			
		}
	}
	
	@Override
	public void actualizar(Ciudad ciudad) throws MyException {
		return;
	}

}
