package com.miktl.gerenciador.accion;

import java.io.IOException;

import com.miktl.gerenciador.modelo.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa implements Accion{
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String paramId= request.getParameter("id");
		Integer id= Integer.valueOf(paramId);
		System.out.println("Eliminando la empresa con el id: "+id);
		DB db= new DB();
		db.eliminarEmpresa(id);
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
