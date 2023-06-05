package Acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class ListaEmpresas {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Banco banco = new Banco();
			List<Empresa> lista = banco.getEmpresas();
			request.setAttribute("empresas", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpresas.jsp");
			
			rd.forward(request, response);
		}
}