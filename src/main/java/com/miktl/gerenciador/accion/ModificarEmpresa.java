package com.miktl.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresa {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Empresa modificada");
		String nombreEmpresa= request.getParameter("nombre");
		String fechaObtenida= request.getParameter("fecha");
		Integer id= Integer.valueOf(request.getParameter("id"));
		
		Date fechaApertura= null;
		try{
		    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		    fechaApertura= sdf.parse(fechaObtenida);
		} catch(ParseException e){
		    throw new ServletException(e);
		}
		DB db= new DB();
		Empresa empresa= db.buscarEmpresaPorId(id);
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaApertura(fechaApertura);
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
