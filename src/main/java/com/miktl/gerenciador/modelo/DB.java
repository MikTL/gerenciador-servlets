package com.miktl.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB {
	private static List<Empresa> listaEmpresas= new ArrayList<>();	
	private static List<Usuarios> listaUsuarios= new ArrayList<>();	
	private static Integer llaverSecuencial= 1;
	static {
		Empresa empresa= new Empresa();
		empresa.setId(DB.llaverSecuencial++);
		empresa.setNombre("Alura");
		Empresa empresa2= new Empresa();
		empresa2.setId(DB.llaverSecuencial++);
		empresa2.setNombre("Claro");
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
		Usuarios u1= new Usuarios("admin","admin123");
		Usuarios u2= new Usuarios("miktl","mik123");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	public void agregarEmpresa(Empresa empresa) {
		empresa.setId(DB.llaverSecuencial);
		DB.listaEmpresas.add(empresa);
	}
	public static List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	public void eliminarEmpresa(Integer id) {
		Iterator<Empresa> it=listaEmpresas.iterator();
		while(it.hasNext()) {
			Empresa emp= it.next();
			if(emp.getId()==id) {
				it.remove();
			}
		}
	}
	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId()==id) {
				return empresa;
			}
		}
		return null;
	}	
}
