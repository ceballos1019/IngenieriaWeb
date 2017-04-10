/**
 * 
 */
package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase DTO para la clave primaria de la tabla direcciones
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public class DireccionId implements Serializable{
	
	private Long codigo;
	private Cliente cliente;
	
	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
