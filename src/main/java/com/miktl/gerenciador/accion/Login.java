package com.miktl.gerenciador.accion;

import java.io.IOException;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Usuarios;

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
		DB db= new DB();
		Usuarios usuario= db.existeUsuario(paramUsername,paramContrasena);
		if(usuario != null) {
			System.out.println("Usuario Valido");
			return "redirect:entrada?accion=ListaEmpresas";			
		}else {
			return "redirect:entrada?accion=LoginForm";			
		}
	}
}
