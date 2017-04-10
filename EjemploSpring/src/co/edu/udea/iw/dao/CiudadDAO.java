/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Define los métodos para acceder a las Ciudades
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public interface CiudadDAO {
	
	/**
	 * Entrega la lista de ciudades disponibles en la base de datos
	 * @return Lista de Ciudades
	 * @throws MyException
	 */
	public List<Ciudad> obtener() throws MyException;
	
	/**
	 * Entrega los datos de una ciudad dado su código
	 * @param codigo
	 * @return una Ciudad
	 * @throws MyException
	 */
	public Ciudad obtener(Long codigo) throws MyException;
	
	/**
	 * Permite crear una nueva ciudad en la base de datos
	 * @param ciudad - DTO con los datos de la ciudad a crear
	 * @throws MyException
	 */
	public void guardar(Ciudad ciudad) throws MyException;
	
	
}