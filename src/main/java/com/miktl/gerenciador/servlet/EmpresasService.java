package com.miktl.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Empresa;
import com.thoughtworks.xstream.XStream;

public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas= DB.getListaEmpresas();
		
		String valor= request.getHeader("Accept");
		if(valor.contains("xml")) {
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml= xStream.toXML(empresas);
			//Especificamos que tipo de contenido enviaremos
			response.setContentType("Application/xml");
			response.getWriter().print(xml);
		}else if(valor.contains("json")) {
			Gson gson= new Gson();
			String json= gson.toJson(empresas);
			//Especificamos que tipo de contenido enviaremos
			response.setContentType("Application/json");
			response.getWriter().print(json);
		}
		
	}

}
