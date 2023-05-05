package com.miktl.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.miktl.gerenciador.accion.Accion;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
