package Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramAcao = req.getParameter("acao");
		if(paramAcao.equals("ListaEmpresas")) {
			
		} else if(paramAcao.equals("RemoveEmpresas")) {
			
		}else if(paramAcao.equals("AlteraEmpresa")) {
			
		}
	}

}



