/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * @version 1.0
 *
 */
public class CiudadDAOImpl implements CiudadDAO {

	/**
	 * @return Lista de ciudades Implementación del método obtener
	 */
	@Override
	public List<Ciudad> obtener() throws MyException {
		PreparedStatement ps = null; // Realiza la consulta
		Connection con = null; // Realiza la conexión a la base de datos
		ResultSet rs = null; // Almacena el resultado de la consulta
		List<Ciudad> ciudades = new ArrayList<>();
		try {
			con = DataSource.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				ciudades.add(ciudad);
			}
		} catch (SQLException e) {
			throw new MyException("Error consultando", e);
		} finally {
			try {
				/*
				 * Cerrar el ResultSet, la sentencia y la conexión a la base de
				 * datos
				 */
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudades;
	}

	/**
	 * @return una Ciudad Obtiene una ciudad dada la clave
	 */
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		PreparedStatement ps = null; // Realiza la consulta
		Connection con = null; // Realiza la conexión a la base de datos
		ResultSet rs = null; // Almacena el resultado de la consulta
		Ciudad ciudad = null;
		try {
			con = DataSource.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo = ?");
			ps.setLong(1, codigo);  //Evita SQL Injection
			rs = ps.executeQuery();
			if (rs.next()) {
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		} catch (SQLException e) {
			throw new MyException("Error consultando", e);
		} finally {
			try {
				/*
				 * Cerrar el ResultSet, la sentencia y la conexión a la base de
				 * datos
				 */
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudad;
	}

}
