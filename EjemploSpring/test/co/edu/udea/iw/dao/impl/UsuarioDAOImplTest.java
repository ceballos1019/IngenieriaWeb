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

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.util.encode.Cifrado;

/**
 * @author andres.ceballoss
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class UsuarioDAOImplTest {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.UsuarioDAOImpl#obtener(java.lang.String)}.
	 * Probar que para un nombre de usuario dado, trae el usuario que corresponde a ese nombre de usuario
	 */
	@Test
	public void testObtenerString() {		
		Usuario usuario = null;
		String loginTest = "test";
		try {
			usuario = usuarioDAO.obtener(loginTest);
			assertNotNull(usuario);

			/* Imprimir en consola */
			StringBuilder output = new StringBuilder();
			output.append("Usuario: ").append(usuario.getLogin()).append(" - Rol: ")
					.append(usuario.getRol().getNombre());
			// output.append("Usuario: ").append(usuario.getLogin());
			System.out.println(output.toString());
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.UsuarioDAOImpl#obtener()}.
	 * Probar que trae al menos un usuario de la base de datos
	 */
	@Test
	public void testObtener() {
		List<Usuario> usuarios = null;
		try{
			usuarios = usuarioDAO.obtener();
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getNombres());
			}
			assertTrue(usuarios.size() > 0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.ClienteDAOImpl#guardar(co.edu.udea.iw.dto.Cliente)}.
	 *  Probar que no se arrojen excepciones durante la creacion de una usuario
	 */
	@Test
	@Rollback(false)  //Para que los cambios tengan efectos en la base de datos
	public void testGuardar() {
		Usuario usuario = null;
		Rol rol = null;
		try {
			/*Crear usuario y settear los atributos*/
			usuario = new Usuario();
			usuario.setLogin("test");
			usuario.setNombres("Andres");
			usuario.setApellidos("Ceballos");
			Cifrado c = new Cifrado();			
			usuario.setContrasena(c.encrypt("123456789"));			
			
			/*Crear el Rol, solo necesito el codigo*/
			rol = new Rol();
			rol.setCodigo("AUD");						
			usuario.setRol(rol);
			
			
			/*Guardar el usuario*/
			usuarioDAO.guardar(usuario);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
}
