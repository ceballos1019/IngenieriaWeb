/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface para definir los métodos del cliente en el sistema
 * @author andres.ceballoss
 * @version 1.0
 *
 */
public interface ClienteDAO {
	
	/**
	 * Enrega la lista de clientes ordenados por su fecha de creacion
	 * @return LIsta de clientes
	 * @throws MyException Cuando hay un error en la consulta 
	 * 
	 */
	public List<Cliente> obtener() throws MyException;
	
	/**
	 * Crear un cliente en la base de datos
	 * @param cliente
	 * @throws MyException
	 */
	public void guardar(Cliente cliente) throws MyException;

}
