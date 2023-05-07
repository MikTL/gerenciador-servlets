package com.miktl.gerenciador.accion;

import java.io.IOException;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Usuarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			
			// Guardamos el usuario en la sesión para que sea visible durante toda la sesion del usuario
			HttpSession session= request.getSession();
			session.setAttribute("loginUsuario", usuario);
			
			return "redirect:entrada?accion=ListaEmpresas";			
		}else {
			return "redirect:entrada?accion=LoginForm";			
		}
	}
}
