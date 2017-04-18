/**
 * 
 */
package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase para implementar todo los metodos de la logica de negocio correspondientes con el cliente
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0 
 */

public class ClienteBL {
	
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
		
	/**
	 * @return the clienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}


	/**
	 * @param clienteDAO the clienteDAO to set
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	
	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	/**
	 * Retornar la lista de los clientes almacenados en la base de datos
	 * @return lista de clientes
	 * @throws MyException
	 */
	public List<Cliente> obtener() throws MyException {
		return clienteDAO.obtener();
	}
	
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea) throws MyException{
		
		if(cedula.isEmpty() || cedula == null) {
			throw new MyException("La cedula no puede estar vacia");			
		}
		
		if(nombres.isEmpty() || nombres == null) {
			throw new MyException("El campo 'nombres' no puede estar vacio");			
		}
		
		if(apellidos.isEmpty() || apellidos == null) {
			throw new MyException("El campo 'apellidos' no puede estar vacio");			
		}
		
		if(email.isEmpty() || email == null) {
			throw new MyException("El campo 'email' no puede estar vacio");			
		}
		
		if(usuarioCrea.isEmpty() || usuarioCrea == null) {
			throw new MyException("El campo 'usuarioCrea' no puede estar vacio");			
		}		
		
		/*Validar que el usuarioCrea exista en la base de datos*/
		Usuario usuario = usuarioDAO.obtener(usuarioCrea);
		if(usuario == null) {
			throw new MyException("UsuarioCrea no existe en el sistema");
		}
		
		/* FALTA: VALIDAR EL FORMATO DEL EMAIL*/
		/* FALTA: VALIDAR TAMAÑOS DE LOS CAMPOS*/
		/* FALTA: VALIDAR QUE NO SE INTENTE INSERTAR UN CLIENTE CON UNA PK QUE YA EXISTE*/
		
		/*Crear el cliente y guardarlo*/
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDAO.guardar(cliente);
		
		
	}

}
