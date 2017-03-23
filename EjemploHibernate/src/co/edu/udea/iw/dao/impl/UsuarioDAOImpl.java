/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * @version 1.0
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO{
	
	/**
	 * @return un usuario dada su clave
	 */
	@Override
	public Usuario obtener(String login) throws MyException {
		Usuario usuario = null;
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			usuario = (Usuario) session.get(Usuario.class, login);
		} catch(HibernateException e) {
			throw new MyException("Error consultando el usuario", e);
		}
		return usuario;
	}

}
