package com.miktl.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//Comentamos la anotación para deficir el orden de los filtros a traves del xml
//@WebFilter (urlPatterns = "/entrada")
public class MonitoreoFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Monitoreo Filter");
		long antes = System.currentTimeMillis();
		String accion=request.getParameter("accion");
		chain.doFilter(request, response);
		
		long despues = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion de la accion: "+accion+" -> "+ (despues-antes));
	}
}
