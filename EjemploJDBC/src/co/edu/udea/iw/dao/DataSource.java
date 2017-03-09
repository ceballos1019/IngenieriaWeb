/**
 * 
 */
package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * Entrega conexiones activas de la base de datos
 *
 */
public class DataSource {

	//Retorna un objeto de tipo Connection
	public static Connection getConnection() throws MyException{
		Connection con = null;
		try{
			//Valida que el driver este cargado
			Class.forName("com.mysql.jdbc.Driver");  
			//Abrir conexión a la base de datos
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceballos","root","root"); 			
		}catch(ClassNotFoundException e){
			throw new MyException("Driver no encontrado",e);
		}catch(SQLException e){
			throw new MyException("No se puede establecer conexión",e);
		}
		return con;
	}
}
