package com.miktl.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//esto es la ruta para el navegador: o sea https://localhost:8080/nameproject/hola
@WebServlet(urlPatterns = "/hola") 

public class HolaMundoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= res.getWriter();
		out.println("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\" />\n"
				+ "    <title>Document</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <h1>Hola desde Tomcat LPRTM y</h1>\n"
				+ "<h2>Creaste tu primer Servlet</h2>"
				+ "</body>\n"
				+ "</html>");
	}
}
