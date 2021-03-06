/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:SpringConfig.xml") 
public class ClienteDAOImplTest {

	@Autowired
	private ClienteDAO clienteDAO;
	
	
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.ClienteDAOImpl#obtener()}.
	 */
	@Test
	public void testObtener() {
		List<Cliente> resultado = null;
		
		try {
			resultado = clienteDAO.obtener();					
			assertTrue(resultado.size() > 0);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.ClienteDAOImpl#obtener(java.lang.String)}.
	 * Probar que para una cedula dada, trae un cliente no nulo
	 */
	@Test
	public void testObtenerString() {		
		Cliente cliente = null;
		String cedulaTest = "19";
		try {
			cliente = clienteDAO.obtener(cedulaTest);
			assertNotNull(cliente);			
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.ClienteDAOImpl#guardar(co.edu.udea.iw.dto.Cliente)}.
	 *  Probar que no se arrojen excepciones durante la creacion de una usuario
	 */
	@Test
	@Rollback(false)
	public void testGuardar() {
		Cliente cliente = null;
		Usuario usuario = null;
		try {
			/*Crear cliente y settear los atributos*/
			cliente = new Cliente();
			cliente.setCedula("10");
			cliente.setNombres("Andres");
			cliente.setApellidos("Ceballos Sanchez");
			cliente.setEmail("ceballos@gmail.com");
			
			/*Crear el usuario, solo necesito el login*/
			usuario = new Usuario();
			usuario.setLogin("elver");			
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
			
			/*Guardar el cliente*/
			clienteDAO.guardar(cliente);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
