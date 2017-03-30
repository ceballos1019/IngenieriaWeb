package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void testObtener() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try {
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			
			for(Cliente cliente: resultado) {
				System.out.println(new StringBuffer(cliente.getNombres()).append(" ").append(cliente.getApellidos()));
			}
			
			assertTrue(resultado.size() > 0);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {
		Cliente cliente = null;
		ClienteDAO clienteDAO = null;
		Usuario usuario = null;
		try {
			/*Crear cliente y settear los atributos*/
			cliente = new Cliente();
			cliente.setCedula("1");
			cliente.setNombres("Daniel");
			cliente.setApellidos("Pelaez");
			cliente.setEmail("pelaez@gmail.com");
			
			/*Crear el usuario, solo necesito el login*/
			usuario = new Usuario();
			usuario.setLogin("elver");			
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
			
			/*Guardar el cliente*/
			clienteDAO = new ClienteDAOImpl();
			clienteDAO.guardar(cliente);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
