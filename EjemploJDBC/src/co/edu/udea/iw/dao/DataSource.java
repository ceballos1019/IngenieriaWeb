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
 * @version 1.0 Entrega conexiones activas de la base de datos
 *
 */
public class DataSource {

	private static Connection connection; // Singleton connection

	/**
	 * 
	 * @return un objeto de tipo Connection
	 * @throws MyException
	 */
	public static Connection getConnection() throws MyException {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				// Abrir conexión a la base de datos
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceballos", "root", "root");
			}
		} catch (ClassNotFoundException e) {
			throw new MyException("Driver no encontrado", e);
		} catch (SQLException e) {
			throw new MyException("No se puede establecer conexión", e);
		}
		return connection;

	}
}
