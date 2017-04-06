/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
import javassist.ClassPath;

/**
 * @author andres.ceballoss
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) //Correr la prueba usando este runner de Spring
@Transactional   //Es una clase que va a realizar transacciones
//Decirle a Spring donde esta el archivo de configuración para que cargue al inicio.
//classpath es para que se ubique en el src
@ContextConfiguration(locations = "classpath:SpringConfig.xml") 
public class CiudadDAOImplTest {
	
	@Autowired  //Para indicarle a Spring que lo inyecte - Inicializa la variable
	private CiudadDAO ciudadDAO;	

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtener()}.
	 */
	@Test
	public void testObtener() {		
		List<Ciudad> ciudades = null;
		try{
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
		Ciudad ciudad = null;
		try {
			ciudad = ciudadDAO.obtener(1L);
			assertEquals(ciudad.getNombre(), "Medellin");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
