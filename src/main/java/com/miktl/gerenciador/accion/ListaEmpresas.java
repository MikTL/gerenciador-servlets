package com.miktl.gerenciador.accion;


import java.util.List;

import com.miktl.gerenciador.modelo.DB;
import com.miktl.gerenciador.modelo.Empresa;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas implements Accion{
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Empresa> listEmpresas= DB.getListaEmpresas();
		request.setAttribute("listaEmpresas", listEmpresas);
		return "forward:listaEmpresas.jsp";
	}
}
