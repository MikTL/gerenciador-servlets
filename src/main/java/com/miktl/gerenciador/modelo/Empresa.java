package com.miktl.gerenciador.modelo;

import java.util.Date;

public class Empresa {
	private String nombre;
	private Integer id;
	private Date fechaApertura = new Date();
	public String getNombre() {
		return nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
}
