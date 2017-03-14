package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author andres.ceballoss
 * @version 1.0
 * Pruebas unitarias a la clase CiudadDAOImpl
 */
public class CiudadDAOImplTest {
	
	/*Prueba para verificar que el método obtener retorne una lista con al menos una ciudad*/
	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<Ciudad> ciudades = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size() > 0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}
	
	/*Prueba para verificar que el método obtener retorna una ciudad especifica*/
	@Test
	public void testObtenerPorClave(){
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1l);
			assertEquals(ciudad.getNombre(),"Medellin");
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}

}
