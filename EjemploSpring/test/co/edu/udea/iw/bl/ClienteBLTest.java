/**
 * 
 */
package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:SpringConfig.xml") 
public class ClienteBLTest {
	
	@Autowired
	private ClienteBL clienteBL;
	
	/**
	 * Test method for {@link co.edu.udea.iw.bl.ClienteBL#obtener()}.
	 * Probar que trae al menos una ciudad
	 */
	@Test
	public void testObtener() {
		List<Cliente> resultado = null;
		try {
			resultado = clienteBL.obtener();
			assertTrue(resultado.size() > 0);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
