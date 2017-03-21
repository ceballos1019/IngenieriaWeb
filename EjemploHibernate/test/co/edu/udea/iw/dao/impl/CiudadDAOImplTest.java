/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */
public class CiudadDAOImplTest {

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtener()}.
	 */
	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<Ciudad> ciudades = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size() > 0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtener(java.lang.Long)}.
	 */
	@Test
	public void testObtenerLong() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try {
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1L);
			assertEquals(ciudad.getNombre(), "Medellin");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#guardar(co.edu.udea.iw.dto.Ciudad)}.
	 */
	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#actualizar(co.edu.udea.iw.dto.Ciudad)}.
	 */
	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

}
