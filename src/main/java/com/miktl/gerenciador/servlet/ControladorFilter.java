package com.miktl.gerenciador.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.miktl.gerenciador.accion.Accion;

//Comentamos la anotación para deficir el orden de los filtros a traves del xml
//@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Controlador Filter");
		HttpServletRequest request= (HttpServletRequest) servletRequest;
		HttpServletResponse response= (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("accion");
		String nombreClase="com.miktl.gerenciador.accion."+paramAction;
		
		String nombre=null;
		try {
			Class<?> clase = Class.forName(nombreClase);
			Accion accion = (Accion) clase.getDeclaredConstructor().newInstance();
			nombre = accion.ejecutar(request, response);
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] tipoYDireccion=nombre.split(":");
		
		if(tipoYDireccion[0].equals("forward")) {
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/"+tipoYDireccion[1]);
			requestDispatcher.forward(request, response);
		}else {
			response.sendRedirect(tipoYDireccion[1]);
		}
	}
}
