package co.edu.udea.iw.dto;
/**
 * 
 * @author andres.ceballoss
 * @version 1.0
 *
 */
public class Ciudad {
	
	/*Atributos de la clase*/	
	private Long codigo; 
	private String nombre;
	private String codigoArea;
	
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
	
	/**
	 * @return the codigoArea
	 */
	public String getCodigoArea() {
		return codigoArea;
	}
	
	/**
	 * @param codigoArea the codigoArea to set
	 */
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	
	
}
