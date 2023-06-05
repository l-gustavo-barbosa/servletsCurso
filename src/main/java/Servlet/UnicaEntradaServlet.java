package Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramAcao = req.getParameter("acao");
		HttpSession sessao = req.getSession();
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoProibida = !(paramAcao.contains("Login"));
		
		if(usuarioNaoLogado && acaoProibida) {
			resp.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		
		String nomeClasse = "acao." + paramAcao;
		String nome = null;
		
		try {
			Class classe = Class.forName(nomeClasse);//carrega a classe com o nome 
			Acao InterfaceAcao = (Acao) classe.newInstance();;
			nome = InterfaceAcao.executa(req, resp);

			String[] tipoEndereco = nome.split(":");
			if(tipoEndereco[0].equals("forward")) {
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
				rd.forward(req, resp);
			} else {
				resp.sendRedirect(tipoEndereco[1]);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		


	}

}

/*switch(paramAcao) {
case "ListaEmpresas":
	ListaEmpresas acao = new ListaEmpresas();
	acao.executa(req, resp);
	break;
case "RemoveEmpresas":
	System.out.println("Remove");
	break;
case "AlteraEmpresa":
	System.out.println("altera");
	break;
}*/


