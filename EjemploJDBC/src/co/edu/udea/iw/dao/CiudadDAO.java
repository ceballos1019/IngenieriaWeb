/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * @version 1.0
 */
public interface CiudadDAO {
	
	/**
	 * @return La lista completa de las ciudades de la BD
	 * @throws MyException
	 */
	public List<Ciudad> obtener() throws MyException;
}
