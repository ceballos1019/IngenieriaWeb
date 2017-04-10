/**
 * 
 */
package co.edu.udea.iw.dto;

/**
 * Clase DTO para la tabla roles
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public class Rol {
	
	/*Atributos de la clase*/
	private String codigo;
	private String nombre;
	
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
