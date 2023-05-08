package com.miktl.gerenciador.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//Comentamos la anotación para deficir el orden de los filtros a traves del xml
//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Autorización Filter");
		HttpServletRequest request= (HttpServletRequest) servletRequest;
		HttpServletResponse response= (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("accion");
		
		HttpSession session= request.getSession();
		
		boolean isInvalidUser = (session.getAttribute("loginUsuario")==null);
		boolean isProtectedAction= !(paramAction.equals("Login")|| paramAction.equals("LoginForm"));
		
		if(isInvalidUser && isProtectedAction) {
			System.out.println("User invalido");
			response.sendRedirect("entrada?accion=LoginForm") ;
			return;
		}
		
		chain.doFilter(request, response);
	}

}
