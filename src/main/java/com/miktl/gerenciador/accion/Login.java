package com.miktl.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login implements Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramUsername= request.getParameter("nombre");
		String paramContrasena= request.getParameter("contrasena");
		
		System.out.println("Login: "+paramUsername+": "+paramContrasena);
		
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
