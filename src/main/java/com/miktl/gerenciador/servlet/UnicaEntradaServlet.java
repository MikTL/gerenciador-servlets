package com.miktl.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.miktl.gerenciador.accion.Accion;
import com.miktl.gerenciador.accion.EliminarEmpresa;
import com.miktl.gerenciador.accion.ListaEmpresas;
import com.miktl.gerenciador.accion.ModificarEmpresa;
import com.miktl.gerenciador.accion.MostrarEmpresa;
import com.miktl.gerenciador.accion.NuevaEmpresa;
import com.miktl.gerenciador.accion.NuevaEmpresaForm;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("accion");
		String nombreClase="com.miktl.gerenciador.accion."+paramAction;
		
		String nombre;
		try {
			Class clase	= Class.forName(nombreClase);
			Accion accion= (Accion)clase.newInstance();
			nombre = accion.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		/*
		if(paramAction.equals("ListaEmpresas")) {
			System.out.println("Listando empresas :V");
			ListaEmpresas accion= new ListaEmpresas();
			nombre=accion.ejecutar(request,response);
		}else if(paramAction.equals("MostrarEmpresa")) {
			MostrarEmpresa mostrarEmpresa= new MostrarEmpresa();
			nombre= mostrarEmpresa.ejecutar(request, response);
		}else if(paramAction.equals("EliminarEmpresa")) {
			EliminarEmpresa empresa= new EliminarEmpresa();
			nombre=empresa.ejecutar(request, response);
		}else if(paramAction.equals("ModificarEmpresa")) {
			ModificarEmpresa modificarEmpresa= new ModificarEmpresa();
			nombre=modificarEmpresa.ejecutar(request, response);
		}else if(paramAction.equals("NuevaEmpresa")) {
			NuevaEmpresa nuevaEmpresa= new NuevaEmpresa();
			nombre= nuevaEmpresa.ejecutar(request, response);
		}else if(paramAction.equals("NuevaEmpresaForm")) {
			NuevaEmpresaForm nuevaEmpresaForm= new NuevaEmpresaForm();
			nombre= nuevaEmpresaForm.ejecutar(request, response);
		}
		*/
		
		String[] tipoYDireccion=nombre.split(":");
		
		if(tipoYDireccion[0].equals("forward")) {
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/views/"+tipoYDireccion[1]);
			requestDispatcher.forward(request, response);
		}else {
			response.sendRedirect(tipoYDireccion[1]);
		}
		
		
		
	}

}
