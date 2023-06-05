package Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Acao.AlteraEmpresas;
import Acao.ListaEmpresas;
import Acao.MostraEmpresa;
import Acao.NovaEmpresa;
import Acao.RemoveEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramAcao = req.getParameter("acao");
		String nome = null;
		if(paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(req, resp);
				
		} else if(paramAcao.equals("RemoveEmpresas")) {
			RemoveEmpresas acao = new RemoveEmpresas();
			nome = acao.executa(req, resp);
			
		}else if(paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresas acao = new AlteraEmpresas();
			nome = acao.executa(req, resp);
		} else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(req, resp);
		}else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(req, resp);
			
		}
		
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = req.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(req, resp);
		} else {
			resp.sendRedirect(tipoEndereco[1]);
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


