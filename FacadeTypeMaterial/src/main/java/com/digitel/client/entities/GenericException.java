package com.digitel.client.entities;

import java.io.Serializable;

public class GenericException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865878317064212770L;
	private String codigo;
	private String descripcion;
	
	public GenericException(String codigo) {
		this.codigo = codigo;
	}
	
	public GenericException(String codigo, Throwable t) {
		super(t);
		this.codigo = codigo;
	}
	
	public GenericException(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public GenericException() {
		super();
	}
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
