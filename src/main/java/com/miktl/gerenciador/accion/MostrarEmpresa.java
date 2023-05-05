package com.miktl.gerenciador.accion;

import java.io.IOException;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresa {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String paramId= request.getParameter("id");
		Integer id= Integer.valueOf(paramId);
		System.out.println("Mostrando empresa "+id+" para editar");
		DB db= new DB();
		Empresa empresa= db.buscarEmpresaPorId(id);
		System.out.println(empresa.getNombre());
		request.setAttribute("empresa", empresa);
		return "forward:formModificarEmpresa.jsp";
	}
}
