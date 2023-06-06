package Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acao.Acao;


public class ControllerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAcao = request.getParameter("acao");

		String nomeClasse = "acao." + paramAcao;
		String nome = null;

		try {
			Class classe = Class.forName(nomeClasse);// carrega a classe com o nome
			Acao InterfaceAcao = (Acao) classe.newInstance();
			;
			nome = InterfaceAcao.executa(request, response);

			String[] tipoEndereco = nome.split(":");
			if (tipoEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEndereco[1]);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

	}

}

/*
 * switch(paramAcao) { case "ListaEmpresas": ListaEmpresas acao = new
 * ListaEmpresas(); acao.executa(req, resp); break; case "RemoveEmpresas":
 * System.out.println("Remove"); break; case "AlteraEmpresa":
 * System.out.println("altera"); break; }
 */
