/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

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
	
	@Test
	public void testObtener() {		
		Usuario usuario = null;
		String loginTest = "elver";
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
}
