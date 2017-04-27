/**
 * 
 */
package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para la tabla clientes * 
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
@XmlRootElement
public class ClienteJersey {

	/* Atributos que quiero mostrar del Cliente */
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;

	
	
	
	
	/**
	 * 
	 */
	public ClienteJersey() {
		super();
	}

	/**
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 */
	public ClienteJersey(String cedula, String nombres, String apellidos, String email) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
