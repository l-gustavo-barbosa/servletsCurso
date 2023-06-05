package Acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class RemoveEmpresas {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
