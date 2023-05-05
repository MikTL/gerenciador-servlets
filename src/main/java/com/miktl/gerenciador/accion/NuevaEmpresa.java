package com.miktl.gerenciador.accion;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nombreEmpresa= request.getParameter("nombre");
		String fechaObtenida= request.getParameter("fecha");
		Date fechaAperturaEmpresa=null;
		try {
			Date fechaInput=null;
			String fechaApertura=null;
			DateFormat dateFormatInput= new	SimpleDateFormat("yyyy-MM-dd");
			fechaInput = dateFormatInput.parse(fechaObtenida);
			DateFormat dateFormatOutput= new SimpleDateFormat("dd-MM-yyyy");
			fechaApertura = dateFormatOutput.format(fechaInput);
			fechaAperturaEmpresa= dateFormatOutput.parse(fechaApertura);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		Empresa empresa= new Empresa();
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaApertura(fechaAperturaEmpresa);
		
		DB baseDeDatos= new DB();
		baseDeDatos.agregarEmpresa(empresa);

		System.out.println(fechaAperturaEmpresa);
		// una vez obtenemos la respuesta, la redireccionamos a listaEmpresas
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
