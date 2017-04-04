/**
 * 
 */
package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * @author andres.ceballoss
 *
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
