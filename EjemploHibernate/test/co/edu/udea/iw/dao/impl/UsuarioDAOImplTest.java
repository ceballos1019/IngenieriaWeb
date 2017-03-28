package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOImplTest {

	@Test
	public void testObtener() {
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		String loginTest = "elver";
		try {
			usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.obtener(loginTest);
			assertNotNull(usuario);
			
			/*Imprimir en consola*/
			StringBuilder output = new StringBuilder();
			output.append("Usuario: ").append(usuario.getLogin()).append(" - Rol: ").append(usuario.getRol().getNombre());
			//output.append("Usuario: ").append(usuario.getLogin());
			System.out.println(output.toString());
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
